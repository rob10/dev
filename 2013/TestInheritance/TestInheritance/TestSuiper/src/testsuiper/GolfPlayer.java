/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testsuiper;

/**
 *
 * @author azejnilo
 */
public class GolfPlayer extends Person {
    int handicap;
    int pgaRanking;
    
    public GolfPlayer(String name, int age, int h, int r)
    {
        // call the super class constructor
        super(name, age);
        
        handicap = h;
        pgaRanking = r;
    }
    
    int getRanking()
    {
        return pgaRanking;
    }
    
    int getHandicap()
    {
        return handicap;
    }
}
