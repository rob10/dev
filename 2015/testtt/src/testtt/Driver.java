package testtt;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Driver me = new Driver();
		
		me.test();

	}
	
	public void test()
	{
		/*int ita;
		ita = 123;
		
		String converted;
		
		System.out.println(itoa(ita));*/
		
		
		//System.out.println(3%2);
		
		for(int i = 0; i<18;i+=3)
		{
			
			if((i%2)!=1)
				continue;
			System.out.println(i + " ");
			if(i==12)
				break;
		}
		
		
		
	}
	
	String itoa(int val)
	{
		String rtn;
		
		/*int last2 = val % 100;
		
		int firstDigit = val - last2;
		
		firstDigit = firstDigit/100;
		
		int thirdDigit = last2 % 10;
		
		int secondDigit = last2 -  thirdDigit;
		
		secondDigit = secondDigit/10;
		
		char first = (char) firstDigit;
		
		char first = 48 + firstDigit;
		
		char second = (char) secondDigit;
		
		char third = (char) thirdDigit;
		
		firstDigit += 48;
		secondDigit += 48;
		thirdDigit += 48;*/
		
		char[]numbers = new char[10];
		
		
		
		int x =0;
		
		while(val>=10)
		{
			//System.out.println("hey");
			int digit = val%10;
			digit += 48;
			numbers[x] = (char) digit;
			val = val/10;
			x++;
			
		}
		
		numbers[x] = (char)(val+48);
		
		char[]reverse = new char[x+1];
		
		int temp = reverse.length-1;
		
		for (int i = 0; i<reverse.length; i++)
		{
			reverse[temp] = numbers[i];
			temp--;
		}
		
		rtn = new String(reverse);
		
		return rtn;
	}

}
