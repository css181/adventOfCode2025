package day5;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day5Part1 {

	private Day5 day5;
	
	@BeforeEach
	public void setup() {
		day5 = new Day5(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test 
	void verify_Input() {
		ArrayList<Long> expectedRangeLeftList = new ArrayList<Long>();
		ArrayList<Long> expectedRangeRightList = new ArrayList<Long>();
		ArrayList<Long> expectedTestList = new ArrayList<Long>();
		expectedRangeLeftList.add(3l);
		expectedRangeLeftList.add(10l);
		expectedRangeLeftList.add(16l);
		expectedRangeLeftList.add(12l);

		expectedRangeRightList.add(5l);
		expectedRangeRightList.add(14l);
		expectedRangeRightList.add(20l);
		expectedRangeRightList.add(18l);
		
		expectedTestList.add(1l);
		expectedTestList.add(5l);
		expectedTestList.add(8l);
		expectedTestList.add(11l);
		expectedTestList.add(17l);
		expectedTestList.add(32l);
		
		assertEquals(expectedRangeLeftList, day5.rangeLeftList);
		assertEquals(expectedRangeRightList, day5.rangeRightList);
		assertEquals(expectedTestList, day5.testList);
	}
	
	@Test
	void can_get_highest_right_range_number() throws Exception {
		assertEquals(20l, day5.getHighestRightRangeNumber());
	}
	@Test
	void can_get_lowest_left_range_number() throws Exception {
		assertEquals(3l, day5.getLowestLeftRangeNumber());
	}
	
	@Test
	void verify_isFresh_for_all_Sample() throws Exception {
//		Ingredient ID 1 is spoiled because it does not fall into any range.
//		Ingredient ID 5 is fresh because it falls into range 3-5.
//		Ingredient ID 8 is spoiled.
//		Ingredient ID 11 is fresh because it falls into range 10-14.
//		Ingredient ID 17 is fresh because it falls into range 16-20 as well as range 12-18.
//		Ingredient ID 32 is spoiled.
		assertFalse(day5.idIsFresh(1l));
		assertTrue(day5.idIsFresh(5l));
		assertFalse(day5.idIsFresh(8l));
		assertTrue(day5.idIsFresh(11l));
		assertTrue(day5.idIsFresh(17l));
		assertFalse(day5.idIsFresh(32l));
	}
	
	@Test
	void verify_3_testIDs_from_Sample_are_fresh() throws Exception {
		assertEquals(3, day5.getCountOfFreshIDsFromTestList());
	}
	
	@Test
	void part1_answer() throws Exception {
		day5 = new Day5();
		System.out.println(day5.getCountOfFreshIDsFromTestList());
	}
}
