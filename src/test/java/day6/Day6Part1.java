package day6;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day6Part1 {

	private Day6 day6;
	
	@BeforeEach
	public void setup() {
		day6 = new Day6(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test 
	void verify_Input() {
		ArrayList<Problem> expectedProblemList = new ArrayList<Problem>();
		expectedProblemList.add(new Problem(new ArrayList<Long>(Arrays.asList(123l,45l,6l)), false));
		expectedProblemList.add(new Problem(new ArrayList<Long>(Arrays.asList(328l, 64l, 98l)), true));
		expectedProblemList.add(new Problem(new ArrayList<Long>(Arrays.asList(51l, 387l, 215l)), false));
		expectedProblemList.add(new Problem(new ArrayList<Long>(Arrays.asList(64l, 23l, 314l)), true));
		
		assertEquals(expectedProblemList, day6.problemList);
	}
	
	@Test
	void verify_problem_answers() throws Exception {
		assertEquals(33210l, day6.problemList.get(0).getAnswer());
		assertEquals(490l, day6.problemList.get(1).getAnswer());
		assertEquals(4243455l, day6.problemList.get(2).getAnswer());
		assertEquals(401l, day6.problemList.get(3).getAnswer());
	}
	
	@Test
	void verify_sum_of_all_answers_for_Sample() throws Exception {
		assertEquals(4277556l, day6.getGrandTotal());
	}
	
	@Test
	void part1_answer() throws Exception {
		day6 = new Day6();
//		System.out.println(day6.getGrandTotal());
		assertEquals(4648618073226l, day6.getGrandTotal());
	}
}
