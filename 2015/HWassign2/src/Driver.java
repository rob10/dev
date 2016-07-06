
public class Driver {

	public static void main(String[] args) {
		
		Driver me = new Driver ();
		
		me.startProgram();

	}
	
	void startProgram()
	{
		LinkedList list = new LinkedList();
		
		for(int i = 1; i < 11 ; i++)
		{
			list.addToHead(i);
		}
		
		for(int i = 0 ; i<3 ; i++)
		{
			System.out.println(list.toString());
			
			System.out.println("removing from end of list... ");
			
			list.removeFromTail();
			
		}
		
		System.out.println(list.toString());
		
	}

}
