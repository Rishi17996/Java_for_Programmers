import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.CountDownLatch;

/**
  *   Name:        Rishi Wadekar                            <BR>
  *   Course:      Java for Programmers ISTE-200 2018-FALL  <BR>
  *   Homework:    #09, Off to the Races                    <BR>
  *   Date:        11/14/2018                               <BR>
  * <BR>
  *   Class:       Races                                    <BR>
  *   Purpose:     This class contains the main method and is
  *                responsible for the GUI. <BR>
  *
  * @see           javax.swing.JFrame
  * @see           java.awt.event
  */

public class Races extends JFrame implements ActionListener {
   
   private static int LOW_ADVANCEMENT = 1;
   private static int HIGH_ADVANCEMENT = 5;
   private static boolean stop = false;
   private static int racers = 0;
   private static String winner = "Race in progress...";
   private static int[] endDistances;
   private static String lock;
   private static double screenWidth;
   private static ImageIcon aPic;
   private static int iconHeight;
   private JMenuBar menuBar = new JMenuBar();
   private JMenu menu = new JMenu("Menu");
//   private JMenuItem restartMenuItem = new JMenuItem("Restart");
   private JMenuItem exitMenuItem = new JMenuItem("Exit");
   private static CountDownLatch latch;
   private static int startPoint = 0;
   private static JPanel panel1;
   private static JLabel jlWinner;
   
   
   public static void main(String [] args){
      
      aPic = new ImageIcon("R:\\200 Java for Programmers\\Home" + 
                                "work\\Homework 9\\races.gif");
      screenWidth = aPic.getIconWidth() * 20;
      iconHeight = aPic.getIconHeight();
      try {
         if(args.length == 0) {
            racers = 5;
         }
         else {
            racers = Integer.parseInt(args[0]);
         }
      }
      catch(Exception e) {}
		endDistances = new int[racers];
      start(racers);
                           	
   }  // end main
   
   
   /**
     * Initializes the starting point for the racers and 
     * a latch count down to check the number of threads 
     * that have finished execution.
     *
     * @param n       integer indicating the number of racers.
     */
   public static void start(int n) {
      
      startPoint = 0;
      latch = new CountDownLatch(n);
      Races r = new Races(n);
      try {
         latch.await();
         winner = compare(endDistances);
         jlWinner.setText(winner);
      }
      catch(Exception ex) {}
   }  // end method start
   
   
   /**
     * This method overrides the actionPerformed method
     * and gives functionality to the menu buttons.
     *
     * @param ae    integer indicating the number of racers.
     */
   @Override
   public void actionPerformed(ActionEvent ae) {
   
      // exit
      if(ae.getSource() == exitMenuItem) {
         System.exit(1);
      }
//       if(ae.getSource() == restartMenuItem) {
//          this.dispose();
//          start(racers);
//       }
   
   }  // end method actionPerformed
   
   
   /**
     * Creates a new Races instance when called. Also creates 
     * threads equivalent to the integer argument passed.
     *
     * @param n integer which states the total number of racers.
     */
   public Races(int n) {
   
      setLayout(new GridLayout(racers,1));
      
      // Thread array to store the threads 
      Thread[] threads = new Thread[n];
      
      // creating threads and starting them
      for(int i = 0; i < n; i++ ) {      
         MyPanel pn = new MyPanel();
         pn.setPreferredSize(new Dimension((int)screenWidth, 
                                  (int)(iconHeight * 1.5)));
         if(i == n/2) {
            jlWinner = new JLabel("");
            pn.add(jlWinner);
         }
         this.add(pn);
         threads[i] = new Thread(pn);
         threads[i].start();
         threads[i].setName("#" + Integer.toString(i+1));
      }
      
      // menubar
      this.setJMenuBar(menuBar);
      menuBar.add(menu);
//      menu.add(restartMenuItem);
//      restartMenuItem.addActionListener(this);
      menu.add(exitMenuItem);
      exitMenuItem.addActionListener(this);
      
      setTitle("Homework #9 Rishi Wadekar");
		pack();
      setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
   
   }  //  end constructor Races 
   
   
   /**
     * Returns the string specifying the largest element in the int
     * array which ranges from <code>0</code> to <code>length()</code>.
     *
     * @param _distances    int array.
     * @return a            string indicating the largest element in the array 
     *                      (NOT zero based, hence +1).
     */
   public static String compare(int[] _distances) {
    
      int temp = 0;
      for(int i = 0; i < _distances.length; i++) {
         if(_distances[temp] < _distances[i]) {
            temp = i;
         }
      }
      String a = "Winner is " + Integer.toString(temp+1);
      return a; 
    
   }  // end method compare
   
   
   /**
   * A class representing the JPanel that implements
   * Runnable.
   * For example:
   * <pre>
   *    MyPanel panel1 = new MyPanel();
   *    Thread thread1 = new Thread(panel1);
   * </pre>
   *
   * @author  Rishi Wadekar
   * @see     javax.swing.JPanel
   * @see     java.lang.Runnable
   */
   public class MyPanel extends JPanel implements Runnable {
       
       private int start = startPoint;
       public int endPoint = (int)(screenWidth*0.9);
       
       @Override
       public void run() {
          try {
             // Sleep 1 second before starting  
             Thread.sleep(1000);
          }
          catch(Exception ex) {}
          while(true) {
             
             // randomly advance the image forward
             int range = HIGH_ADVANCEMENT - LOW_ADVANCEMENT - 1;          
             start += Math.random() * range + LOW_ADVANCEMENT;
             
             try {
                // make the thread sleep for a random time
                Thread.sleep((int)(Math.random()* 50 + 1));
             }
             catch(Exception ex) {}
             repaint();
             if(start >= endPoint || stop) {
                stop = true;
                Thread t = Thread.currentThread();
                char c = (t.getName()).charAt(1);
                int index = Character.getNumericValue(c);
                endDistances[index - 1] = start;
                latch.countDown();
                break;
             }
          }          
       
       }  // end run
       
       public void paint(Graphics g) {
       
          super.paint(g);
          g.drawLine(endPoint, 0, endPoint, this.getHeight());
          g.drawImage(aPic.getImage(), start, 10, this);
       
       }  // end paint
   
   }  // end class MyPanel
   
}  // end class Races