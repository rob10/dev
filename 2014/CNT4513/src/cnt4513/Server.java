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
import java.util.logging.Level;
import java.util.logging.Logger;
class Server extends Thread { 
   
    int port;
    Server(int port)
    {
        this.port = port;
    }
    public void run(){
        try {      
            
              ServerSocket welcomeSocket = new ServerSocket(port);
              
              File myFile = new File("C:\\Users\\Rob\\Desktop\\peer1files\\peer1test.txt");
              
              Socket connectionSocket = welcomeSocket.accept();
              byte[] buffer = new byte[512];
              BufferedInputStream fileBytes = new BufferedInputStream(new FileInputStream(myFile));
              connectionSocket.getInputStream();
              DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
              int count;
              while (fileBytes.read(buffer, 0, buffer.length) > 0) 
              {
                outToClient.write(buffer);
              }
             
                welcomeSocket.close(); 
           
                connectionSocket.close();
       } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
 
 
