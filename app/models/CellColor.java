package models;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.hssf.util.HSSFColor;

public class CellColor {
	public static final Map<String,String> options() {
		Map<String, String> map = new HashMap<String, String>();
		for (Entry<Integer, HSSFColor> colorEntry : HSSFColor.getIndexHash().entrySet()) {
			String colorName = colorEntry.getValue().getClass().getCanonicalName();
			int lastIndexOfPoint = colorName.lastIndexOf('.')+1;
			map.put(colorEntry.getKey()+ "", colorName.substring(lastIndexOfPoint));
		}
		
		return map;
	}
	
}
