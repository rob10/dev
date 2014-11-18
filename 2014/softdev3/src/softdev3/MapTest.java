/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package softdev3;
import java.util.*;
/**
 *
 * @author Rob
 */
public class MapTest {

    Map<String, Double> salaries = new HashMap<> ();
    Map<String, List<Double>> stocks = new HashMap<> ();
    
    void start () {
        stocks.put("IBM", new LinkedList<Double> ());
        stocks.get("IBM").add(52.5);
        stocks.get("IBM").add(52.9);
        stocks.get("IBM").add(53.5);
        stocks.get("IBM").add(54.0);
        stocks.get("IBM").add(48.2);
        
        stocks.put("APPL", new LinkedList<Double> ());
        stocks.get("APPL").add(152.5);
        stocks.get("APPL").add(152.9);
        stocks.get("APPL").add(153.5);
        stocks.get("APPL").add(154.0);
        stocks.get("APPL").add(148.2);
        
        for(List <Double> prices: stocks.values()) {
            for (Double price: prices) 
            {
                System.out.println(price + ",");
            
            }
            System.out.println("");
            }
        
        for(Map.Entry<String, List<Double>> entry: stocks.entrySet() )
        {
            System.out.print (entry.getKey() + ": ");
            for(Double prices: entry.getValue())
            {
                System.out.print(prices + ",");
                
            }
            System.out.println("");
        }
        
    }
        
        
    
    
    public static void main(String[] args) {
      new MapTest().start();
    }
}
