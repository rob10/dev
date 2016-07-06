
public class Queue implements Iterator{
	
	private Node head;
	private Node tail;
	private int count;
	private Node iterator;
	
	public Queue() {
		head = tail = null;
		count = 0;
	}
	
	/* (non-Javadoc)
	 * @see MyQueue#add(MyObject)
	 */
	public boolean add(Airplane obj) {
		
		Node n = new Node();
		n.setData(obj);
		
		if (count == 0) {
			head = tail = n;
			count = 1;
		} else {
			tail.setNext(n);
			tail = n;
			count++;
		}
		
		return true;
	}
	
	/* (non-Javadoc)
	 * @see MyQueue#remove()
	 */
	
	public Airplane remove() {
		if (count == 0) {
			return null;
		} else {
			Airplane o = head.getData();
			head = head.getNext();
			count--;
			
			if (count == 0) {
				head = tail = null;
			}
			return o;
		}
	}
	
	/* (non-Javadoc)
	 * @see MyQueue#getCount()
	 */
	
	public int getCount() {
		return count;
	}
	
	/* (non-Javadoc)
	 * @see MyQueue#clear()
	 */
	
	public void clear() {
		while(!isEmpty()) {
			remove();
		}
	}
	
	/* (non-Javadoc)
	 * @see MyQueue#peek()
	 */
	
	public Airplane peek() {
		if (count == 0) {
			return null;
		} else {
			return head.getData();
		}
	}
	
	/* (non-Javadoc)
	 * @see MyQueue#isEmpty()
	 */
	
	public boolean isEmpty() {
		return (count == 0);
	}
	
	/* (non-Javadoc)
	 * @see MyQueue#isFull()
	 */
	
	public boolean isFull() {
		return false;
	}

	public String toString() {
		String rtn = "";
		if (count == 0) {
			rtn = "<Empty>";
		} else {
			Node h = head;
			while (h != null) {
				rtn += h + " ";
				h = h.getNext();
			}
		}
		
		return rtn;
	}
	
	// Used to be able to go through queue and update values of objects in the queue
		@Override
		public boolean hasNext() {
			return (iterator != null);
		}

		@Override
		public Node next() {
			Node rtn = iterator;	
			iterator = iterator.getNext();
			return rtn;
			
			
		}
		
		public void resetIterator() {
			iterator = head;
		}
}


