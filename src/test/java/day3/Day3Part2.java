package day3;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day3Part2 {

	private Day3 day3;
	
	@BeforeEach
	public void setup() {
		day3 = new Day3(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test
	void verify_largest_12_jolts_for_sample() throws Exception {
		assertEquals(987654321111l, day3.batteryBankList.get(0).getHighestJoltValue(12));
		assertEquals(811111111119l, day3.batteryBankList.get(1).getHighestJoltValue(12));
		assertEquals(434234234278l, day3.batteryBankList.get(2).getHighestJoltValue(12));
		assertEquals(888911112111l, day3.batteryBankList.get(3).getHighestJoltValue(12));
	}

	@Test
	void verify_sum_of_highest_jolts_on_Sample() throws Exception {
		assertEquals(3121910778619l, day3.getSumOfAllHighestJolts(12));
	}
	
	@Test
	void part2_answer() throws Exception {
		day3 = new Day3();
		System.out.println(day3.getSumOfAllHighestJolts(12));
	}
}
