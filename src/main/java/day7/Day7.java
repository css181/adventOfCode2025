package day7;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.Coordinate;
import utilities.FileUtility;
import utilities.Map;

public class Day7 {

	private static File file;
	protected Map map;
	public int ticks = 0;
	public ArrayList<Coordinate> beamList;
	public int numberOfSplits;

	public Day7() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}
	public Day7(File file) {
		setFileToUse(file);
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day7.file = file;
	}

	public void populateInput() {
		ArrayList<ArrayList<Character>> area = FileUtility.convertFileToCharacterArray(file);
		map = new Map(area);
		beamList = new ArrayList<Coordinate>();
		numberOfSplits = 0;
	}
	
	public void tick() {
		if(beamList.size()==0) {
			//First tick
			for (int col=0; col<map.getArea().get(0).size(); col++) {
				char character = map.getCellValue(0, col);
				if(character=='S') {
					map.updateArea(1, col, '|');
					beamList.add(new Coordinate(1, col));
				}
			}
		} else {
			int size = beamList.size();
			for (int x=0; x<size; x++) {
				Coordinate coord = beamList.get(x);
				if(isSpaceEmpty(new Coordinate(coord.getRow()+1, coord.getCol()))) {
					map.updateArea((int) (coord.getRow()+1), (int) coord.getCol(), '|');
					beamList.set(x, new Coordinate(coord.getRow()+1, coord.getCol()));
				} else {
					//split it.
					if(isSpaceEmpty(new Coordinate(coord.getRow()+1, coord.getCol()-1))) {
						map.updateArea((int) (coord.getRow()+1), (int) coord.getCol()-1, '|');
						beamList.set(x, new Coordinate(coord.getRow()+1, coord.getCol()-1));
					}
					if(isSpaceEmpty(new Coordinate(coord.getRow()+1, coord.getCol()+1))) {
						map.updateArea((int) (coord.getRow()+1), (int) coord.getCol()+1, '|');
						beamList.add(new Coordinate(coord.getRow()+1, coord.getCol()+1));
					}
					numberOfSplits++;
				}
			}
		}
		ticks++;
		removeAnyDuplicateBeams();
	}
	
	private void removeAnyDuplicateBeams() {
		for(int i=0; i<beamList.size(); i++) {
			Coordinate curBeam = beamList.get(i);
			for(int j=0; j<beamList.size(); j++) {
				Coordinate checkBeam = beamList.get(j);
				if(i==j) { continue; }
				if(curBeam.equals(checkBeam)) {
					beamList.remove(j);
				}
			}
		}
	}
	private boolean isSpaceEmpty(Coordinate coordinate) {
		return (map.getCellValue((int)coordinate.getRow(), (int)coordinate.getCol())=='.') ||
				(map.getCellValue((int)coordinate.getRow(), (int)coordinate.getCol())=='|');
	}
}
