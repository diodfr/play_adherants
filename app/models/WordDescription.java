package models;

import java.util.ArrayList;
import java.util.List;

import play.data.validation.Constraints.Required;

public class WordDescription {
	@Required
	public int sheetNumberDb;
	
	public List<String> separators;
	
	public WordDescription() {
	}

	public WordDescription(boolean toto) {
		separators = new ArrayList<String>();
	}
}
