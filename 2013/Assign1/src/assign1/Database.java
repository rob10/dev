/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assign1;

import java.util.ArrayList;

/**
 *
 * @author Robert
 */
public class Database {
    ArrayList <Product> list;
    Product prod;
    int index;
    boolean found;
    
    
    Database()
    {
        //make new list
        list = new ArrayList<>();
    }
    //add products to list
    void add(Product p)
    {
        list.add(p);
    }
    //search list
    void search(String key)
    {
        index = 0;
        found = false;
        //use loop to look through list
        for(int i = 0; i < list.size() ; i++)
        {
            Product p = (Product)list.get(i);
            
            if((p.name).equals(key))
            {
                prod = p;
                index = i;
                found = true;
            }
        }
     }
    //return if product was found
    Boolean getFound()
    {
        return found;
    }
    //return found product
    Product getProd()
    {
        return prod;        
    }
    //return index of product
    int getIndex()
    {
        return index;
    }
    //return list
    ArrayList<Product> getList()
    {
        return list;
    }
    //if product is in list, display product
    void isInList() 
    {
        IO.display(prod.productDisplay(), "Product ", 1);
    }
            
           
    }

  
