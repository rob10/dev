
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Driver me = new Driver();
		
		me.startProg();
		
		

	}
	
	public void startProg()
	{
		Node a = new Node();
		Node b = new Node();
		Node c = new Node();
		
		a.setData("one");
		b.setData("two");
		c.setData("three");
		
		DoublyLinkedList test = new DoublyLinkedList();
		
		test.addToHead(a.getData());
		test.addToHead(b.getData());
		test.addToHead(c.getData());
		
		
		
		test.addToTail("zero");
		
		test.addToHead("four");
		
		System.out.println(test.toString());
	}

}
