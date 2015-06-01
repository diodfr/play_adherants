package models;

import java.util.List;

import play.data.validation.Constraints.Required;

public class SheetDescription {
	@Required
	public int sheetNumberDb;
	@Required
	public int sheetNumberInput;
	
	public int minLevelForComment;
	
	public List<FormattingRule> rules;
	
	public SheetDescription() {
		minLevelForComment = 30;
	}
}
