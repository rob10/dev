/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccountstest;

/**
 *
 * @author Robert
 */
public class CheckingsAccount extends BankAccounts {
    double cBalance;
    double charge;
    
    
    public CheckingsAccount(double b, double r)
    {
        super(b, r);
        
        cBalance = b;
    }
    
    void Withdrawals(int w)
    {
        if(cBalance - w < 0)
        {
            System.out.println("Withdraw cannot be made, insufficient funds.");
            System.out.println("You will be charged $15.");
            
            charge += 15;
            
            if(cBalance < 0)
            {
                System.out.println("You account is negative and you owe the bank.");
            }
        }
    }
    
    void Deposits(int d)
    {
        cBalance -= d;
    }
    void monthlyProc()
    {
        int withdraw = getWithdraw(); 
        charge += 5;
        
        charge += withdraw * 0.10;
    }
    
}
