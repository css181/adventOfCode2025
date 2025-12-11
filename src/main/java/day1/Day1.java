package day1;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import utilities.FileUtility;

public class Day1 {

	private static File file;
	protected ArrayList<Long> turnSequence = new ArrayList<Long>();
	private int position = 0;
	public Long dialLocation = 50l;

	public Day1() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}
	public Day1(File file) {
		setFileToUse(file);
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day1.file = file;
	}

	public void populateInput() {
		ArrayList<String> inputLines = FileUtility.convertFileToStringArray(file);
		for (String line : inputLines) {
			long rotate = Long.valueOf(line.substring(1));
			if(line.startsWith("L")) {
				rotate*=-1;
			}
			turnSequence.add(rotate);
		}
	}
	
	public Long turnDial() {
		dialLocation += turnSequence.get(position++);
		while (dialLocation < 0) {
			dialLocation+=100;
		}
		while (dialLocation >= 100) {
			dialLocation-=100;
		}
		return dialLocation;
	}
	public Long getNumOfZeroResultsFromAllTurns() {
		long result = 0;
		for (Long turn : turnSequence) {
			if(turnDial()==0) {
				result++;
			}
		}
		return result;
	}
	
}
