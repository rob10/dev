/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package softdev;

import java.util.*;
/**
 *
 * @author Rob
 */


public class MyLinkedListTest {
	
	List<String> names = new LinkedList<>();
        List<Student> students = new LinkedList<>();
	
	void print() {
		int counter = 0;
		for( String name : names ) {
			counter++;
			System.out.print(name);	
			if( counter < names.size())
				System.out.print(",");
		}
		System.out.println();
	}
	
	void printWithIterator() {
		Iterator<String> it = names.iterator();
		int counter = 0;
		while( it.hasNext()) {
			System.out.print( it.next() );
			if( counter < names.size())
				System.out.print(",");
		}
		System.out.println();		
	}
	
	
	void start() {
		
		names.add("Sam");
		names.add("Joe");
		names.add("William");
		names.add("Dan");
		names.add("William");
		
                
                /*
                int p;
                
                p= names.indexOf("Bill");
                while( p!= -1)
                {
                    names.set(p, "William");
                    p = names.indexOf("Bill");
                }
		
                while( (p = names.indexOf("Bill")) != -1)
                {
                    names.set(p, "William");
                }
                
                */
                
                
                ListIterator<String> iter = names.listIterator();
                while(iter.hasNext())
                {
                    String temp = iter.next();
                    if( temp.equals("William"))
                    {
                        iter.set("Bill");
                        
                    }
                }
                
                
                //Iterator<String> iter = names.iterator();
                //System.out.println(iter.next());
                
                System.out.println(names);
                
                
		
	}	
        
        void start2()
        {
            Student s1 = new Student(100,"Jones", 3.5);
            Student s2 = new Student(100,"Smith", 3.7);
            Student s3 = s1;
            students.add(s1);
        }

	public static void main(String[] args) {
		new MyLinkedListTest().start();

	}

}