/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testsuiper;

/**
 *
 * @author azejnilo
 */
public class Person {
    private String name;
    private int    age;
    
    public Person(String n, int a)
    {
        name = n;
        age = a;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getAge()
    {
        return age;
    }
}
