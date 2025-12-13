package day3;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day3Part1 {

	private Day3 day3;
	
	@BeforeEach
	public void setup() {
		day3 = new Day3(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test 
	void verify_Input() {
		ArrayList<BatteryBank> expectedList = new ArrayList<BatteryBank>();
		expectedList.add(new BatteryBank("987654321111111"));
		expectedList.add(new BatteryBank("811111111111119"));
		expectedList.add(new BatteryBank("234234234234278"));
		expectedList.add(new BatteryBank("818181911112111"));
		
		assertEquals(expectedList, day3.batteryBankList);
		assertEquals(9, day3.batteryBankList.get(0).getJolts().get(0));
		assertEquals(9, day3.batteryBankList.get(1).getJolts().get(day3.batteryBankList.get(1).getJolts().size()-1));
	}
	
	@Test
	void verify_largest_jolts_for_sample() throws Exception {
//		In 987654321111111, you can make the largest joltage possible, 98, by turning on the first two batteries.
//		In 811111111111119, you can make the largest joltage possible by turning on the batteries labeled 8 and 9, producing 89 jolts.
//		In 234234234234278, you can make 78 by turning on the last two batteries (marked 7 and 8).
//		In 818181911112111, the largest joltage you can produce is 92.
		assertEquals(98, day3.batteryBankList.get(0).getHighestJoltValue(2));
		assertEquals(89, day3.batteryBankList.get(1).getHighestJoltValue(2));
		assertEquals(78, day3.batteryBankList.get(2).getHighestJoltValue(2));
		assertEquals(92, day3.batteryBankList.get(3).getHighestJoltValue(2));
	}
	
	@Test
	void verify_sum_of_highest_jolts_on_Sample() throws Exception {
		assertEquals(357l, day3.getSumOfAllHighestJolts(2));
	}
	
	@Test
	void part1_answer() throws Exception {
		day3 = new Day3();
//		System.out.println(day3.getSumOfAllHighestJolts());
		assertEquals(17613l, day3.getSumOfAllHighestJolts(2));
	}
}
