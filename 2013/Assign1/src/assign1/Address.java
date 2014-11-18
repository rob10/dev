/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assign1;

/**
 *
 * @author Robert
 */
public class Address {
    
    String street;
    String city;
    String state;
    String zip;
    
    Address(String str, String c, String sta, String z)
    {
        //set local variable
        street = str;
        city = c;
        state = sta;
        zip = z;
    }
    //used for output
    @Override
    public String toString()
    {
        return String.format(" %s", state);
    }
    
}
