package day6;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import utilities.FileUtility;

public class Day6 {

	private static File file;
	protected ArrayList<Problem> problemList = new ArrayList<Problem>();

	public Day6() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}
	public Day6(File file) {
		problemList = new ArrayList<Problem>();
		setFileToUse(file);
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day6.file = file;
	}

	public void populateInput() {
		ArrayList<String> inputLines = FileUtility.convertFileToStringArray(file);
		String[] numOfCols = inputLines.get(0).split(" ");
		numOfCols = removeAnyEmptyElements(numOfCols);
		int numOfProblems = numOfCols.length;
		for(int problemNum=0; problemNum<numOfProblems; problemNum++) {
			ArrayList<Long> curNumbers = new ArrayList<Long>();
			boolean curIsAddition;
			for (int lineNum=0; lineNum<inputLines.size()-1; lineNum++) {
				String line = inputLines.get(lineNum);
				String[] cols = line.split(" ");
				cols = removeAnyEmptyElements(cols);
				curNumbers.add(Long.valueOf(cols[problemNum]));
			}
			String lastLine = inputLines.get(inputLines.size()-1);
			String[] lastCols = lastLine.split(" ");
			lastCols = removeAnyEmptyElements(lastCols);
			curIsAddition = (lastCols[problemNum].trim().equals("+"));
			problemList.add(new Problem(curNumbers, curIsAddition));
		}
	}
	
	private String[] removeAnyEmptyElements(String[] numOfCols) {
		return Arrays.stream(numOfCols)
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);
	}
	
	public Long getGrandTotal() {
		long sum = 0;
		for (Problem problem : problemList) {
			sum+=problem.getAnswer();
		}
		return sum;
	}
}
