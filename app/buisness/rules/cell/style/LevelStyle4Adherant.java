package buisness.rules.cell.style;

import org.apache.poi.hssf.util.HSSFColor;

import fr.diod.searchAdherants.excel.style.provider.LevelStyleProvider;

public class LevelStyle4Adherant extends LevelStyleProvider {

	public LevelStyle4Adherant() {
		addLevel(60, HSSFColor.LIGHT_ORANGE.index);
		addLevel(75, HSSFColor.SKY_BLUE.index);
		addLevel(100, HSSFColor.GREEN.index);
	}
}
