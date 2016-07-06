import java.util.Scanner;

public class CheckAmount {
	
	/** runs the program, asks the user for their input, then validates it.
	once it gets the number it starts formatting by calling
	methods in the class. gives user option to quit or continue */
	public void startProgram()
	{
		Scanner userInput = new Scanner(System.in);
		
		
		boolean done = false;
		while(!done)
		{
			System.out.println("Enter number: ");
			int num = userInput.nextInt();
			if(num<1)
			{
				System.out.println("invalid value");
				continue;
			}
			//if number is 1000+ then use these steps
			if(num>999)
			{
				//seperate the number into 2 pairs of hundreds
				int hundreds = num%1000;
				num -= hundreds;
				num = num/1000;
				
				//this is for numbers like 1,000 , 2,000 etc.
				if(hundreds==0){
					System.out.printf("%d,%d%d%d ", num,hundreds,hundreds,hundreds);
				    System.out.print(" '" + wordFormat(num) + " thousand " + wordFormat(hundreds) + "' \n");
				}
				
				//display number separated by comma then in word format
				else{
					System.out.printf("%d,%d ", num,hundreds);
					System.out.print( " '" + wordFormat(num) + " thousand " + wordFormat(hundreds) + "' \n");
				}
			}
			//if not over 1000 then just display number regularly and in word format
			else{
				System.out.print(num);
				System.out.print(" '" + wordFormat(num) + "' \n");
			}
			
			System.out.println("Continue Y/N : ");
			String cont = userInput.next();
			
			cont = cont.toUpperCase();
			if(cont.equals("N"))
				done = true;
			
				
			
		}
		
		
		
		
		userInput.close();
	}
	
	/**takes number and separate it. then calls methods to return the number
	in word format and append it to the return string*/
	public String wordFormat(int n)
	{
		String rtn = "";
		//if its over 100 then take off the first digit 
		//get it in word format and append to string
		if(n>99)
		{
			int hundred = n;
			n = n%100;
			hundred = hundred - n;
			hundred = hundred/100;
			
			rtn += single(hundred) + " hundred ";
		}
		//if number is under 20 then just call method to get word format
		if(n<20)
		{
			rtn += single(n);
		}
		//if over 20 then seperate the number into 2 and then get word format and append to string
		else if(n<99)
		{
			int secondDigit = n%10;
			n -= secondDigit;
			n = n/10;
			
			rtn += tens(n) + " " + single(secondDigit);
		}
		
		return rtn;
		

		
	}
	
	/**takes a number and returns the word format of that number*/
	public String single(int n)
	{
		switch(n) {
		case 0:
			return "";
		case 1: 
			return "one";
		case 2: 
			return "two";
		case 3: 
			return "three";
		case 4: 
			return "four";
		case 5: 
			return "five";
		case 6: 
			return "six";
		case 7: 
			return "seven";
		case 8: 
			return "eight";
		case 9: 
			return "nine";
		case 10: 
			return "ten";
		case 11: 
			return "eleven";
		case 12: 
			return "twelve";
		case 13: 
			return "thirteen";
		case 14: 
			return "fourteen";
		case 15: 
			return "fifteen";
		case 16: 
			return "sixteen";
		case 17: 
			return "seventeen";
		case 18: 
			return "eighteen";
		case 19: 
			return "nineteen";
			default:
				return null;
			
		}
	}
	/**takes a number and returns word format for the second digit from the right*/
	public String tens(int n)
	{
		switch(n)
		{
		case 2:
			return "twenty";
		case 3: 
			return "thirty";
		case 4: 
			return "forty";
		case 5: 
			return "fifty";
		case 6: 
			return "sixty";
		case 7: 
			return "seventy";
		case 8: 
			return "eighty";
		case 9: 
			return "ninety";
			default:
				return null;
		}
	}

}
