/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccountstest;

/**
 *
 * @author Robert
 */
public class BankAccounts {
    private double balance;
    private int deposits;
    private int withdrawals;
    private double intRate;
    private int charges;
    
    public BankAccounts(double b, double r)
    {
        balance = b;
        intRate = r;
    }
    void Deposits(int d)
    {
        balance += d;
        
        deposits++;
      
    }
    int getDeposits()
    {
        return deposits;
    }
    void Withdrawals(int w)
    {
        balance -= w;
        
        withdrawals++;
        
    }
    int getWithdraw()
    {
        return withdrawals;
    }
    void calcInt()
    {
        double monthlyRate, monthRate;
        
        monthRate = intRate/12;
        
        monthlyRate = monthRate * balance;
        
        balance += monthlyRate;
    }
    void monthlyProc()
    {
        balance -= charges;
        
        deposits = 0;
        withdrawals = 0;
        charges = 0;
    }
    
    
}
