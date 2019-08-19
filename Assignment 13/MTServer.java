import java.net.*;
import java.util.*;
import java.io.*;

/**
  *   Name:        Rishi Wadekar                            <BR>
  *   Course:      Java for Programmers ISTE-200 2018-FALL  <BR>
  *   Homework:    #13, MTCS Chat                           <BR>
  *   Date:        12/12/2018                               <BR>
  * <BR>
  *   Class:       MTServer                                 <BR>
  *   Purpose:     This class contains the Server code. It will
  *                communicate with the clients. Multiple clients
  *                can be connected. <BR>
  *
  * @see    Client
  */

public class MTServer {
   
   Vector<PrintWriter> clientList = new Vector<PrintWriter>();
   
   public static void main(String[] args) {
      new MTServer().execute();
   }
  
   /**
     * Method:       execute
     * Description:  starts the server. <BR>             
     */
   public void execute() {
      try {
         ServerSocket ss = new ServerSocket(12345);
         
         while(true) {
            Socket s = ss.accept();
            new ServerThread(s).start();            
         }
      }
      catch(Exception ex) {}
   
   }
   
   
   /**
	  * This class contains the code that lets clients 
     * communicate among themselves.
     */
   class ServerThread extends Thread {
      
      Socket s;
      
      public ServerThread(Socket clientSocket) {
         try {
            s = clientSocket;
         }
         catch(Exception ex) {}
      }
      
      public void run() {
         try {
            BufferedReader br = new BufferedReader(
              new InputStreamReader(s.getInputStream()));
            PrintWriter pw = new PrintWriter(
              new BufferedOutputStream(s.getOutputStream()));
            
            pw.println("Welcome to Rishi Wadekar's Chat");
            pw.flush();
            clientList.add(pw);
            
            while(true) {
               String msg = br.readLine();
               if(msg.equals("quit")) {
                  br.close();
                  pw.close();
                  break;
               }
               broadcastMessage(msg);
            }
         }
         catch(Exception ex) {}
      }
      
      
      /**
        * Method:       broadcastMessage
        * Description:  sends the message received from
        *               one client to all other clients. <BR>             
        */
      private void broadcastMessage(String msg) {
         for(PrintWriter p : clientList) {
            try {
               p.println(msg);
               p.flush();
            }
            catch(Exception ex) {}
         }
      }
      
   }
}