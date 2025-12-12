package day2;

import java.util.ArrayList;

public class IDRange {

	private long left;
	private long right;
	
	public IDRange(String inputLine) {
		String leftVal = inputLine.substring(0, inputLine.indexOf("-"));
		left = Long.valueOf(leftVal);
		String rightVal = inputLine.substring(inputLine.indexOf("-")+1);
		right = Long.valueOf(rightVal);
	}
	
	protected long getLeft() {
		return left;
	}
	protected long getRight() {
		return right;
	}

	@Override
	public String toString() {
		return "left: " + left + ", right:  " + right;
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if(!(obj instanceof IDRange)) { return false; }
        IDRange other = (IDRange) obj;

        if(this.right != other.right) { return false; }
        if(this.left != other.left) { return false; }
        
        return true;
    }
    
    public ArrayList<Long> getInvalidIDsBetweenLeftAndRight() {
    	ArrayList<Long> returnList = new ArrayList<Long>();
    	for(long curID = left; curID<=right; curID++) {
    		if(isInvalidID(String.valueOf(curID))) {
    			returnList.add(curID);
    		}
    	}
    	return returnList;
    }

	private boolean isInvalidID(String curID) {
		if(curID.length()%2!=0) {
			return false;
		}
		String firstHalf = curID.substring(0, curID.length()/2);
		String secondHalf = curID.substring(curID.length()/2);
		return firstHalf.equals(secondHalf);
	}
}
