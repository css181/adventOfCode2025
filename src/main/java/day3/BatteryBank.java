package day3;

import java.util.ArrayList;

public class BatteryBank {

	private ArrayList<Integer> jolts;
	
	public BatteryBank(String inputLine) {
		jolts = new ArrayList<Integer>();
		for (Character character : inputLine.toCharArray()) {
			jolts.add(Integer.valueOf(String.valueOf(character)));
		}
	}
	
	protected ArrayList<Integer> getJolts() {
		return jolts;
	}
	protected void setJolts(ArrayList<Integer> jolts) {
		this.jolts = jolts;
	}

	@Override
	public String toString() {
		return "jolts: " + jolts;
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if(!(obj instanceof BatteryBank)) { return false; }
        BatteryBank other = (BatteryBank) obj;

        if(!this.jolts.equals(other.jolts)) { return false; }
        
        return true;
    }

	public Long getHighestJoltValue(int totalDigits) {
		int[] highestDigits = new int[totalDigits];
		int highestOfCurDigit = 0;
		int posOfHighest = -1;
		
		for(int digit=0; digit<totalDigits; digit++) {		
			highestOfCurDigit=0;
			for(int pos=posOfHighest+1; pos<jolts.size()-(totalDigits-digit-1); pos++) {
				if(jolts.get(pos) > highestOfCurDigit) { 
					highestOfCurDigit = jolts.get(pos);
					posOfHighest = pos;
					highestDigits[digit] = highestOfCurDigit;
				}
				if(highestOfCurDigit==9) {
					break;
				}
			}
		}
		String returnVal = "";
		for (int x=0; x<highestDigits.length; x++) {
			returnVal+=highestDigits[x];
		}
		return Long.valueOf(returnVal);
	}

}
