package utilities;

public class Node {

	private Node prev;
	private long value;
	private Node next;
	
	public Node(long value, Node prev, Node next) {
		this.value = value;
		this.prev = prev;
		this.next = next;
	}
	
	public long getValue() {
		return value;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getPrev() {
		return prev;
	}
	public void setPrev(Node prev) {
		this.prev = prev;
	}

	@Override
	public String toString() {
		long nextValue = -1;
		if(next!=null) {
			nextValue = next.getValue();
		}
		long prevValue = -1;
		if(prev!=null) {
			prevValue = prev.getValue();
		}
		return "{value: " + value + ", prev: " + prevValue + "next: " + nextValue + "}";
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if(!(obj instanceof Node)) { return false; }
        Node other = (Node) obj;

        if(this.value != other.value) { return false; }
        if(this.next==null && other.next!=null) { return false; }
        if(this.next!=null && other.next==null) { return false; }
        if(this.next==null && other.next==null) { return true; }
        if(this.prev==null && other.prev!=null) { return false; }
        if(this.prev!=null && other.prev==null) { return false; }
        if(this.prev==null && other.prev==null) { return true; }
        if(this.getNext().value != (other.getNext().value)) { return false; }
        if(this.getPrev().value != (other.getPrev().value)) { return false; }
        
        return true;
    }

	public void setValue(long value) {
		this.value = value;
	}

}
