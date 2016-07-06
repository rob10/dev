import java.util.Collections;
import java.util.stream.IntStream;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		me.startProgram();
	}
	
	
	
	void startProgram() {
		
		//initialize integer array
		int[] letters = new int[30];
		
		
		/*
		 * Generate random numbers ranging from 1 -26,
		 * then add 64 to them to get numbers 65-90.
		 * in the ascii table the char value of 65-90
		 * is the alphabet in capital letters. this would
		 * generate 30 random letters. 
		 * 
		 */
		for(int i = 0; i<30 ; i++) {
			int random = (int)(Math.random() * 26 + 1);
			random += 64;
			letters[i] = random;
			
			
		}
		
		//use int stream to sort the int array and then when displaying it cast the value to a char
		IntStream.of(letters).sorted().forEach(letter -> System.out.println((char) letter));
	
		
		System.out.println("------------------------------");
		
		//map the int array to objects to then be able to use the collection reverse order function to reverse the order 
		//of the objects then map the objects back to an array of ints and then cast the int to a char when displaying
		IntStream.range(1, letters.length + 1).mapToObj(
			    i -> letters[letters.length - i]).sorted(Collections.reverseOrder()).mapToInt(i -> i).forEach(letter -> System.out.println((char) letter));	
		
		System.out.println("------------------------------");
		
		//use distinct function to remoce duplicates then display each int by casting it to a char
		IntStream.of(letters).distinct().sorted().forEach(letter -> System.out.println((char) letter));
		
		
		
		


		
		
		
		
	}

}
