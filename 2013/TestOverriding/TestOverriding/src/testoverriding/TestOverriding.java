/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testoverriding;

/**
 *
 * @author azejnilo
 */
public class TestOverriding {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Cat myCat = new Cat();
       System.out.println("Cat speaks: " + myCat.getLanguage());
    }
}
