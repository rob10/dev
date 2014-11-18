/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2.enhanced;

import org.apache.log4j.Logger;



/**
 *
 * @author Rob
 */
public class RequestData {

    protected String athlete;
    protected String sport;
    protected String item;
    protected double price;
    protected int quantity;
    protected Logger logger;
    
    
  

    public String getAthlete() {
        if (isValidAthlete()) {
            return this.athlete;
        }
        return "LeBron James";
    }

    public void setAthlete(String athlete) {
        
        this.athlete = athlete;
        //logger.info("set athlete called");
    }

    public String getSport() {
        if (isValidSport()) {
            return this.sport;
        }

        return "Basketball";
    }

    public void setSport(String sport) {
        
        this.sport = sport;
        //logger.info("set sport called");
    }

    public String getItem() {
        if (isValidItem()) {
            return this.item;
        }

        return "Jersey";
    }

    public void setItem(String item) {
        
        this.item = item;
        //logger.info("set item called");
    }
    
    public int getQuantity() {
       
           if (isValidQuantity()) {
            return this.quantity;
        }

        return 1;
    }
    

    public void setQuantity(int quantity) {
        
        this.quantity = quantity;
        //logger.info("set quantity called");
    }
    
     public double getPrice() {
      
            if (isValidPrice()) {
            return this.price;
        }

        return 5.00;
        

    }

    public void setPrice(double price) {
       
        this.price = price;
        //logger.info("set price called");
    }
    

    boolean isValidAthlete() {
        return athlete != null && !athlete.equals("");
    }

    boolean isValidSport() {
        return sport != null && (sport.toLowerCase().equals("basketball") || sport.toLowerCase().equals("baseball") ||
                sport.toLowerCase().equals("football"));
    }

    boolean isValidItem() {
        return item != null && !item.equals("");
    }
    boolean isValidQuantity() {
        
        return quantity != 0 && (quantity >= 1 && quantity <= 10);
       
    }
    boolean isValidPrice() {
        
       return price != 0 && (price >= 5.00 && price <= 150.00);
    }
    
}
