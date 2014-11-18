/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmantest;

/**
 *
 * @author Robert
 */
import java.util.Scanner;
import java.util.Random;
public class HangmanTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //declare all variable, and initialize the ones that need to initialized
        int x= 0, miss,userWin = 0, compWin = 0, messageWin, messageLose, num;
        char letter, avaiLetter;
        String word, correct, cont, randWord, guess, available;
        boolean gameOver;
        //Array of all words that will be given to guess
        String[] words = { "florida" , "georgia" , "alabama" , "louisiana" ,
                  "texas" , "virginia" , "oklahoma" , "maryland",
                  "kentucky" , "ohio" , "oregon" , "california",
                  "utah", "iowa" , "illinois", "maine" , "vermont",
                  "nebraska" , "indiana", "arizona", "hawaii", "alaska", 
                  "minnesota", "michigan", "vermont" , "kansas" , "idaho",
                  "winsconsin", "missouri", "delaware"};
        //for user inout
        Scanner userInput = new Scanner(System.in);
        
        //to get random word later
        Random randomWord = new Random();
        
        //to be able to call states
        States state = new States();
        
        //main loop
        do
        {
            //generate random word
            randWord = words[randomWord.nextInt(30)];
            
            //replace all everything in random word with asterik
            guess = randWord.replaceAll("[A-Za-z]","*");
            
            System.out.println("I am thinking of a phrase... ");
            
            //call initial state method
            state.initialState(); 
            
            //initialize this boolean variable to be able to enter 2nd loop everytime
            gameOver = false;
            
            //initialize this variable here so it resets everytime
            miss = 0;
            
            //initialize this char here so it resets everytime
            correct = "";
            
            //initialize this variable here so it resets everytime
            messageWin = 0;
            
            //initialize this variable here so it resets everytime
            messageLose = 0;
            
            //initialize this String here so it resets everytime
            available = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
            
            //second loop
            while(gameOver == false)
            {
                
                //print out the asteriks
                System.out.println(guess);
                
                //print out letter bank
                System.out.println(available);
            
                //System.out.println(randWord);
                
                System.out.print("Guess a letter: ");
                
                //get user input
                word = userInput.nextLine();
                
                //get char from string
                letter = word.charAt(0);
                
                //convert to uppercase and store here to be able to replace
                //the letter in the word bank
                String avaiL = word.toUpperCase();
                
                //get char
                avaiLetter = avaiL.charAt(0);
                
                //replace the letter with -
                available = available.replace(avaiLetter, '-');
                
                //get the position of the letter
                num = randWord.indexOf(letter);
                
                //if -1 is not returned then enter this
                if(num != -1)
                {
                    //Replace letters that were not guessed with asteriks
                    correct = correct + letter;
                    guess = randWord.replaceAll("[^"+correct+" ]","*");
                    //if there are no more to be replaced enter this
                    if(randWord.replaceAll("["+correct+"]","").length() == 0)
                    {
                        //keep count of user win
                        userWin++;
                        //used to know which message to show later
                        messageWin++;
                        //break out of loop
                        gameOver = true;  
                    }
                }
                else
                {
                    //keep count of misses
                    miss++;
                }
                // use to know which state to show depending on amount of misses
                //and if they have lost
                switch(miss)
                {
                        case 1: state.stateOne();
                            break;
                        case 2: state.stateTwo();
                            break;
                        case 3: state.stateThree();
                            break;
                        case 4: state.stateFour();
                            break;
                        case 5: state.deadState();
                        //keep total of computer win
                            compWin++;
                        //used to know which message to show later
                            messageLose++;
                        //break out of loop
                            gameOver = true;
                            break;
                        default :
                            state.initialState();
                            break;
                            
                }
                              
            }
            //if user wins show this
            if(messageWin > messageLose)
            {
                System.out.println(randWord);
                System.out.println("You win this round!");
            }
            //if comp win show this
            else
            {
                System.out.println("You lose!");
                System.out.println("Word was: " + randWord);
            }
            //ask user if he wants to keep playing
            System.out.println("Continue(Y/N): ");
            //show scores
            System.out.println("Score| User: " + userWin + " Computer: " + compWin);
            //get user input
            cont = userInput.nextLine();
            //convert to uppecase
            cont = cont.toUpperCase();
            //get char
            char contL = cont.charAt(0);
            //if user chooses 'No' break out of loop, if not just keep them in loop
            if(contL == 'N')
            {
                x = 1;
            }
            
        }while(x != 1);
        {
            //show final message and final score
            System.out.println("Thank you for playing!");
            System.out.println("End Score| User: " + userWin + " Computer: " + compWin);
            
        }
        
        
    
    }
}
