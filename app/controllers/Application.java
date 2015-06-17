package controllers;

import java.io.File;
import java.io.InputStream;

import buisness.rules.cell.style.LevelStyle4Adherant;
import models.FormattingRule;
import models.SheetDescription;
import models.WordDescription;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;
import views.html.index;
import views.html.indexWord;
import fr.diod.searchAdherants.excel.ExcelSearch;
import fr.diod.searchAdherants.excel.WordSearch;
import fr.diod.searchAdherants.excel.style.provider.LevelStyleProvider;
import fr.diod.searchAdherants.excel.style.provider.StyleProvider;

public class Application extends Controller {

	static Form<SheetDescription> sheetForm = play.data.Form.form(SheetDescription.class);
	static Form<WordDescription> wordForm = play.data.Form.form(WordDescription.class);

	public static Result index() {
		Logger.info("Index fills form");
		sheetForm = sheetForm.fill(new SheetDescription(true));
		return ok(index.render(sheetForm));
	}

	public static Result indexWord() {
		Logger.info("Index fills form");
		wordForm = wordForm.fill(new WordDescription());
		return ok(indexWord.render(wordForm));
	}
	
	//	@BodyParser.Of(BodyParser.MultipartFormData.class)
	public static Result upload() {
		Form<SheetDescription> formBinded = sheetForm.bindFromRequest();
		if (!formBinded.hasErrors()) {
			SheetDescription sheetDesc = formBinded.get();
			MultipartFormData body = request().body().asMultipartFormData();
			FilePart database = body.getFile("database");
			FilePart input = body.getFile("input");
			File dbFile = database.getFile();
			File inputFile = input.getFile();

			Logger.debug("Before Search >>>");
			StyleProvider provider = createProvider(sheetDesc);
			
			InputStream in = ExcelSearch.computeResult(dbFile, sheetDesc.sheetNumberDb, inputFile, sheetDesc.sheetNumberInput, provider);
			Logger.debug("<<< After search");
			
			return ok(in).as("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		} else {
			flash("error", "Missing file || Form error");
			return redirect(routes.Application.index());    
		}
	}

	private static StyleProvider createProvider(SheetDescription sheetDesc) {
		Logger.info("LevelStyleProvider creation");
		LevelStyleProvider levelStyleProvider = new LevelStyleProvider();
		Logger.info("min level = {}", sheetDesc.minLevelForComment);
		levelStyleProvider.setMinScoreForComments(sheetDesc.minLevelForComment);
		
		for (FormattingRule rule : sheetDesc.rules) {
			Logger.info("{} => color {}", rule.level, (short) rule.color);
			levelStyleProvider.addLevel(rule.level, (short) rule.color);
		}
		return levelStyleProvider;
	}
	
	public static Result uploadWord() {
		Form<WordDescription> formBinded = wordForm.bindFromRequest();
		if (!formBinded.hasErrors()) {
			WordDescription wordDesc = formBinded.get();
			MultipartFormData body = request().body().asMultipartFormData();
			FilePart database = body.getFile("database");
			FilePart input = body.getFile("input");
			File dbFile = database.getFile();
			File inputFile = input.getFile();

			Logger.debug("Before Search >>>");
			
			InputStream in = WordSearch.computeResult(dbFile, wordDesc.sheetNumberDb, inputFile, wordDesc.separators.toArray(new String[0]), new LevelStyle4Adherant());
			Logger.debug("<<< After search");
			
			return ok(in).as("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
		} else {
			flash("error", "Missing file || Form error");
			return redirect(routes.Application.index());    
		}
	}

}
