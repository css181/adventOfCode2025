package day6;

import java.util.ArrayList;

public class Problem {

	private ArrayList<Long> numbers;
	private boolean isAddition;
	
	public Problem(ArrayList<Long> numbers, boolean isAddition) {
		this.numbers = numbers;
		this.isAddition = isAddition;
	}
	public Problem() {
		
	}
	
	protected ArrayList<Long> getNumbers() {
		return numbers;
	}
	protected void setNumbers(ArrayList<Long> numbers) {
		this.numbers = numbers;
	}
	protected boolean getIsPossible() {
		return this.isAddition;
	}

	@Override
	public String toString() {
		return "numbers: " + numbers + ", isAddition:  " + isAddition;
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if(!(obj instanceof Problem)) { return false; }
        Problem other = (Problem) obj;

        if(!this.numbers.equals(other.numbers)) { return false; }
        if(this.isAddition != other.isAddition) { return false; }
        
        return true;
    }

	public Long getAnswer() {
		if(isAddition) {
			long sum = 0;
			for (Long number : numbers) {
				sum+=number;
			}
			return sum;
		} else {
			long mult = 1;
			for (Long number : numbers) {
				mult*=number;
			}
			return mult;
		}
	}

}
