/**************************************************************************************************************************
 * 
 * Robert Gomez
 * COP 3804
 * 
 * 
 * ********************************************************************************************************************/

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testcryptography;

/**
 *
 * @author Robert
 */
import javax.swing.JOptionPane;
public class TestCryptography {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       


	String code, output = "";
		
	String text = JOptionPane.showInputDialog("Enter message");
		
	output += "The original message is \n" + text + "\n";
		
	Cipher c = new Caesar(text);
	c.encrypt();
	code = c.getEncodedMessage();
	output += "\nCeasar Cipher\nThe encrypted message is \n" + code + "\n";
	c.decrypt(code);
	code = c.getDecodedMessage();
	output +="The decrypted message is \n" + code + "\n";
	
	c = new Transpose(text);
	c.encrypt();
	code = c.getEncodedMessage();
	output += "\nTranspose\nThe encrypted Transpose message is \n" + code + "\n";
	c.decrypt(code);
	code = c.getDecodedMessage();
	output +="The decripted Transpose message is \n" + code + "\n";
	
	Reverser r = new Reverser(text);
	r.encrypt();
	code = r.reverseText( text );
	output += "\nReverser\nThe encrypted Reverse message is \n" + code+ "\n";
	code = r.decode(code);	
	output+="The decrypted Reverse message is \n" + code;
	
	System.out.println(output);	
}


}
