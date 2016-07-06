package hwassign3;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Driver me = new Driver();
		me.doIt();

	}
	
	void doIt(){
		int count = 1;
		
		int n = 4;
		
		asterik(n,count);
		String s = "1234";
		
		
		System.out.println(convertToInt(s, s.length()-1));
		
		
	}
	
	public void asterik(int n, int count)
	{
		
		if(n==1)
		{
			System.out.print("*\n");
			return;
			
		}
		else if(count<=n)
		{
			for(int i = 0; i<count; i++)
			{
				System.out.print("*");
			}
			System.out.println("");
			
			
			asterik(n,count+1);
		}
		
		else if(count>=n)
		{
			for(int i = 0; i<n; i++)
			{
				System.out.print("*");
			}
			System.out.println("");
						
			asterik(n-1,count);
		}
		
	}
	
	
	public int convertToInt(String s, int count)
	{
		if(count == 0)
		{
			char c = s.charAt(count);
			return (int) (c-48);
		}
		
		char c = s.charAt(count);
		
		return  (c-48) +  convertToInt(s, count-1)*10;
		
		
	}
	
	


}
