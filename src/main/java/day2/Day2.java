package day2;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;

public class Day2 {

	private static File file;
	protected ArrayList<IDRange> idRanges = new ArrayList<IDRange>();

	public Day2() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}
	public Day2(File file) {
		idRanges = new ArrayList<IDRange>();
		setFileToUse(file);
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day2.file = file;
	}

	public void populateInput() {
		ArrayList<String> inputLines = FileUtility.convertFileToStringArray(file);
		String[] listInput = inputLines.get(0).split(",");
		for (String line : listInput) {
			idRanges.add(new IDRange(line));
		}
	}
	
	
	public long getSumOfAllInvalidIDs() {
		long sum=0;
		for (IDRange idRange : idRanges) {
			for (Long inalidID : idRange.getInvalidIDsBetweenLeftAndRight()) {
				sum+=inalidID;
			}
		}
		return sum;
	}
}
