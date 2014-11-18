/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testcryptography;

/**
 *
 * @author Robert
 */
public class Caesar extends Cipher
{
	public Caesar(String s)
	{
		super(s);
	}
	@Override
        public String encode(String word)
	{
		StringBuffer result = new StringBuffer();
		
		for (int i = 0; i < word.length(); i++)
		{
			char ch = word.charAt(i);
			ch = determineCharacter(ch, Constants.ENCODE_SHIFT);
			result.append(ch);
		}
		return result.toString();
	}
        @Override
        public String decode(String word)
	{
		StringBuffer result = new StringBuffer();
		
		for (int i = 0; i < word.length(); i++)
		{
			char ch = word.charAt(i);
			ch = determineCharacter(ch, Constants.DECODE_SHIFT);
			result.append(ch);
		}
		return result.toString();
	}
	
public char determineCharacter(char ch, int shift)
	{
		if(Character.isLowerCase(ch))
			ch = (char)('a' + (ch - 'a' + shift) % Constants.WRAP_AROUND);
		return ch;
	}
}
