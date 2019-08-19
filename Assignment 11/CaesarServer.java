import java.net.*;
import java.util.*;
import java.io.*;

/**
  *   Name:        Rishi Wadekar                            <BR>
  *   Course:      Java for Programmers ISTE-200 2018-FALL  <BR>
  *   Homework:    #11, Caesar Cipher Server                <BR>
  *   Date:        11/26/2018                               <BR>
  * <BR>
  *   Class:       CaesarServer                             <BR>
  *   Purpose:     This class contains the main method. <BR>
  *
  * @see           CaesarClient
  * @see           CaesarConstants
  */

public class CaesarServer implements CaesarConstants {
   
   private int shift;
   
   public static void main(String[] args) {
      
      int _shift = 0;
      
      try {
         if(args.length == 0) {
            new CaesarServer().execute(DEFAULT_SHIFT);
         }
         else {
            if(isInteger(args[0])) {
               _shift = Integer.parseInt(args[0]);
            }
            else {
               _shift = DEFAULT_SHIFT;
            }
            if(_shift < 1 || _shift > 25) {
               new CaesarServer().execute(DEFAULT_SHIFT);
            }
            else {
               new CaesarServer().execute(_shift);
            }
         }
      }
      catch(Exception ex) {}
   
   }  // end main
   
   /**
     * This method is called to start the program.
     *
     * @param _shift  integer indicating the shift.
     */
   public void execute(int _shift) {
      
      this.shift = _shift;
      
      try {
         ServerSocket ss = new ServerSocket(PORT_NUMBER);
         while(true) {
            Socket s = ss.accept();
            new ServerThread(s).start();            
         }
      }
      catch(Exception ex) {}
   }  // end method execute
   
   /**
     * This method checks if the String is representation
     * of integers.
     *
     * @param _string  String to be checked.
     * @return boolean value indicating if the string 
     * can be conerted to integer or not.
     */
   public static boolean isInteger(String _string) {
      try {
         Integer.parseInt(_string);
         return true;
      }
      catch(Exception ex) {
         return false;
      }
   }
   
   /**
     * A class that extends Thread and is responsible for 
     * multithreading.
     *
     * @author  Rishi Wadekar
     */
   class ServerThread extends Thread {
   
      Socket s;
      
      public ServerThread(Socket clientSocket) {
         try {
            s = clientSocket;
         }
         catch(Exception ex) {}
      }  // end constructor ServerThread
      
      public void run() {
         try {
            PrintWriter pw = new PrintWriter(new BufferedOutputStream(s.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            
            String functionOfServer = br.readLine();
            
            
            if(functionOfServer.equals("ENCRYPT")) {
               pw.println("OK");
               pw.flush();
               encrypt(shift);
            }
            else if(functionOfServer.equals("DECRYPT")) {
               pw.println("OK");
               pw.flush();
               decrypt(shift);
            }
            else {
               pw.println("SOMETHING WENT WRONG");
               pw.flush();
            }
         }
         catch(Exception ex) {}
      }  // end method run
      
      /**
        * This method is called when the encrypt option is chosen 
        * by the client.
        *
        * @param _shift  integer indicating the shift.
        */
      public void encrypt(int _shift) {
         
         while(true) {
            try {
               PrintWriter pw = new PrintWriter(new BufferedOutputStream(s.getOutputStream()));
               BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
               String receivedMsg = br.readLine();
               String encryptedMsg = "";
               for(int i = 0; i < receivedMsg.length(); i++) {
                  if(receivedMsg.charAt(i) == ' ') {
                     encryptedMsg += " ";
                  }
                  else if(Character.toLowerCase(receivedMsg.charAt(i)) >= 'a' && 
                             Character.toLowerCase(receivedMsg.charAt(i)) <= 'z') {
                     char c = (char)(receivedMsg.charAt(i) + _shift);
                     if(Character.toLowerCase(c) > 'z') {
                        encryptedMsg += (char)(receivedMsg.charAt(i) - (26 - _shift));
                     }
                     else {
                        encryptedMsg += (char)(receivedMsg.charAt(i) + _shift);
                     }
                  }
                  else {
                     encryptedMsg += (char)(receivedMsg.charAt(i));
                  }
               }   
               pw.println(encryptedMsg);
               pw.flush();
            }
            catch(Exception ex) {}
         }
      }  // end method encrypt
      
      /**
        * This method is called when the decrypt option is chosen 
        * by the client.
        *
        * @param _shift  integer indicating the shift.
        */
      public void decrypt(int _shift) {
         
         while(true) {
            try {
               PrintWriter pw = new PrintWriter(new BufferedOutputStream(s.getOutputStream()));
               BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
               String receivedMsg = br.readLine();
               String decryptedMsg = "";
               for(int i = 0; i < receivedMsg.length(); i++) {
                  char c = (char)(receivedMsg.charAt(i) - _shift);
                  if (Character.toLowerCase(c) < 'a') {
                     decryptedMsg += (char)(receivedMsg.charAt(i) + 26 - _shift);
                  }
                  else {
                     decryptedMsg += (char)(receivedMsg.charAt(i) - _shift);
                  }   
               }   
               pw.println(decryptedMsg);
               pw.flush();
            }
            catch(Exception ex) {}
         }
      }  // end method decrypt
      
   }  // end class ServerThread
   
}  // end class CaesarServer
