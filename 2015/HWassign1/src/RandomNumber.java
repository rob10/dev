
public class RandomNumber {
	
	int rNumber;
	
	public RandomNumber(int random)
	{
		rNumber = random;
	
	}
	
	
	public boolean compareNumber(int userGuess)
	{
		
		if(userGuess == rNumber)
		{
			return true;
		}
		else{
			
			return false;
			
		}
	
	}
	public boolean isHigher(int userGuess)
	{
		if(userGuess > rNumber)
		{
			return true;
		}
		else{
			return false;			
		}
		
	}

}
