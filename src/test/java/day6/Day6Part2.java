package day6;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day6Part2 {

	private Day6Dash2 day6;
	
	@BeforeEach
	public void setup() {
		day6 = new Day6Dash2(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test 
	void verify_Input() {
		ArrayList<Problem> expectedProblemList = new ArrayList<Problem>();
		expectedProblemList.add(new Problem(new ArrayList<Long>(Arrays.asList(4l,431l,623l)), true));
		expectedProblemList.add(new Problem(new ArrayList<Long>(Arrays.asList(175l, 581l, 32l)), false));
		expectedProblemList.add(new Problem(new ArrayList<Long>(Arrays.asList(8l, 248l, 369l)), true));
		expectedProblemList.add(new Problem(new ArrayList<Long>(Arrays.asList(356l, 24l, 1l)), false));
		
		assertEquals(expectedProblemList, day6.problemList);
	}

	@Test
	void verify_problem_answers() throws Exception {
		assertEquals(1058l, day6.problemList.get(0).getAnswer());
		assertEquals(3253600l, day6.problemList.get(1).getAnswer());
		assertEquals(625l, day6.problemList.get(2).getAnswer());
		assertEquals(8544l, day6.problemList.get(3).getAnswer());
	}
	
//	The rightmost problem is 4 + 431 + 623 = 1058
//			The second problem from the right is 175 * 581 * 32 = 3253600
//			The third problem from the right is 8 + 248 + 369 = 625
//			Finally, the leftmost problem is 356 * 24 * 1 = 8544
//			Now, the grand total is 1058 + 3253600 + 625 + 8544 = 3263827.
	
	@Test
	void verify_sum_of_all_answers_for_Sample() throws Exception {
		assertEquals(3263827l, day6.getGrandTotal());
	}
	
	@Test
	void part2_answer() throws Exception {
		day6 = new Day6Dash2();
//		System.out.println(day6.getGrandTotal());
		assertEquals(7329921182115l, day6.getGrandTotal());
	}
}
