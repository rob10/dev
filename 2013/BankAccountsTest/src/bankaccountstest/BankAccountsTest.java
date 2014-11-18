/**************************************************************************************************************************
 * 
 * Robert Gomez
 * COP 2800
 * 
 * Bank Accounts
 * 
 * Incomplete Assignment 
 * 
 * ************************************************************************************************************************
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccountstest;

/**
 *
 * @author Robert
 */
import java.util.Scanner;
public class BankAccountsTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final double balance = 500, rate = 12;
        int withdrawals, deposits, x=1;
        
        
        Scanner userInput = new Scanner(System.in);
        
        BankAccounts baccounts = new BankAccounts(balance, rate);
        
        BankAccounts savings = new SavingsAccount(balance, rate, true);
        
        BankAccounts checkings = new CheckingsAccount(balance, rate);
        
        
        
        while(x != 1)
        {
            System.out.println("Enter amount you want to withdraw from your checkings account: ");
            
            withdrawals = userInput.nextInt();
            
            checkings.Withdrawals(withdrawals);
            
            System.out.println("Enter amount you want to deposit from your checkings account: ");
            
            deposits = userInput.nextInt();
            
            checkings.Deposits(deposits);
            
            System.out.println("Enter amount you want to withdraw from your savings account: ");
            
            withdrawals += userInput.nextInt();
            
            savings.Withdrawals(withdrawals);
            
            System.out.println("Enter amount you want to deposit from your savings account: ");
            
            deposits += userInput.nextInt();
            
            savings.Deposits(deposits);
            
        }
        
               
        
    }
}
