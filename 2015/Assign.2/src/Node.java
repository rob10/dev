
public class Node {
	private Airplane data;
	private Node next;
	
	public Airplane getData() {
		return data;
	}
	public void setData(Airplane data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	public String toString() {
		return "" + data;
	}
}