/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testcryptography;

/**
 *
 * @author Robert
 */
import java.util.StringTokenizer;
public abstract class Cipher implements Constants
{
	private String message; // The message string
	StringBuffer   encrypted_message, 
		        decrypted_message;
	public Cipher(String text)
	{
		message = text;
	}
	
	public final void encrypt()
	{
		/* The message string is tokenized into individual words, and each word is encoded    
    		     by calling the encode method     	
		*/
		encrypted_message = new StringBuffer(""); 
		StringTokenizer words = new StringTokenizer(message);
		
		while(words.hasMoreTokens())
		{
			String s = words.nextToken();
			s = encode(s) + " ";
			encrypted_message.append(s);
		}
	}
	
	public final void decrypt(String message)
	{
		/* The encoded message string is tokenized into individual words, and each word is   
     		     encoded  by calling the decode method 
     		*/

		decrypted_message = new StringBuffer(""); 
		StringTokenizer words = new StringTokenizer(message);
	 
		while(words.hasMoreTokens())
		{
			String s = words.nextToken();
			s = decode(s) + " ";
			decrypted_message.append(s);
		} 
	}
	
	String getEncodedMessage()
	{
		return encrypted_message.toString();
	}
		
	String getDecodedMessage()
	{
		return decrypted_message.toString();
	}
	
	public abstract String encode(String s);
	public abstract String decode(String s);
}
