/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package softdev2;


import java.util.*;
/**
 *
 * @author Rob
 */
public class Softdev2 {

    /**
     * @param args the command line arguments
     */
    
    List<String> list = new LinkedList<>();
    
    void start()
    {
        list.add("Rob");
        list.add("Gomez");
        list.add("Maitte");
        list.add("Barrientos");
        
        System.out.println(list);
        
        list.remove("Gomez");
        
        ListIterator<String> iter = list.listIterator();
        
        while(iter.hasNext())
            System.out.println(iter.next());
        
        
        iter = list.listIterator(list.size());
        
        while(iter.hasPrevious())
            System.out.println(iter.previous());
         
        list.add(1, "Gomez");
        
        System.out.println(list);
        
        iter = list.listIterator();
        
        while(iter.hasNext())
        {
            String temp = iter.next();
            if(temp.equals("Rob"))
            {
                iter.set("Robert");
            }
        }
        System.out.println(list);
        
        iter = list.listIterator(list.size());
        
        String n = iter.previous();
   
        
    }
   
    public static void main(String[] args) {
        new Softdev2().start();
    }
    
     
}
