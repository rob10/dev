import java.util.Random;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Driver me = new Driver();
		me.startProgram();
	}
	
	public void startProgram()
	{
		// instantiate variables
		int userGuess =  0;
		int guessCount = 0;
		int generatedNumber = 0;
		Scanner userInput = new Scanner( System.in );
		
	    //generate random number
		Random rand = new Random();
		generatedNumber = rand.nextInt((1000 - 1) + 1) + 1;
		
		//start while loop
		while(userGuess!=generatedNumber)
		{
			guessCount++;
			
			//take user input
			System.out.print("Guess a number 1-1000: ");
			//make sure its a number
			if(!userInput.hasNextInt())
			{
				System.out.println("not a number!");
				userInput.next();
				
			}else{
			
				//use method to compare if matches
				userGuess = userInput.nextInt();
				//userIsRight = random.compareNumber(userGuess);
				if(userGuess > generatedNumber)
				{
					System.out.println("Too high");
				}
				else if(userGuess < generatedNumber){
					System.out.println("Too low");
				}				
			}
		}
		//show how many guesses it took
		System.out.println("Correct! It took you " + guessCount + " guesses.");
		userInput.close();
	}
}
