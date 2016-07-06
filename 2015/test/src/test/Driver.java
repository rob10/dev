package test;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Driver me = new Driver();
		
		me.start();

	}
	
	public void start()
	{
		
		MyBTree tree = new MyBTree();
		
		tree.add("Lizard");
		tree.add("Ball");
		tree.add("Snake");
		tree.add("Apple");
		tree.add("Cat");
		tree.add("Beagle");
		tree.add("Moose");
		tree.add("Zebra");
		
		tree.printTree();

		System.out.println("\n\n");
		System.out.println(tree.getLeftmostData());
		System.out.println(tree.getRightmostData());
		
	}
	
	
	public int convert(String num)
	{
		String[] split = num.split("");
		//int[] newNums = new int[split.length];
		
		int rtn = 0;
		
		int temp = 0;
		int prev = 0;
		
		for(int i = split.length-1; i>=0; i--)
		{
			switch(split[i])
			{
			case "I":
				temp = 1;
				break;
			case "V":
				temp = 5;
				break;
			case "X":
				temp = 10;
				break;
			case "L":
				temp = 50;
				break;
			case "C":
				temp = 100;
				break;
				default:
					
			}
			
			if(temp<prev)
				rtn -= temp;
			else
				rtn += temp;
			
			prev = temp;
				
		}
		

			
		
		
		return rtn;
		
		
		
	}

}
