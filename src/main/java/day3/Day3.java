package day3;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;

public class Day3 {

	private static File file;
	protected ArrayList<BatteryBank> batteryBankList = new ArrayList<BatteryBank>();

	public Day3() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}
	public Day3(File file) {
		batteryBankList = new ArrayList<BatteryBank>();
		setFileToUse(file);
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day3.file = file;
	}

	public void populateInput() {
		ArrayList<String> inputLines = FileUtility.convertFileToStringArray(file);
		for (String line : inputLines) {			
			batteryBankList.add(new BatteryBank(line));
		}
	}
	public Long getSumOfAllHighestJolts(int totalDigits) {
		long sum = 0;
		for (BatteryBank batteryBank : batteryBankList) {
			sum+=batteryBank.getHighestJoltValue(totalDigits);
		}
		return sum;
	}
}
