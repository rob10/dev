/*
 * Robert Gomez
 * 
 * 
 * 
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Driver me = new Driver();
		me.doIt();

	}
	
	void doIt()
	{
		//initialize binary tree
		BinaryTree bt =  new BinaryTree();
		//used to keep count of how many words are in file
		int totalWords = 0;
		
		//try catch block for opening the file
		try{
			//read the file
			FileReader fr = new FileReader("345.txt");
			BufferedReader br = new BufferedReader(fr);
			//string where file text is stored
			String str;
			
			//while loop to read through the whole file
			while((str = br.readLine())!=null)
			{
				//set everything to lower case
				str = str.toLowerCase();
				//remove punctuation and symbols
				str = str.replaceAll("[^a-z0-9 ]", "");
				//remove all white spaces
				str = str.trim();
				
				//this if statement is used to make sure no empty lines get read as words
				if(str.length()>0)
				{
					//split the line that was read into an array of 
					//words
					String[] words = str.split("\\s+");
					//add each word in array to binry tree
					for(int i = 0; i<words.length; i++)
					{
						//keep count of how many words are being added
						totalWords++;
						bt.add(words[i]);
					}
					//System.out.println(str);
				}
					
			}
			br.close();
		}
		catch(IOException e){
			System.out.println("file not found");
		}
		
		//print total words
		System.out.println("Text contains " + totalWords + " Total words.");
		//call the method that provides how many times the give word appears
		//and print the returned result
		System.out.println("Transylvania occurs: " + bt.occurence("transylvania") + " times");
		System.out.println("Harker occurs: " + bt.occurence("harker") + " times");
		System.out.println("Renfield occurs: " + bt.occurence("renfield") + " times");
		System.out.println("Vampire occurs: " + bt.occurence("vampire") + " times");
		System.out.println("Expostulate occurs: " + bt.occurence("expostulate") + " times");
		
		//call this method so that every node in binary tree is visited and to be able to get the following
		//info
		bt.deep();
		//call getter methods and display info
		System.out.println("Tree is : " + bt.getDeepestLevel() + " nodes deep");
		System.out.println("Tree contains : " + bt.getCount() + " distinct words");
		System.out.println("Word at root is: " + bt.getRoot());
		System.out.println("Deepest Word is : " + bt.getDeepest());
		System.out.println("Most Frequent is: '" + bt.getFrequent() + "' occurring " + bt.getFrequentCount() + " times");
		
		
		}

}
