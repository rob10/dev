package testtt;

import org.omg.Messaging.SyncScopeHelper;

public class interview {
	
	/*itoa
	itoa is a C routine from stdlib, which takes an integer argument
	String  itoa ( int value);
	Converts a supplied integer into a String object.
	Example: itoa(123) === "123"
	Please implement itoa in any language of your choice, without using helper functions such as printf(), toString() or valueOf())?
	Sample function declarations:
	Java: String itoa(int value)
	*/
	public void test()
	{
		int ita;
		ita = 123;
		
		String converted;
		
		itoa(ita);
		
		
		
	}
	
	String itoa(int val)
	{
		String rtn;
		
		int last2 = val % 100;
		
		int firstDigit = val - last2;
		
		firstDigit = firstDigit/100;
		
		int thirdDigit = last2 % 10;
		
		int secondDigit = last2 -  thirdDigit;
		
		secondDigit = secondDigit/10;
		
		char first = (char) firstDigit;
		
		//char first = 48 + firstDigit;
		
		char second = (char) secondDigit;
		
		char third = (char) thirdDigit;
		
		char[]numbers = { (char) firstDigit, (char) secondDigit, (char) thirdDigit};
		
		
		rtn = new String(numbers);
		
		
		
		
		return rtn;
	}
	
	

}
