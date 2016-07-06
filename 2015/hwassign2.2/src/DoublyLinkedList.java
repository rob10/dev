
public class DoublyLinkedList {
	
	private Node head;
	private Node tail;
	private int nodeCount;

	
	public void addToHead(String s)
	{
		Node node = new Node();
		node.setData(s);
		
		node.setNext(head);
		head.setPrevious(node);
		head = node;
		head.setPrevious(null);
		
		nodeCount++;
		
	}
	
	public void addToTail(String s)
	{
		
		if(tail == null)
		{
			Node runner = head;
			while (runner.getNext() != null) {
				
				runner = runner.getNext();
			}
			
			tail = runner;
			
		}
		
		Node n = new Node();
		n.setData(s);
		
		tail.setNext(n);
		
		n.setPrevious(tail);
		tail.setNext(n);
		tail = n;
		tail.setNext(null);
		
		nodeCount++;
	}
	
	public Node removeFromHead()
	{
		if (nodeCount == 0) {
			return null;
		} else {
			Node copy = head;
			head = head.getNext();
			copy.setNext(null);
			
			nodeCount--;
			return copy;
		}
	}
	
	public Node removeFromTail()
	{
		if (nodeCount == 0) {
			return null;
		} else {
			Node copy = tail;
			tail = tail.getPrevious();
			copy.setPrevious(null);
			
			nodeCount--;
			return copy;
		}
	}
	
	public String toString()
	{
		String rtn = "";
		if (nodeCount == 0) {
			rtn += "<Empty>";
		} else {
			Node n = head;
			while (n != null) {
				rtn += n.getData() + ", ";
				n = n.getNext();
			}
		}
		return rtn;
		
	}

	

}
