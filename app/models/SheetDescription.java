package models;

import play.data.validation.Constraints.Required;

public class SheetDescription {
	@Required
	public int sheetNumberDb;
	@Required
	public int sheetNumberInput;
}
