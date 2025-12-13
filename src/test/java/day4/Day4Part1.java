package day4;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.Map;

public class Day4Part1 {

	private Day4 day4;
	
	@BeforeEach
	public void setup() {
		day4 = new Day4(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test 
	void verify_Input() {
		String expectedArea = ""
				+ "..@@.@@@@.\n"
				+ "@@@.@.@.@@\n"
				+ "@@@@@.@.@@\n"
				+ "@.@@@@..@.\n"
				+ "@@.@@@@.@@\n"
				+ ".@@@@@@@.@\n"
				+ ".@.@.@.@@@\n"
				+ "@.@@@.@@@@\n"
				+ ".@@@@@@@@.\n"
				+ "@.@.@@@.@.\n";
		
		assertEquals(expectedArea, day4.map.toString());
	}
	
	@Test
	void verify_that_cell_0_2_has_less_than_4_agacents() throws Exception {
		assertTrue(day4.doesHaveLessThan4Agacents(0,2));
	}
	
	@Test
	void verify_map_with_Xs_for_4_or_less_agacents() throws Exception {
		String expectedArea = ""
				+ "..xx.xx@x.\n"
				+ "x@@.@.@.@@\n"
				+ "@@@@@.x.@@\n"
				+ "@.@@@@..@.\n"
				+ "x@.@@@@.@x\n"
				+ ".@@@@@@@.@\n"
				+ ".@.@.@.@@@\n"
				+ "x.@@@.@@@@\n"
				+ ".@@@@@@@@.\n"
				+ "x.x.@@@.x.\n";
		
		assertEquals(expectedArea, day4.markLessThan4AgacentsWithXInMap().toString());
	}
	
	@Test
	void verify_there_are_13_xs_in_Sample() throws Exception {
		Map newMap = day4.markLessThan4AgacentsWithXInMap();
		assertEquals(13l, day4.getCountOfAllXsInNewMap(newMap));
	}
	@Test
	void part1_answer() throws Exception {
		day4 = new Day4();
		Map newMap = day4.markLessThan4AgacentsWithXInMap();
//		System.out.println(day4.getCountOfAllXsInNewMap(newMap));
		assertEquals(1464l, day4.getCountOfAllXsInNewMap(newMap));
	}
}
