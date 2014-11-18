/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assign1;

/**
 *
 * @author Robert
 */
public class Manufacturer {
    
    String name;
    Address addr;
    
    Manufacturer (String name, Address addr)
    {
        //set local variables
        this.name = name;
        this.addr = addr;
    }
    //return name
    String getName()
    {
        return name;
    }
    //changes name
    void changeName(String n)
    {
        name = n;
    }
    //changes address
    void changeAddr(Address a)
    {
        addr = a;
    }
    //returns address
    Address getAddr()
    {
        return addr;
    }
    //used for output
    @Override
    public String toString()
    {
        return String.format(" %s\t %s", name, addr.toString());
    }
    
}
