/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testsuiper;

/**
 *
 * @author azejnilo
 */
public class TestSuiper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GolfPlayer myPlayer = new GolfPlayer("Yani Tzeng", 23, -3, 1);
        
        System.out.println("Name: " + myPlayer.getName());
        System.out.println("Age: " + myPlayer.getAge());
        System.out.println("Handicap: " + myPlayer.getHandicap());
        System.out.println("Ranking: " + myPlayer.getRanking());
    }
}
