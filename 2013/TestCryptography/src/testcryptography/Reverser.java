/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testcryptography;

/**
 *
 * @author Robert
 */
public class Reverser extends Transpose 
{
	Reverser(String s)
	{
		super(s);
	}
        String reverseText(String word)
	{
            StringBuffer result = new StringBuffer();
            
                int j = word.length();
                j -= 1;
		
		for (int i = j; i >= 0; i--)
		{
			char ch = word.charAt(i);
			result.append(ch);
		}
		return result.toString();
		
	}
}
