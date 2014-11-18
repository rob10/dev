/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assign1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Robert
 */
public class Product {
    Date date;
    String name;
    int quantity;
    double price;
    Manufacturer manufact;
       
    Product(String n, int q, double p, Manufacturer m)
    {
        //set local variables
        name = n;
        quantity = q;
        price = p;
        manufact = m;
        date = new Date();
       
        
    }
    //update quantity
    void update(int q)
    {
        quantity = quantity + q;
    }
    //update price
    void update (double p)
    {
        price = p;
    }
    //update manufacturer
    void update(Manufacturer m)
    {
        manufact = m;
    }
    //return product name
    String getName()
    {
        return name;
    }
    //display product
    String productDisplay()
    {
        return String.format("Product\t Price\t Quantity\n %s\t %s\t %s", name, price, quantity );
    }
    // override toString method to be able to display product list in report
    @Override
    public String toString()
    {
       return String.format("Product\t Date\t\t Quantity\t Price\t Manufacturer   State\n %s\t %s\t %s\t %s\t %s\t \n", 
                             name, date, quantity, price, manufact.toString());
        
    }
    //display updated product
    public void displayUpdated()
    {
        IO.display( productDisplay() , "Product Updated", 1);
    }
    
}
