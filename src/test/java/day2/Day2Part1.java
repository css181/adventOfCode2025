package day2;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day2Part1 {

	private Day2 day2;
	
	@BeforeEach
	public void setup() {
		day2 = new Day2(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test 
	void verify_Input() {
		ArrayList<IDRange> expectedIDRange = new ArrayList<IDRange>();
		expectedIDRange.add(new IDRange("11-22"));
		expectedIDRange.add(new IDRange("95-115"));
		expectedIDRange.add(new IDRange("998-1012"));
		expectedIDRange.add(new IDRange("1188511880-1188511890"));
		expectedIDRange.add(new IDRange("222220-222224"));
		expectedIDRange.add(new IDRange("1698522-1698528"));
		expectedIDRange.add(new IDRange("446443-446449"));
		expectedIDRange.add(new IDRange("38593856-38593862"));
		expectedIDRange.add(new IDRange("565653-565659"));
		expectedIDRange.add(new IDRange("824824821-824824827"));
		expectedIDRange.add(new IDRange("2121212118-2121212124"));
		
		assertEquals(expectedIDRange, day2.idRanges);
		assertEquals(11, day2.idRanges.get(0).getLeft());
		assertEquals(22, day2.idRanges.get(0).getRight());
	}
	
	@Test
	void verify_invalid_IDs_of_first_Sample_range_are_11_and_22() throws Exception {
		ArrayList<Long> expectedInvalidIDs = new ArrayList<Long>();
		expectedInvalidIDs.add(11l);
		expectedInvalidIDs.add(22l);
		
		assertEquals(expectedInvalidIDs, day2.idRanges.get(0).getInvalidIDsBetweenLeftAndRight());
	}
	
	@Test
	void verify_all_other_invalid_Sample_IDs() throws Exception {
		ArrayList<Long> expectedInvalidIDs = new ArrayList<Long>();
		expectedInvalidIDs.add(99l);
		assertEquals(expectedInvalidIDs, day2.idRanges.get(1).getInvalidIDsBetweenLeftAndRight());
		
		expectedInvalidIDs = new ArrayList<Long>();
		expectedInvalidIDs.add(1010l);
		assertEquals(expectedInvalidIDs, day2.idRanges.get(2).getInvalidIDsBetweenLeftAndRight());
		
		expectedInvalidIDs = new ArrayList<Long>();
		expectedInvalidIDs.add(1188511885l);
		assertEquals(expectedInvalidIDs, day2.idRanges.get(3).getInvalidIDsBetweenLeftAndRight());
		
		expectedInvalidIDs = new ArrayList<Long>();
		expectedInvalidIDs.add(222222l);
		assertEquals(expectedInvalidIDs, day2.idRanges.get(4).getInvalidIDsBetweenLeftAndRight());
		
		expectedInvalidIDs = new ArrayList<Long>();
		assertEquals(expectedInvalidIDs, day2.idRanges.get(5).getInvalidIDsBetweenLeftAndRight());
		
		expectedInvalidIDs = new ArrayList<Long>();
		expectedInvalidIDs.add(446446l);
		assertEquals(expectedInvalidIDs, day2.idRanges.get(6).getInvalidIDsBetweenLeftAndRight());
		
		expectedInvalidIDs = new ArrayList<Long>();
		expectedInvalidIDs.add(38593859l);
		assertEquals(expectedInvalidIDs, day2.idRanges.get(7).getInvalidIDsBetweenLeftAndRight());

		expectedInvalidIDs = new ArrayList<Long>();
		assertEquals(expectedInvalidIDs, day2.idRanges.get(8).getInvalidIDsBetweenLeftAndRight());
		expectedInvalidIDs = new ArrayList<Long>();
		assertEquals(expectedInvalidIDs, day2.idRanges.get(9).getInvalidIDsBetweenLeftAndRight());
		expectedInvalidIDs = new ArrayList<Long>();
		assertEquals(expectedInvalidIDs, day2.idRanges.get(10).getInvalidIDsBetweenLeftAndRight());
	}
	
	@Test
	void verify_sum_of_all_sample_invalid_ids_is_1227775554() throws Exception {
		assertEquals(1227775554l, day2.getSumOfAllInvalidIDs());
	}
	
	@Test
	void part1_answer() throws Exception {
		day2 = new Day2();
//		System.out.println(day2.getSumOfAllInvalidIDs());
		assertEquals(23701357374l, day2.getSumOfAllInvalidIDs());
	}
}
