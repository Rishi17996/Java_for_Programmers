import java.util.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
  *   Name:        Rishi Wadekar                            <BR>
  *   Course:      Java for Programmers ISTE-200 2018-FALL  <BR>
  *   Homework:    #13, MTCS Chat                           <BR>
  *   Date:        12/12/2018                               <BR>
  * <BR>
  *   Class:       Client                                   <BR>
  *   Purpose:     This class contains the Client code. It will
  *                communicate with the server. <BR>
  *
  * @see    MTServer
  */
public class Client extends JFrame implements ActionListener {
   
   private JPanel receivePanel;
   private JPanel sendPanel;
   private JTextArea receiveMsgArea;
   private JTextArea sendMsgArea;
   private JButton sendBtn;
   private JLabel sendMessage;
   private JMenuBar clientMenu = new JMenuBar();;
   private JMenu fileMenu = new JMenu("File");
   private JMenu helpMenu = new JMenu("Help");
   private JMenuItem exitMenuItem = new JMenuItem("Exit");
   private JMenuItem aboutMenuItem=  new JMenuItem("About");
   private JLabel serverLabel;
   private JPanel serverPanel;
   private JTextField jtfServerIp;
   private JButton serverBtn;
   private String serverIp;
   private String clientName;
   private Socket clientSocket;
   private PrintWriter pw;
   private JFrame f;
      
      
   // Mutator for serverIp
   public void setServerIp(String s) {
      serverIp = s;
   }  // end setServerIp
   
   
   public static void main(String[] args) {
   
      new Client().serverIp();
   
   }  // end method main
   
   /**
     * Method:       serverIp
     * Description:  this method displays the jframe to take
     *               input from user regarding server IP. <BR>             
     */
   
   public void serverIp() {
   
      f  = new JFrame();
      serverBtn = new JButton("Connect");
      serverBtn.addActionListener(this);
      serverLabel = new JLabel("Server IP: ");
      jtfServerIp = new JTextField(15);
      serverPanel = new JPanel(new BorderLayout());
      serverPanel.add(serverLabel, BorderLayout.LINE_START);
      serverPanel.add(jtfServerIp, BorderLayout.CENTER);
      serverPanel.add(serverBtn, BorderLayout.LINE_END);
      f.add(serverPanel);
      f.setTitle("Rishi Wadekar's Chat Client");
      f.setResizable(false);
      f.setLocationRelativeTo(null);
      f.pack();
      f.setDefaultCloseOperation(EXIT_ON_CLOSE);
      f.setVisible(true);
   
   }
   
   
   /**
     * Method:       execute
     * Description:  this method implements the chat UI.<BR>             
     */
   public void execute() {
   
      // set Title
      this.setTitle("Rishi Wadekar's Chat Client");
      this.setLayout(new BorderLayout());
      this.setSize(500,400);
      this.setLocationRelativeTo(null);
      
      // set MenuBar
      this.setJMenuBar(clientMenu);
      clientMenu.add(fileMenu);
      clientMenu.add(helpMenu);
      fileMenu.addSeparator();
      exitMenuItem.addActionListener(this);
      fileMenu.add(exitMenuItem);
      aboutMenuItem.addActionListener(this);
      helpMenu.add(aboutMenuItem);
      
      // set message send area
      sendPanel = new JPanel(new BorderLayout(2,0));
      sendMessage = new JLabel("Message: ");
      sendMsgArea = new JTextArea(2,45);
      sendPanel.add(sendMessage, BorderLayout.LINE_START);
      sendPanel.add(sendMsgArea, BorderLayout.CENTER);
      sendBtn = new JButton("Send");
      sendBtn.addActionListener(this);
      sendPanel.add(sendBtn, BorderLayout.LINE_END);
      
      // set received text area
      receivePanel = new JPanel();
      receiveMsgArea = new JTextArea(20,50);
      receiveMsgArea.setEditable(false);
      JScrollPane scrollBar = new JScrollPane(receivePanel,
                     JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                   JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      receivePanel.add(receiveMsgArea);
      
      // adding to jframe
      this.add(sendPanel, BorderLayout.PAGE_START);
      this.add(receivePanel, BorderLayout.CENTER);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setResizable(false);
      pack();
      setVisible(true);
      
   }
   
   
   /**
	  * This class contains the code that receives the messages
     * broadcasted by the server.
     */
   public class ReceiveClass extends Thread {
      BufferedReader br;
      
      public ReceiveClass(BufferedReader _br) {
         br = _br;
      }
      
      public void run() {
         while(true) {
            try {
               String msg = br.readLine();
               receiveMsgArea.append("\n" + msg);
            }
            catch(Exception ex) {}
         
         }
      }
   }
   
   public void actionPerformed(ActionEvent ae) {
      
      try {
         clientSocket = new Socket(serverIp, 12345);
         BufferedReader br = new BufferedReader(
          new InputStreamReader(clientSocket.getInputStream()));
         ReceiveClass rc = new ReceiveClass(br);
         rc.start();
      }
      catch(Exception ex) {
         System.out.println("Cannot connect to the " + 
                                    "server for some reason.");
      }
      
      if(ae.getSource() == serverBtn) {
         new Client().setServerIp(jtfServerIp.getText());
         f.setVisible(false);
         try {
            new Client().execute();
         }
         catch(Exception ex) {}
      }
      else if(ae.getSource() == sendBtn) {
         try {
            Socket s = clientSocket;
            pw = new PrintWriter(new BufferedOutputStream(
                                     s.getOutputStream()));
            String msgToSend = sendMsgArea.getText();
            pw.println(msgToSend);
            pw.flush();
         }
         catch(Exception ex) {
            ex.printStackTrace();
         }
      }
      if(ae.getSource() == aboutMenuItem) {
         JFrame aboutMessage = new JFrame();
         JOptionPane.showMessageDialog(aboutMessage, "Rishi " + 
                           "Wadekar. Homework #13, MTCS Chat");
      }
      
   } 

}