package models;

public class FormattingRule {
	public int level;
	public int color;
	
	public FormattingRule setLevel(int level) {
		this.level = level;
		return this;
	}
	
	public FormattingRule setColor(int color) {
		this.color = color;
		
		return this;
	}
}
