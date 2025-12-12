package day1;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day1Part2 {

	private Day1 day1;
	
	@BeforeEach
	public void setup() {
		day1 = new Day1(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test
	void verify_Sample_points_at_0_a_total_of_6_times() throws Exception {
		assertEquals(6l, day1.getNumOfZeroTouchesFromAllTurns());
	}
	
	@Test
	void edgeCases_of_on_zero_plus_and_minus_100() throws Exception {
		day1.turnSequence = new ArrayList<Long>(Arrays.asList(-50l, -100l, 100l, 0l, -1l));
		assertEquals(3, day1.getNumOfZeroTouchesFromAllTurns());
	}

	@Test
	void edgeCases_more() throws Exception {
		day1.turnSequence = new ArrayList<Long>(Arrays.asList(-50l, 200l, -200l, 1l, -101l));
		assertEquals(7, day1.getNumOfZeroTouchesFromAllTurns());
	}
	
	@Test
	void part2_answer() throws Exception {
		day1 = new Day1();
//		System.out.println(day1.getNumOfZeroTouchesFromAllTurns());
		assertEquals(6295, day1.getNumOfZeroTouchesFromAllTurns());
	}
}
