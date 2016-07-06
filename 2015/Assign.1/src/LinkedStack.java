
public class LinkedStack {
	
	Node head = null;
	int stackDepth = 0;
	
	
	public boolean push(String data) {
		Node n = new Node();
		
		n.setData(data);

		n.setNext(head);
		head = n;
		
		stackDepth++;
		return false;
	}

	
	public String pop() {
		
		if (stackEmpty()) {
			return null;
		}
		
		Node n = head;
		head = head.getNext();
		stackDepth--;
		return n.getData();
	}

	
	public boolean stackFull() {
		return false;
	}

	
	public boolean stackEmpty() {
		return stackDepth == 0;
	}


	public void clear() {
		while (!stackEmpty()) {
			pop();
		}
	}

	
	public String stackTop() {
		if (stackEmpty()) {
			return null;
		}

		return head.getData();
	}


	public int stackDepth() {
		return stackDepth;
	}

	public String toString() {
		String rtn = "";
		
		if (stackEmpty()) {
			return "<empty>";
		}
		Node n = head;
		while (n != null) {
			if (n == head) {
				rtn += "top-> ";
			} else {
				rtn += "      ";
			}
			
			rtn += "<" + n.getData() + ">\n";
			
			n = n.getNext();
		}
		
		return rtn;
		
		
	}

}
