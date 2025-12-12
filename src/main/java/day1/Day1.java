package day1;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;
import utilities.Node;

public class Day1 {

	private static File file;
	protected ArrayList<Long> turnSequence = new ArrayList<Long>();
	private int position = 0;
	public Long dialLocation = 50l;
	private Node node99 = new Node(99, null, null);
	private Node node98 = new Node(98, null, node99);
	private Node node97 = new Node(98, null, node98);
	private Node node96 = new Node(97, null, node97);
	private Node node95 = new Node(96, null, node96);
	private Node node94 = new Node(95, null, node95);
	private Node node93 = new Node(94, null, node94);
	private Node node92 = new Node(93, null, node93);
	private Node node91 = new Node(92, null, node92);
	private Node node90 = new Node(91, null, node91);
	private Node node89 = new Node(89, null, node90);
	private Node node88 = new Node(88, null, node89);
	private Node node87 = new Node(87, null, node88);
	private Node node86 = new Node(86, null, node87);
	private Node node85 = new Node(85, null, node86);
	private Node node84 = new Node(84, null, node85);
	private Node node83 = new Node(83, null, node84);
	private Node node82 = new Node(82, null, node83);
	private Node node81 = new Node(81, null, node82);
	private Node node80 = new Node(80, null, node81);
	private Node node79 = new Node(79, null, node80);
	private Node node78 = new Node(78, null, node79);
	private Node node77 = new Node(77, null, node78);
	private Node node76 = new Node(76, null, node77);
	private Node node75 = new Node(75, null, node76);
	private Node node74 = new Node(74, null, node75);
	private Node node73 = new Node(73, null, node74);
	private Node node72 = new Node(72, null, node73);
	private Node node71 = new Node(71, null, node72);
	private Node node70 = new Node(70, null, node71);
	private Node node69 = new Node(69, null, node70);
	private Node node68 = new Node(68, null, node69);
	private Node node67 = new Node(67, null, node68);
	private Node node66 = new Node(66, null, node67);
	private Node node65 = new Node(65, null, node66);
	private Node node64 = new Node(64, null, node65);
	private Node node63 = new Node(63, null, node64);
	private Node node62 = new Node(62, null, node63);
	private Node node61 = new Node(61, null, node62);
	private Node node60 = new Node(60, null, node61);
	private Node node59 = new Node(59, null, node60);
	private Node node58 = new Node(58, null, node59);
	private Node node57 = new Node(57, null, node58);
	private Node node56 = new Node(56, null, node57);
	private Node node55 = new Node(55, null, node56);
	private Node node54 = new Node(54, null, node55);
	private Node node53 = new Node(53, null, node54);
	private Node node52 = new Node(52, null, node53);
	private Node node51 = new Node(51, null, node52);
	private Node node50 = new Node(50, null, node51);
	private Node node49 = new Node(49, null, node50);
	private Node node48 = new Node(48, null, node49);
	private Node node47 = new Node(47, null, node48);
	private Node node46 = new Node(46, null, node47);
	private Node node45 = new Node(45, null, node46);
	private Node node44 = new Node(44, null, node45);
	private Node node43 = new Node(43, null, node44);
	private Node node42 = new Node(42, null, node43);
	private Node node41 = new Node(41, null, node42);
	private Node node40 = new Node(40, null, node41);
	private Node node39 = new Node(39, null, node40);
	private Node node38 = new Node(38, null, node39);
	private Node node37 = new Node(37, null, node38);
	private Node node36 = new Node(36, null, node37);
	private Node node35 = new Node(35, null, node36);
	private Node node34 = new Node(34, null, node35);
	private Node node33 = new Node(33, null, node34);
	private Node node32 = new Node(32, null, node33);
	private Node node31 = new Node(31, null, node32);
	private Node node30 = new Node(30, null, node31);
	private Node node29 = new Node(29, null, node30);
	private Node node28 = new Node(28, null, node29);
	private Node node27 = new Node(27, null, node28);
	private Node node26 = new Node(26, null, node27);
	private Node node25 = new Node(25, null, node26);
	private Node node24 = new Node(24, null, node25);
	private Node node23 = new Node(23, null, node24);
	private Node node22 = new Node(22, null, node23);
	private Node node21 = new Node(21, null, node22);
	private Node node20 = new Node(20, null, node21);
	private Node node19 = new Node(19, null, node20);
	private Node node18 = new Node(18, null, node19);
	private Node node17 = new Node(17, null, node18);
	private Node node16 = new Node(16, null, node17);
	private Node node15 = new Node(15, null, node16);
	private Node node14 = new Node(14, null, node15);
	private Node node13 = new Node(13, null, node14);
	private Node node12 = new Node(12, null, node13);
	private Node node11 = new Node(11, null, node12);
	private Node node10 = new Node(10, null, node11);
	private Node node09 = new Node(9, null, node10);
	private Node node08 = new Node(8, null, node09);
	private Node node07 = new Node(7, null, node08);
	private Node node06 = new Node(6, null, node07);
	private Node node05 = new Node(5, null, node06);
	private Node node04 = new Node(4, null, node05);
	private Node node03 = new Node(3, null, node04);
	private Node node02 = new Node(2, null, node03);
	private Node node01 = new Node(1, null, node02);
	private Node node00 = new Node(0, null, node01);
	private Node curNode;
	
	public Day1() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}
	public Day1(File file) {
		setFileToUse(file);
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day1.file = file;
	}

	public void populateInput() {
		ArrayList<String> inputLines = FileUtility.convertFileToStringArray(file);
		for (String line : inputLines) {
			long rotate = Long.valueOf(line.substring(1));
			if(line.startsWith("L")) {
				rotate*=-1;
			}
			turnSequence.add(rotate);
		}
		node99.setNext(node00);
		node99.setPrev(node98);
		node98.setPrev(node97);
		node97.setPrev(node96);
		node96.setPrev(node95);
		node95.setPrev(node94);
		node94.setPrev(node93);
		node93.setPrev(node92);
		node92.setPrev(node91);
		node91.setPrev(node90);
		node90.setPrev(node89);
		node89.setPrev(node88);
		node88.setPrev(node87);
		node87.setPrev(node86);
		node86.setPrev(node85);
		node85.setPrev(node84);
		node84.setPrev(node83);
		node83.setPrev(node82);
		node82.setPrev(node81);
		node81.setPrev(node80);
		node80.setPrev(node79);
		node79.setPrev(node78);
		node78.setPrev(node77);
		node77.setPrev(node76);
		node76.setPrev(node75);
		node75.setPrev(node74);
		node74.setPrev(node73);
		node73.setPrev(node72);
		node72.setPrev(node71);
		node71.setPrev(node70);
		node70.setPrev(node69);
		node69.setPrev(node68);
		node68.setPrev(node67);
		node67.setPrev(node66);
		node66.setPrev(node65);
		node65.setPrev(node64);
		node64.setPrev(node63);
		node63.setPrev(node62);
		node62.setPrev(node61);
		node61.setPrev(node60);
		node60.setPrev(node59);
		node59.setPrev(node58);
		node58.setPrev(node57);
		node57.setPrev(node56);
		node56.setPrev(node55);
		node55.setPrev(node54);
		node54.setPrev(node53);
		node53.setPrev(node52);
		node52.setPrev(node51);
		node51.setPrev(node50);
		node50.setPrev(node49);
		node49.setPrev(node48);
		node48.setPrev(node47);
		node47.setPrev(node46);
		node46.setPrev(node45);
		node45.setPrev(node44);
		node44.setPrev(node43);
		node43.setPrev(node42);
		node42.setPrev(node41);
		node41.setPrev(node40);
		node40.setPrev(node39);
		node39.setPrev(node38);
		node38.setPrev(node37);
		node37.setPrev(node36);
		node36.setPrev(node35);
		node35.setPrev(node34);
		node34.setPrev(node33);
		node33.setPrev(node32);
		node32.setPrev(node31);
		node31.setPrev(node30);
		node30.setPrev(node29);
		node29.setPrev(node28);
		node28.setPrev(node27);
		node27.setPrev(node26);
		node26.setPrev(node25);
		node25.setPrev(node24);
		node24.setPrev(node23);
		node23.setPrev(node22);
		node22.setPrev(node21);
		node21.setPrev(node20);
		node20.setPrev(node19);
		node19.setPrev(node18);
		node18.setPrev(node17);
		node17.setPrev(node16);
		node16.setPrev(node15);
		node15.setPrev(node14);
		node14.setPrev(node13);
		node13.setPrev(node12);
		node12.setPrev(node11);
		node11.setPrev(node10);
		node10.setPrev(node09);
		node09.setPrev(node08);
		node08.setPrev(node07);
		node07.setPrev(node06);
		node06.setPrev(node05);
		node05.setPrev(node04);
		node04.setPrev(node03);
		node03.setPrev(node02);
		node02.setPrev(node01);
		node01.setPrev(node00);
		node00.setPrev(node99);
		curNode = node50;
	}
	
	public Long turnDial() {
		dialLocation += turnSequence.get(position++);
		while (dialLocation < 0) {
			dialLocation+=100;
		}
		while (dialLocation >= 100) {
			dialLocation-=100;
		}
		return dialLocation;
	}
	public Long getNumOfZeroResultsFromAllTurns() {
		long result = 0;
		for (@SuppressWarnings("unused") Long turn : turnSequence) {
			if(turnDial()==0) {
				result++;
			}
		}
		return result;
	}
	
	public Long getNumOfZeroTouchesFromAllTurns() {
		long result = 0;
		for (@SuppressWarnings("unused") Long turn : turnSequence) {
			result+=getNumOfZeroTouchesFromTurn();
		}
		return result;
	}
	
	private long getNumOfZeroTouchesFromTurn() {
		long turnSize = turnSequence.get(position++);
		return getNode00_touches_from_turningDial(turnSize);
	}
	private long getNode00_touches_from_turningDial(long turnSize) {
		long retValue = 0;
		if(turnSize<0) {
			for(int x=0; x<Math.abs(turnSize); x++) {
				curNode = curNode.getPrev();
				if(curNode.equals(node00)) {
					retValue++;
				}
			}
		} else {
			for(int x=0; x<Math.abs(turnSize); x++) {
				curNode = curNode.getNext();
				if(curNode.equals(node00)) {
					retValue++;
				}
			}
		}
		return retValue;
	}
	
}
