/*
 * Interface for Queue to implement. Used so when Queue is implementing
 * Iterator it is only expecting these methods and not Iterator.remove()
 * which caused conflicts with queue.remove()
 */
public interface Iterator {
	
	
	public boolean hasNext();

	
	public Node next();
	
	public void resetIterator();
}
