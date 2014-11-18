/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cnt4513;

/**
 *
 * @author Rob
 */
import java.io.*; 
import java.net.*; 
import java.nio.CharBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
class Client extends Thread {

    int port;
    String ipAddr;
    
    Client(int port, String ipAddr)
    {
        this.port = port;
        this.ipAddr = ipAddr;
    }
    public void run(){
        try {
           
            
            
            byte[] bytes = new byte[512];
            Socket clientSocket = new Socket(ipAddr, port);
              
            FileOutputStream fos = new FileOutputStream("C:\\Users\\Rob\\Desktop\\peer2files\\peer2.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos);


            DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream());
           
            int count;
            while ((count = inFromServer.read(bytes, 0, bytes.length)) > 0) 
            {
                bos.write(bytes, 0, count);
            }
            
            bos.close();
            
            clientSocket.close(); 
            
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    
    
}

    

