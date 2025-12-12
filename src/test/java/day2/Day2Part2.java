package day2;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day2Part2 {

	private Day2 day2;
	
	@BeforeEach
	public void setup() {
		day2 = new Day2(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	

	@Test
	void verify_all_invalid_Sample_IDs() throws Exception {
		ArrayList<Long> expectedInvalidIDs = new ArrayList<Long>();
		expectedInvalidIDs.add(11l);
		expectedInvalidIDs.add(22l);
		assertEquals(expectedInvalidIDs, day2.idRanges.get(0).getInvalidIDsBetweenLeftAndRightPart2());
		
		expectedInvalidIDs = new ArrayList<Long>();
		expectedInvalidIDs.add(99l);
		expectedInvalidIDs.add(111l);
		assertEquals(expectedInvalidIDs, day2.idRanges.get(1).getInvalidIDsBetweenLeftAndRightPart2());
		
		expectedInvalidIDs = new ArrayList<Long>();
		expectedInvalidIDs.add(999l);
		expectedInvalidIDs.add(1010l);
		assertEquals(expectedInvalidIDs, day2.idRanges.get(2).getInvalidIDsBetweenLeftAndRightPart2());
		
		expectedInvalidIDs = new ArrayList<Long>();
		expectedInvalidIDs.add(1188511885l);
		assertEquals(expectedInvalidIDs, day2.idRanges.get(3).getInvalidIDsBetweenLeftAndRightPart2());
		
		expectedInvalidIDs = new ArrayList<Long>();
		expectedInvalidIDs.add(222222l);
		assertEquals(expectedInvalidIDs, day2.idRanges.get(4).getInvalidIDsBetweenLeftAndRightPart2());
		
		expectedInvalidIDs = new ArrayList<Long>();
		assertEquals(expectedInvalidIDs, day2.idRanges.get(5).getInvalidIDsBetweenLeftAndRightPart2());
		
		expectedInvalidIDs = new ArrayList<Long>();
		expectedInvalidIDs.add(446446l);
		assertEquals(expectedInvalidIDs, day2.idRanges.get(6).getInvalidIDsBetweenLeftAndRightPart2());
		
		expectedInvalidIDs = new ArrayList<Long>();
		expectedInvalidIDs.add(38593859l);
		assertEquals(expectedInvalidIDs, day2.idRanges.get(7).getInvalidIDsBetweenLeftAndRightPart2());

		expectedInvalidIDs = new ArrayList<Long>();
		expectedInvalidIDs.add(565656l);
		assertEquals(expectedInvalidIDs, day2.idRanges.get(8).getInvalidIDsBetweenLeftAndRightPart2());
		
		expectedInvalidIDs = new ArrayList<Long>();
		expectedInvalidIDs.add(824824824l);
		assertEquals(expectedInvalidIDs, day2.idRanges.get(9).getInvalidIDsBetweenLeftAndRightPart2());
		
		expectedInvalidIDs = new ArrayList<Long>();
		expectedInvalidIDs.add(2121212121l);
		assertEquals(expectedInvalidIDs, day2.idRanges.get(10).getInvalidIDsBetweenLeftAndRightPart2());
	}
	
	@Test
	void verify_sum_of_all_sample_invalid_ids_is_1227775554() throws Exception {
		assertEquals(4174379265l, day2.getSumOfAllInvalidIDs_Part2());
	}
	
	@Test
	void part2_answer() throws Exception {
		day2 = new Day2();
//		System.out.println(day2.getSumOfAllInvalidIDs_Part2());
		assertEquals(34284458938l, day2.getSumOfAllInvalidIDs_Part2());
	}
}
