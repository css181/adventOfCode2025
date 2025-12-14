package day5;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day5Part2 {

	private Day5 day5;
	
	@BeforeEach
	public void setup() {
		day5 = new Day5(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test 
	void verify_truncated_lists_for_sample() {
		ArrayList<Long> expectedTruncatedLeftList = new ArrayList<Long>();
		ArrayList<Long> expectedTruncatedRightList = new ArrayList<Long>();
		expectedTruncatedLeftList.add(3l);
		expectedTruncatedLeftList.add(10l);

		expectedTruncatedRightList.add(5l);
		expectedTruncatedRightList.add(20l);
		
		day5.generateTruncatedLists();
		assertEquals(expectedTruncatedLeftList, day5.truncatedLeftList);
		assertEquals(expectedTruncatedRightList, day5.truncatedRightList);
	}
	
	@Test
	void verify_14_total_freshIDs_for_Sample() throws Exception {
		day5.generateTruncatedLists();
		assertEquals(14l, day5.calculateTotalFreshIDs());
	}
	
	@Test
	void part2_answer() throws Exception {
		day5 = new Day5();
		day5.generateTruncatedLists();
//		System.out.println(day5.calculateTotalFreshIDs());
		assertEquals(353716783056994l, day5.calculateTotalFreshIDs());
//		for(int truncListNum=0; truncListNum<day5.truncatedLeftList.size(); truncListNum++) {
//			System.out.println(day5.truncatedLeftList.get(truncListNum) + " - " + day5.truncatedRightList.get(truncListNum));
//		}
	}
}
