package day7;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day7Part1 {

	private Day7 day7;
	
	@BeforeEach
	public void setup() {
		day7 = new Day7(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	
	@Test 
	void verify_Input() {
		String expectedArea = ""
				+ ".......S.......\n"
				+ "...............\n"
				+ ".......^.......\n"
				+ "...............\n"
				+ "......^.^......\n"
				+ "...............\n"
				+ ".....^.^.^.....\n"
				+ "...............\n"
				+ "....^.^...^....\n"
				+ "...............\n"
				+ "...^.^...^.^...\n"
				+ "...............\n"
				+ "..^...^.....^..\n"
				+ "...............\n"
				+ ".^.^.^.^.^...^.\n"
				+ "...............\n";
		
		assertEquals(expectedArea, day7.map.toString());
	}
	
	@Test
	void verify_after_1_tick() throws Exception {
		day7.tick();
		String expectedArea = ""
				+ ".......S.......\n"
				+ ".......|.......\n"
				+ ".......^.......\n"
				+ "...............\n"
				+ "......^.^......\n"
				+ "...............\n"
				+ ".....^.^.^.....\n"
				+ "...............\n"
				+ "....^.^...^....\n"
				+ "...............\n"
				+ "...^.^...^.^...\n"
				+ "...............\n"
				+ "..^...^.....^..\n"
				+ "...............\n"
				+ ".^.^.^.^.^...^.\n"
				+ "...............\n";
		
		assertEquals(expectedArea, day7.map.toString());
	}

	@Test
	void verify_after_2_tick() throws Exception {
		day7.tick();
		day7.tick();
		String expectedArea = ""
				+ ".......S.......\n"
				+ ".......|.......\n"
				+ "......|^|......\n"
				+ "...............\n"
				+ "......^.^......\n"
				+ "...............\n"
				+ ".....^.^.^.....\n"
				+ "...............\n"
				+ "....^.^...^....\n"
				+ "...............\n"
				+ "...^.^...^.^...\n"
				+ "...............\n"
				+ "..^...^.....^..\n"
				+ "...............\n"
				+ ".^.^.^.^.^...^.\n"
				+ "...............\n";
		
		assertEquals(expectedArea, day7.map.toString());
		assertEquals(1, day7.numberOfSplits);
	}

	@Test
	void verify_after_4_tick() throws Exception {
		day7.tick();
		day7.tick();
		day7.tick();
		day7.tick();
		String expectedArea = ""
				+ ".......S.......\n"
				+ ".......|.......\n"
				+ "......|^|......\n"
				+ "......|.|......\n"
				+ ".....|^|^|.....\n"
				+ "...............\n"
				+ ".....^.^.^.....\n"
				+ "...............\n"
				+ "....^.^...^....\n"
				+ "...............\n"
				+ "...^.^...^.^...\n"
				+ "...............\n"
				+ "..^...^.....^..\n"
				+ "...............\n"
				+ ".^.^.^.^.^...^.\n"
				+ "...............\n";
		
		assertEquals(expectedArea, day7.map.toString());
		assertEquals(3, day7.numberOfSplits);
	}

	@Test
	void verify_after_15_tick() throws Exception {
		for(int x=0; x<15; x++)
			day7.tick();
		
		String expectedArea = ""
				+ ".......S.......\n"
				+ ".......|.......\n"
				+ "......|^|......\n"
				+ "......|.|......\n"
				+ ".....|^|^|.....\n"
				+ ".....|.|.|.....\n"
				+ "....|^|^|^|....\n"
				+ "....|.|.|.|....\n"
				+ "...|^|^|||^|...\n"
				+ "...|.|.|||.|...\n"
				+ "..|^|^|||^|^|..\n"
				+ "..|.|.|||.|.|..\n"
				+ ".|^|||^||.||^|.\n"
				+ ".|.|||.||.||.|.\n"
				+ "|^|^|^|^|^|||^|\n"
				+ "|.|.|.|.|.|||.|\n";
		
		assertEquals(expectedArea, day7.map.toString());
		assertEquals(21, day7.numberOfSplits);
	}

	
	@Test
	void part1_answer() throws Exception {
		day7 = new Day7();
		for(int x=0; x<141; x++)
			day7.tick();
//		System.out.println(day7.numberOfSplits);
		assertEquals(1573, day7.numberOfSplits);
//		System.out.println(day7.map.toString());
	}
}
