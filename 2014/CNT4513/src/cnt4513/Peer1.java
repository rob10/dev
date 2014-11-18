/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cnt4513;

/**
 *
 * @author Rob
 * 
 */

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Peer1 extends Thread{
    
    
    public void run()
    {
        int portNumber = 5555;
        
        
        String ipAddr = "localhost";
        String answer = "";
        Server myServer = new Server(portNumber);
        Client myClient = new Client(portNumber,ipAddr);
        Scanner input = new Scanner(System.in);
        boolean x = true;
 
        while(x=true){ 
        System.out.println("Send or receive file: ");
        answer = input.nextLine();
        
        if (answer.equals("send"))
            myServer.start();
        else if (answer.equals("receive"))
            myClient.start();
        else if (answer.equals("quit"))
            x = false;
        else
        {
            System.out.println("Enter send,receive, or quit");
        }
        }
    }
}
