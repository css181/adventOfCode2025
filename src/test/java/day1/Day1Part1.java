package day1;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day1Part1 {

	private Day1 day1;
	
	@BeforeEach
	public void setup() {
		day1 = new Day1(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test
	void convertFileToArrayOfCharArrayTest() {
		ArrayList<Long> expectedTurnSequence = new ArrayList<Long>();
		expectedTurnSequence.add(-68l);
		expectedTurnSequence.add(-30l);
		expectedTurnSequence.add(48l);
		expectedTurnSequence.add(-5l);
		expectedTurnSequence.add(60l);
		expectedTurnSequence.add(-55l);
		expectedTurnSequence.add(-1l);
		expectedTurnSequence.add(-99l);
		expectedTurnSequence.add(14l);
		expectedTurnSequence.add(-82l);
		assertEquals(expectedTurnSequence, day1.turnSequence);
	}
	
	/**
	 * @throws Exception
	 */
	@Test
	void verify_result_from_each_turn() throws Exception {
//		The dial starts by pointing at 50.
//		The dial is rotated L68 to point at 82.
//		The dial is rotated L30 to point at 52.
//		The dial is rotated R48 to point at 0.
//		The dial is rotated L5 to point at 95.
//		The dial is rotated R60 to point at 55.
//		The dial is rotated L55 to point at 0.
//		The dial is rotated L1 to point at 99.
//		The dial is rotated L99 to point at 0.
//		The dial is rotated R14 to point at 14.
//		The dial is rotated L82 to point at 32.
		assertEquals(50l, day1.dialLocation);
		assertEquals(82l, day1.turnDial());
		assertEquals(52l, day1.turnDial());
		assertEquals(0l, day1.turnDial());
		assertEquals(95l, day1.turnDial());
		assertEquals(55l, day1.turnDial());
		assertEquals(0l, day1.turnDial());
		assertEquals(99l, day1.turnDial());
		assertEquals(0l, day1.turnDial());
		assertEquals(14l, day1.turnDial());
		assertEquals(32l, day1.turnDial());
	}
	
	@Test
	void verify_Sample_answer_is_3() throws Exception {
		assertEquals(3, day1.getNumOfZeroResultsFromAllTurns());
	}
	
	@Test
	void part1_answer() throws Exception {
		day1 = new Day1();
//		System.out.println(day1.getNumOfZeroResultsFromAllTurns());
		assertEquals(1052l, day1.getNumOfZeroResultsFromAllTurns());
	}
}
