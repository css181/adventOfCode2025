package day4;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;
import utilities.Map;

public class Day4 {

	private static File file;
	public Map map;

	public Day4() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}
	public Day4(File file) {
		setFileToUse(file);
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day4.file = file;
	}

	public void populateInput() {
		ArrayList<ArrayList<Character>> area = FileUtility.convertFileToCharacterArray(file);
		map = new Map(area);
	}
	
	public Map markLessThan4AgacentsWithXInMap() {
		Map newMap = new Map(map.toString(), "\n");
		for(int row=0; row<map.getHeight(); row++) {
//			System.out.println("Marking row: " + row + "/" + (map.getHeight()-1));
			for(int col=0; col<map.getWidth(); col++) {
				if(isCellPaper(row, col)) {
					if(doesHaveLessThan4Agacents(row, col)) {
						newMap.updateArea(row, col, 'x');
					}
				}
			}
		}
//		System.out.println("finished new map");
		return newMap;
	}
	public boolean doesHaveLessThan4Agacents(int row, int col) {
		int numOfAgacents = 0;
		for(int curRow=row-1; curRow<=row+1; curRow++) {
			for(int curCol=col-1; curCol<=col+1; curCol++) {
				if((curRow==row) && (curCol==col)) {
					//Skip center cell
				}				
				else if(isCellPaper(curRow, curCol)) {
					numOfAgacents++;
				}
			}
		}
		return (numOfAgacents<4);
	}
	
	private boolean isCellPaper(int row, int col) {
		if((row<0) || (row>map.getHeight()-1) || (col<0) || (col>map.getWidth()-1)) {
			return false;
		}
		return (map.getCellValue(row, col)=='@');
	}
	public Long getCountOfAllXsInNewMap(Map newMap) {
	    long count = 0;
		for(int row=0; row<newMap.getHeight(); row++) {
			for(int col=0; col<newMap.getWidth(); col++) {
				if(newMap.getCellValue(row, col)=='x') {
					count++;
				}
			}
		}
	    return count;
	}
}
