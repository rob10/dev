/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assign1;

//Import Joptionpane
import javax.swing.JOptionPane;

/**
 *
 * @author Robert
 */

public class Assign1 {
    
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        //create objects in main class
        Database db = new Database();
        Database db2 = new Database(); 
        //create boolean to exit loop when done
        boolean done = false;
        //create menu
        String menu = "1.Create Product \n"
                + "2.Find Product \n"
                + "3.Update \n"
                + "4.Remove \n"
                + "5.Generate Report \n"
                + "6.Exit \n";
        

        //enter loop
        while(!done)
        {
            //get user input
            int i = IO.getInt(menu);
            //use switch statement for userinput
            switch(i)
            {
                
                case 1: //create product
                    //get all information from user
                    String name = IO.getWord("Enter name of product: ");
                    String mName = IO.getWord("Enter name of Manufacturer: ");
                    String st = IO.getWord("Enter Street: ");
                    String city = IO.getWord("Enter City: ");
                    String sta = IO.getWord("Enter State: ");
                    String zip = IO.getWord("Enter Zip Code: ");
                    //pass variables to the classes
                    Address addr = new Address(st, city, sta, zip);
                    Manufacturer manufact = new Manufacturer(mName, addr);
                    //get more info
                    int quantity = IO.getInt("Enter Quantity: ");
                    double price = IO.getDouble("Enter Price: ");
                    //pass more variables to product class
                    Product p = new Product(name,quantity,price,manufact);
                    //add product to list
                    db.add(p);
                    break;
                    
                case 2: //find product
                    //ask user for product name
                    String key = IO.getWord("Enter Product name: ");
                    //search database
                    db.search(key);
                    
                    if(db.getFound() == true)
                    {
                        //if product is found call this method
                        db.isInList();
                        
                    }
                    //else display not found message
                    else
                    {
                    IO.display("Product not found", "Error", 1);
                    }
                    
                    break;
                    
                case 3://update
                    //ask user for produc name
                    String keyu = IO.getWord("Enter Product name: ");
                    //search database
                    db.search(keyu);
                    
                    if(db.getFound() == true)
                    {
                        //if found call method
                        db.isInList();
                        //get the product from the database
                        Product prod = db.getProd();
                        //ask user what they want to update
                        String menuU = "1. Update Quantity \n"
                            + "2.Update Price \n"
                            + "3.Manufacturer";
                    
                        //get user input
                        int uChoice = IO.getInt(menuU);
                        
                        
                        switch(uChoice)
                        {
                            case 1://update quantity
                                int quantityNew = IO.getInt("Enter New Quantity: ");
                                //call this method and update
                                prod.update(quantityNew);
                                break;
                            case 2://update price
                                double newPrice = IO.getDouble("Enter New Price: ");
                                //call this method and update
                                prod.update(newPrice);
                                break;
                            case 3://update manufacturer
                                //get new manufacturer info
                               String newMan = IO.getWord("Enter name of Manufacturer: ");
                               String newSt = IO.getWord("Enter Street: ");
                               String newCity = IO.getWord("Enter City: ");
                               String newSta = IO.getWord("Enter State: ");
                               String newZip = IO.getWord("Enter Zip Code: ");
                               //create new objects
                               Address addr2 = new Address(newSt, newCity, newSta, newZip);
                               Manufacturer manufact2 = new Manufacturer(newMan, addr2);
                               //call this method and update
                               prod.update(manufact2);
                                break;
                                //show error message if they don't put 1-3
                            default:
                                JOptionPane.showMessageDialog(null, "Wrong Input", "Error", JOptionPane.ERROR_MESSAGE);
                                
                        }
                        //display updated product
                        prod.displayUpdated();
                        
                    }
                    //if product not found display this
                    else
                    {
                    IO.display("Product not found", "Error", 1);
                    }
                    break;
                case 4: //remove
                    //ask user for product name
                    String keyr = IO.getWord("Enter product name: ");
                    //search database
                    db.search(keyr);
                    
                    if(db.getFound())
                    {
                        //get index if found
                        int x = db.getIndex();
                        //use index to remove and place in pr
                        Product pr = db.list.remove(x);
                        //add pr to inactive list
                        db2.add(pr);
                        
                    }
                    //if product not found display this
                    else
                    {
                        System.out.println("Product not found.");
                    }
                    break;
                case 5: //generate report
                    //Ask which user which list they want to view
                    int choice = IO.getInt("1.Active List \n"
                            + "2. Inactive List");
                    
                    switch(choice)
                    {
                        case 1://Active list
                            //append list to a string
                            String s = db.list.toString();
                            //display
                            IO.display("Product Report", s, 20, 60);
                            break;
                        case 2://InActive List
                            //append list to a string
                            String r = db2.list.toString();
                            //display
                            IO.display("Deleted Report", r, 20, 60);
                            break;
                            //show error message if 1 or 2 is not chosen
                        default:
                            JOptionPane.showMessageDialog(null, "Wrong Input", "Error", JOptionPane.ERROR_MESSAGE);
                            
                    }
                    
                    break;
                case 6://exit program
                    done = true;
                    break;
                    //show error message if 1 to 6 is not chosen
                default:
                    JOptionPane.showMessageDialog(null, "Wrong Input", "Error", JOptionPane.ERROR_MESSAGE);
            }
            }
            System.exit(0);
        }
    
}
