package testoverriding;


import testoverriding.Animal;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author azejnilo
 */
public class Cat extends Animal{
    private String speak;
    
    public Cat()
    {
        speak = "Meow";
    }
    
    public String getLanguage()
    {
        return speak;
    }
    
}
