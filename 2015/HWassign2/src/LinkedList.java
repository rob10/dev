
public class LinkedList {
	
	private Node head;
	private int nodeCount;
	
	public void addToHead(int i)
	{
		Node node = new Node();
		node.setData(i);
		
		node.setNext(head);
		head = node;
		nodeCount++;
		
	}
	
	public int removeFromTail()
	{
		if(nodeCount == 0)
		{
			return 0;
		}
		
		Node current = head;
		Node previous = null;
		
		while(current.getNext() != null)
		{
			previous = current;
			current = current.getNext();
		}
		
		previous.setNext(null);
		nodeCount--;
		
		return current.getData();
		
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
