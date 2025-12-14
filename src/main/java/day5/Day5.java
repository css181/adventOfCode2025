package day5;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;

public class Day5 {

	private static File file;
	public ArrayList<Long> rangeLeftList;
	public ArrayList<Long> rangeRightList;
	public ArrayList<Long> truncatedLeftList;
	public ArrayList<Long> truncatedRightList;
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
		truncatedLeftList = new ArrayList<Long>();
		truncatedRightList = new ArrayList<Long>();
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
	
	public void generateTruncatedLists() {
		for(int listNum=0; listNum<rangeLeftList.size(); listNum++) {
			long left = rangeLeftList.get(listNum);
			long right = rangeRightList.get(listNum);
			if(isMergableWithAnotherTruncatedList(left, right)) {				
				mergeTruncatedLists(left, right, listNum);
			} else {				
				truncatedLeftList.add(left);
				truncatedRightList.add(right);
			}
		}
	}
	
	private boolean isMergableWithAnotherTruncatedList(long left, long right) {
		for(int truncListNum=0; truncListNum<truncatedLeftList.size(); truncListNum++) {
			long curLeft = truncatedLeftList.get(truncListNum);
			long curRight = truncatedRightList.get(truncListNum);
			if((curLeft<=left) && (curRight>=left)) {
				return true;
			}
			else if((curRight>=right) && (curLeft<=right)) {
				return true;
			}
		}
		return false;
	}
	
	private void mergeTruncatedLists(long left, long right, int index) {
		for(int truncListNum=0; truncListNum<truncatedLeftList.size(); truncListNum++) {
			if(truncListNum==index) {
				continue;//Don't check merging the list we pass in, we want to merge that with something else
			}
			long curLeft = truncatedLeftList.get(truncListNum);
			long curRight = truncatedRightList.get(truncListNum);
			if((curLeft<=left) && (curRight>=left)) {
				//extend the existing listNum out further to the right
				if(right>curRight) {
					//Adjust this trunclist
					truncatedRightList.set(truncListNum, right);
					mergeTruncatedLists(curLeft, right, truncListNum);
				}
			}
			else if((curRight>=right) && (curLeft<=right)) {
				//extend the existing listNum out further to the left
				if(left<curLeft) {
					//Adjust this trunclist
					truncatedLeftList.set(truncListNum, left);
					mergeTruncatedLists(left, curRight, truncListNum);

				}
			}
		}
		removeAnyFullyEncapsolatedTruncatedLists();
	}
	
	private void removeAnyFullyEncapsolatedTruncatedLists() {
		for(int truncListNum=0; truncListNum<truncatedLeftList.size(); truncListNum++) {
			long curTruncLeft = truncatedLeftList.get(truncListNum);
			long curTruncRight = truncatedRightList.get(truncListNum);
			for(int checkTruncListNum=0; checkTruncListNum<truncatedLeftList.size(); checkTruncListNum++) {
				if(checkTruncListNum==truncListNum) {
					break;
				}
				long checkTruncLeft = truncatedLeftList.get(checkTruncListNum);
				long checkTruncRight = truncatedRightList.get(checkTruncListNum);
				if((checkTruncLeft>=curTruncLeft) && (checkTruncRight<=curTruncRight)) {
					//remove fully encapsolated trunc list
					truncatedLeftList.remove(checkTruncListNum);
					truncatedRightList.remove(checkTruncListNum);
					checkTruncListNum--;
					truncListNum--;
				}
			}
		}
//		for(int truncListNum=0; truncListNum<truncatedLeftList.size(); truncListNum++) {
//			long curTruncLeft = truncatedLeftList.get(truncListNum);
//			long curTruncRight = truncatedRightList.get(truncListNum);
//			boolean didMerge = false;
//			for(int checkTruncListNum=0; checkTruncListNum<truncatedLeftList.size(); checkTruncListNum++) {
//				if(checkTruncListNum==truncListNum) {
//					break;
//				}
//				long checkTruncLeft = truncatedLeftList.get(checkTruncListNum);
//				long checkTruncRight = truncatedRightList.get(checkTruncListNum);
//				if((curTruncLeft>checkTruncLeft) && (curTruncLeft<checkTruncRight) && (curTruncRight>checkTruncRight)) {
//					//merge list in middle
//					truncatedLeftList.set(truncListNum, checkTruncLeft);
//					truncatedRightList.set(truncListNum, curTruncRight);
//					truncatedLeftList.remove(checkTruncListNum);
//					truncatedRightList.remove(checkTruncListNum);
//					didMerge = true;
//					break;
//				}
//			}
//			if(didMerge) {
//				removeAnyFullyEncapsolatedTruncatedLists();
//			}
//		}
	}
	public Long calculateTotalFreshIDs() {
		long total = 0;
		for(int truncListNum=0; truncListNum<truncatedLeftList.size(); truncListNum++) {
			total+= (truncatedRightList.get(truncListNum) - truncatedLeftList.get(truncListNum) + 1);
		}
		return total;
	}
}
