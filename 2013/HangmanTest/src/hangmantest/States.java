/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmantest;

/**
 *
 * @author Robert
 */
public class States {
    
    void initialState()
   
{
      
    System.out.println("\t+----+");
	  
    System.out.println("\t|    |");
	  
    System.out.println("\t|     ");
	  
    System.out.println("\t|     ");
	  
    System.out.println("\t|     ");
	  
    System.out.println("\t|     ");
	  
    System.out.println("\t=============");
   
}
   
   


   
void stateOne()
   
{
      
    System.out.println("\t+----+");
	  
    System.out.println("\t|    |");
	  
    System.out.println("\t|    O");
	  
    System.out.println("\t|     ");
	  
    System.out.println("\t|     ");
	  
    System.out.println("\t|     ");
	  
    System.out.println("\t=============");
   
}
   
   

void stateTwo()
   
{
      
    System.out.println("\t+----+");
	  
    System.out.println("\t|    |");
	  
    System.out.println("\t|    O");
	  
    System.out.println("\t|   /|");
	  
    System.out.println("\t|     ");
	  
    System.out.println("\t|     ");
	  
    System.out.println("\t=============");
   
}
   
   

void stateThree()
   
{
      
    System.out.println("\t+----+");
	  
    System.out.println("\t|    |");
	  
    System.out.println("\t|    O");
	  
    System.out.println("\t|   /|\\");
	  
    System.out.println("\t|     ");
	  
    System.out.println("\t|     ");
	  
    System.out.println("\t=============");
   
}
   
    

void stateFour()
    
{
      
    System.out.println("\t+----+");
	  
    System.out.println("\t|    |");
	  
    System.out.println("\t|    O");
	  
    System.out.println("\t|   /|\\");
	  
    System.out.println("\t|   /  ");
	  
    System.out.println("\t|     ");
	  
    System.out.println("\t=============");
    
}
	

   

void deadState()
   
{
      
    System.out.println("\t+----+");
	  
    System.out.println("\t|    |");
	  
    System.out.println("\t|    O ");
	  
    System.out.println("\t|   /|\\ ");
	  
    System.out.println("\t|   / \\");
	  
    System.out.println("\t|You lost! ");
	  
    System.out.println("\t=============");
   
}
    
}
