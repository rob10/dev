package testoverriding;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author azejnilo
 */
public class Animal {
    String speak;
    
    public Animal()
    {
        speak = "I do not speak";
    }
    
    public String getLanguage()
    {
        return speak;
    }
    
}
