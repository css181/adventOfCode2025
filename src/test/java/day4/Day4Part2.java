package day4;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.Map;

public class Day4Part2 {

	private Day4 day4;
	
	@BeforeEach
	public void setup() {
		day4 = new Day4(new File(getClass().getResource("SampleInput.txt").getPath()));
	}
	
	@Test
	void verify_map_with_Xs_for_4_or_less_agacents_after_2_ticks() throws Exception {
		String expectedArea = ""
				+ ".......x..\n"
				+ ".@@.x.x.@x\n"
				+ "x@@@@...@@\n"
				+ "x.@@@@..x.\n"
				+ ".@.@@@@.x.\n"
				+ ".x@@@@@@.x\n"
				+ ".x.@.@.@@@\n"
				+ "..@@@.@@@@\n"
				+ ".x@@@@@@@.\n"
				+ "....@@@...\n";
		Map after1Tick = day4.markLessThan4AgacentsWithXInMap(day4.map);
		assertEquals(expectedArea, day4.markLessThan4AgacentsWithXInMap(after1Tick).toString());
	}
	@Test
	void verify_map_with_Xs_for_4_or_less_agacents_after_3_ticks() throws Exception {
		String expectedArea = ""
				+ "..........\n"
				+ ".x@.....x.\n"
				+ ".@@@@...xx\n"
				+ "..@@@@....\n"
				+ ".x.@@@@...\n"
				+ "..@@@@@@..\n"
				+ "...@.@.@@x\n"
				+ "..@@@.@@@@\n"
				+ "..x@@@@@@.\n"
				+ "....@@@...\n";
		Map after1Tick = day4.markLessThan4AgacentsWithXInMap(day4.map);
		Map after2Tick = day4.markLessThan4AgacentsWithXInMap(after1Tick);
		assertEquals(expectedArea, day4.markLessThan4AgacentsWithXInMap(after2Tick).toString());
	}
	@Test
	void verify_map_with_Xs_for_4_or_less_agacents_after_9_ticks() throws Exception {
		String expectedArea = ""
				+ "..........\n"
				+ "..........\n"
				+ "..........\n"
				+ "...x@@....\n"
				+ "...@@@@...\n"
				+ "...@@@@@..\n"
				+ "...@.@.@@.\n"
				+ "...@@.@@@.\n"
				+ "...@@@@@..\n"
				+ "....@@@...\n";
		Map after1Tick = day4.markLessThan4AgacentsWithXInMap(day4.map);
		Map after2Tick = day4.markLessThan4AgacentsWithXInMap(after1Tick);
		Map after3Tick = day4.markLessThan4AgacentsWithXInMap(after2Tick);
		Map after4Tick = day4.markLessThan4AgacentsWithXInMap(after3Tick);
		Map after5Tick = day4.markLessThan4AgacentsWithXInMap(after4Tick);
		Map after6Tick = day4.markLessThan4AgacentsWithXInMap(after5Tick);
		Map after7Tick = day4.markLessThan4AgacentsWithXInMap(after6Tick);
		Map after8Tick = day4.markLessThan4AgacentsWithXInMap(after7Tick);
		assertEquals(expectedArea, day4.markLessThan4AgacentsWithXInMap(after8Tick).toString());
	}

	@Test
	void verify_we_can_detect_when_no_more_paper_can_be_accessed() throws Exception {
		assertEquals(9, day4.getNumOfTicksUntilAllPaperIsAccessed(10));
	}
	
	@Test
	void verify_there_are_43_more_papers_in_original_map_than_finished_map_in_Sample() throws Exception {
		day4.getNumOfTicksUntilAllPaperIsAccessed(10);
		assertEquals(43, day4.getCountOfAll_thing_InNewMap(day4.map, '@') - day4.getCountOfAll_thing_InNewMap(day4.finishedMapAfterAllPaperIsAccessed, '@'));
	}
	
	@Test
	void part2_answer() throws Exception {
		day4 = new Day4();
//		System.out.println("ticks: " + day4.getNumOfTicksUntilAllPaperIsAccessed(100));
		assertEquals(47, day4.getNumOfTicksUntilAllPaperIsAccessed(100));
//		System.out.println("papers accessed: " + 
//				(day4.getCountOfAll_thing_InNewMap(day4.map, '@') - day4.getCountOfAll_thing_InNewMap(day4.finishedMapAfterAllPaperIsAccessed, '@')));
		assertEquals(8409, day4.getCountOfAll_thing_InNewMap(day4.map, '@') - day4.getCountOfAll_thing_InNewMap(day4.finishedMapAfterAllPaperIsAccessed, '@'));
	}
}
