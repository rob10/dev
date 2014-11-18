/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccountstest;

/**
 *
 * @author Robert
 */
public class SavingsAccount extends BankAccounts{
    boolean status;
    double sBalance;
    double charge;
    
       

    public SavingsAccount(double d, double r, boolean s)
    {
       super( d, r);
       
       sBalance = d;
       
       status = s;
    }
    @Override
    void Withdrawals(int w)
    {
        if(sBalance < 25)
        {
            status = false;
            System.out.println("Account is Inactive.");
        }
        else
        {
            Withdrawals(w);
        }
       
    }
    @Override
    void Deposits(int d)
    {
        if(status == false)
        {
            Deposits(d);
            
            if(sBalance > 25)
            {
                status = true;
                System.out.println("Account no longer Inactive.");
            }
        }
        else
        {
            Deposits(d);
            
            
        }
    }
    void monthlProc()
    {
        int withdraw;
        
        withdraw = getWithdraw();
        
        if(withdraw > 4)
        {
            charge = withdraw - 4;
            
            sBalance -= charge;
        }
        if(sBalance < 25)
        {
            status = false;
        }
        else
        {
            status = true;
        }
    }   
    
    
    
}
