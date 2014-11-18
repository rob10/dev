/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testcryptography;

/**
 *
 * @author Robert
 */
public class Transpose extends Cipher
{
        String reverseWord;
	Transpose(String s)
	{
		super(s);
	}
        @Override
	public String encode(String word)
	{
		StringBuffer sb = new StringBuffer(word);
                 sb = sb.reverse();
                 return sb.toString();
	}
        @Override
	public String decode(String word)
	{
		return encode(word);
	}
        public char determineCharacter(char ch, int shift)
	{
		if(Character.isLowerCase(ch))
			ch = (char)('a' + (ch - 'a' + shift) % Constants.WRAP_AROUND);
		return ch;
	}
}

