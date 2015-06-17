package models;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.util.HSSFColor;

import play.data.validation.Constraints.Required;

public class SheetDescription {
	@Required
	public int sheetNumberDb;
	@Required
	public int sheetNumberInput;
	
	public int minLevelForComment;
	
	public List<FormattingRule> rules;
	
	public SheetDescription() {
	}

	public SheetDescription(boolean init) {
		minLevelForComment = 30;
		
		rules = new ArrayList<FormattingRule>();
		
		setMinScoreForComments(30);
		
		configureDefaultRules();
	}

	private void setMinScoreForComments(int minLevel) {
		minLevelForComment = minLevel;
	}

	private void configureDefaultRules() {
		addRule(50, HSSFColor.LIME.index);
		addRule(60, HSSFColor.LIGHT_ORANGE.index);
		addRule(75, HSSFColor.SKY_BLUE.index);
		addRule(100, HSSFColor.GREEN.index);
	}

	private void addRule(int level, int color) {
		FormattingRule formattingRule = new FormattingRule();
		formattingRule.setColor(color).setLevel(level);
		rules.add(formattingRule);
	}
}
