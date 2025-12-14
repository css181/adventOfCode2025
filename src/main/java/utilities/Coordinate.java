package utilities;

public class Coordinate {

	private long row;
	private long col;
	public Coordinate(long row, long col) {
		super();
		this.row = row;
		this.col = col;
	}
	public long getRow() {
		return row;
	}
	public long getCol() {
		return col;
	}
	
	@Override
    public String toString() {
    	String print = "(row: " + row + ", col: " + col + ")";
		return print;
    } 
	
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if(!(obj instanceof Coordinate)) { return false; }
        Coordinate other = (Coordinate) obj;

        if(this.row != other.row) { return false; }
        if(this.col != other.col) { return false; }
        
        return true;
    }
    
	public Coordinate getDistanceFrom(Coordinate coordB) {
		return new Coordinate(Math.abs(row-coordB.row), Math.abs(col-coordB.col));
	}
	public int getTotalDistanceFrom(Coordinate coordB) {
		return (int) (Math.abs(row-coordB.row)+ Math.abs(col-coordB.col)); 
	}
}
