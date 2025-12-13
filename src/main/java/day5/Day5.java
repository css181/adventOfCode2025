package day5;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import utilities.FileUtility;

public class Day5 {

	private static File file;
	public ArrayList<Long> rangeLeftList;
	public ArrayList<Long> rangeRightList;
	public ArrayList<Long> testList;

	public Day5() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}
	public Day5(File file) {
		setFileToUse(file);
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day5.file = file;
	}

	public void populateInput() {
		rangeLeftList = new ArrayList<Long>();
		rangeRightList = new ArrayList<Long>();
		testList = new ArrayList<Long>();
		ArrayList<String> inputLines = FileUtility.convertFileToStringArray(file);
		for (String line : inputLines) {			
			if(line.contains("-")) {
				rangeLeftList.add(Long.valueOf(line.substring(0, line.indexOf("-"))));
				rangeRightList.add(Long.valueOf(line.substring(line.indexOf("-")+1)));
			} else {
				testList.add(Long.valueOf(line));
			}
		}
	}
	
	public Long getHighestRightRangeNumber() {
		long highest = -1;
		for (Long right : rangeRightList) {
			if(right> highest) {
				highest = right;
			}
		}
		return highest;
	}
	public Long getLowestLeftRangeNumber() {
		long lowest = Long.MAX_VALUE;
		for (Long left : rangeLeftList) {
			if(left<lowest) {
				lowest = left;
			}
		}
		return lowest;
	}

	public boolean idIsFresh(long id) {
		if((id<getLowestLeftRangeNumber()) || (id>getHighestRightRangeNumber())) {
			return false;
		}
		for(int listNum=0; listNum<rangeLeftList.size(); listNum++) {
			if(id>=rangeLeftList.get(listNum) && id<=rangeRightList.get(listNum)) {
				return true;
			}
		}
		return false;
	}
	public Integer getCountOfFreshIDsFromTestList() {
		int count = 0;
		for (Long testID : testList) {
			if(idIsFresh(testID)) {
				count++;
			}
		}
		return count;
	}
}
