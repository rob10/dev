/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testcryptography;

/**
 *
 * @author Robert
 */
public interface Constants {
    
    int WRAP_AROUND = 26;
    int ENCODE_SHIFT = 3;
    int DECODE_SHIFT = 23;
    
    public abstract String encode(String s);
    public abstract String decode(String s);
    
}
