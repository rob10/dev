/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1.servletController;

/**
 *
 * @author Rob
 */
public class RequestData {

    protected String athlete;
    protected String sport;
    protected String item;

    public String getAthlete() {
        if (isValidAthlete()) {
            return this.athlete;
        }
        return "LeBron James";
    }

    public void setAthlete(String athlete) {
        this.athlete = athlete;
    }

    public String getSport() {
        if (isValidSport()) {
            return this.sport;
        }

        return "Basketball";
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getItem() {
        if (isValidItem()) {
            return this.item;
        }

        return "Jersey";
    }
    
    String getMessage()
    {
        String message = "Athlete Name: " + athlete + ", Sport: " + sport + ", Item :" 
                + item;
        
        return message;
    }

    public void setItem(String item) {
        this.item = item;
    }

    boolean isValidAthlete() {
        return athlete != null && !athlete.equals("");
    }

    boolean isValidSport() {
        return sport != null && !sport.equals("");
    }

    boolean isValidItem() {
        return item != null && !item.equals("");
    }
}
