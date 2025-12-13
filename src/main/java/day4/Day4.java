package day4;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;
import utilities.Map;

public class Day4 {

	private static File file;
	public Map map;
	public Map finishedMapAfterAllPaperIsAccessed;

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
	
	public Map markLessThan4AgacentsWithXInMap(Map startMap) {
		Map newMap = new Map(startMap.toString(), "\n");
		for(int row=0; row<startMap.getHeight(); row++) {
			for(int col=0; col<startMap.getWidth(); col++) {
				if(newMap.getCellValue(row, col)=='x') {
					newMap.updateArea(row, col, '.');
				}
				if(isCellPaper(startMap, row, col)) {
					if(doesHaveLessThan4Agacents(startMap, row, col)) {
						newMap.updateArea(row, col, 'x');
					}
				}
			}
		}
		return newMap;
	}
	public boolean doesHaveLessThan4Agacents(Map lookMap, int row, int col) {
		int numOfAgacents = 0;
		for(int curRow=row-1; curRow<=row+1; curRow++) {
			for(int curCol=col-1; curCol<=col+1; curCol++) {
				if((curRow==row) && (curCol==col)) {
					//Skip center cell
				}				
				else if(isCellPaper(lookMap, curRow, curCol)) {
					numOfAgacents++;
				}
			}
		}
		return (numOfAgacents<4);
	}
	
	private boolean isCellPaper(Map lookMap, int row, int col) {
		if((row<0) || (row>map.getHeight()-1) || (col<0) || (col>map.getWidth()-1)) {
			return false;
		}
		return (lookMap.getCellValue(row, col)=='@');
	}
	public Long getCountOfAll_thing_InNewMap(Map lookMap, char thing) {
	    long count = 0;
		for(int row=0; row<lookMap.getHeight(); row++) {
			for(int col=0; col<lookMap.getWidth(); col++) {
				if(lookMap.getCellValue(row, col)==thing) {
					count++;
				}
			}
		}
	    return count;
	}
	
	public Integer getNumOfTicksUntilAllPaperIsAccessed(int maxTicksToLookFor) {
		Map oldMap = markLessThan4AgacentsWithXInMap(map);
		int ticks = 0;
		for(; ticks<maxTicksToLookFor; ticks++) {
			finishedMapAfterAllPaperIsAccessed = markLessThan4AgacentsWithXInMap(oldMap);
			if(oldMap.equals(finishedMapAfterAllPaperIsAccessed)) {
				break;
			} else {
				oldMap = finishedMapAfterAllPaperIsAccessed;
			}
		}
		return ticks;
	}
}
