package day6;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;

public class Day6Dash2 {

	private static File file;
	protected ArrayList<Problem> problemList = new ArrayList<Problem>();

	public Day6Dash2() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}
	public Day6Dash2(File file) {
		problemList = new ArrayList<Problem>();
		setFileToUse(file);
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day6Dash2.file = file;
	}

	public void populateInput() {
		ArrayList<ArrayList<Character>> charArrOfArr = FileUtility.convertFileToCharacterArray(file);
		Problem curProblem = new Problem();
		ArrayList<Long> numberList = new ArrayList<Long>();
		boolean isNewProblem = false;
		for(int col=charArrOfArr.get(0).size()-1; col>=0; col--) {
			String number = "";
			for(int line=0; line<charArrOfArr.size()-1; line++) {	
				if(allColsAreSPace(charArrOfArr, col)) {
					boolean isAddition = (getValue(charArrOfArr, charArrOfArr.size()-1, col+1)=='+');
					curProblem = new Problem(numberList, isAddition);
					problemList.add(curProblem);
					numberList = new ArrayList<Long>();
					isNewProblem = true;
					break;
				}
				number+= (String.valueOf(getValue(charArrOfArr, line, col)));
			}
			if(!isNewProblem) {				
				long longNumber = Long.valueOf(number.trim());
				numberList.add(longNumber);
			}
			isNewProblem = false;
		}
		//add the last one that doesn't have leading spaces
		boolean isAddition = (getValue(charArrOfArr, charArrOfArr.size()-1, 0)=='+');
		curProblem = new Problem(numberList, isAddition);
		problemList.add(curProblem);
	}
	
	private boolean allColsAreSPace(ArrayList<ArrayList<Character>> charArrOfArr, int col) {
		for (ArrayList<Character> charList : charArrOfArr) {
			if(charList.get(col)!=' ') {
				return false;
			}
		}
		return true;
	}
	
	private char getValue(ArrayList<ArrayList<Character>> charArrOfArr, int line, int col) {
		return charArrOfArr.get(line).get(col);
	}
	
	public Long getGrandTotal() {
		long sum = 0;
		for (Problem problem : problemList) {
			sum+=problem.getAnswer();
		}
		return sum;
	}
}
