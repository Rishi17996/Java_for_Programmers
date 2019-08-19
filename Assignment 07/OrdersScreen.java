import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.util.*;

/**
  *   Name:        Rishi Wadekar                            <BR>
  *   Course:      Java for Programmers ISTE-200 2018-FALL  <BR>
  *   Homework:    #07, GUI Shell                           <BR>
  *   Date:        10/29/2018                               <BR>
  * <BR>
  *   Class:       OrdersScreen                             <BR>
  *   Purpose:     This class contains the main method and is
  *                responsible for the GUI Shell. <BR>
  *
  */

public class OrdersScreen extends JFrame implements ItemListener, ActionListener {
   
   String [] VEHICLE_LIST = {"Select Vehicle... ", "Boat","Car",
                                         "Helicopter", "Truck"};
   private JComboBox jcbVehicles;
   private JComboBox jcbAttribute1;
   private JComboBox jcbAttribute2;
   
   private JLabel jlModel;
   private JLabel jlColor;
   private JLabel jlCost;
   private JLabel jlAttribute1;
   private JLabel jlAttribute2;
   
   private JTextField jtfModel;
   private JTextField jtfColor;
   private JTextField jtfCost;
   
   private JPanel jpHeader;
   private JPanel jpFields;
   private JPanel jpButtons;
   
   private JButton jbSave;
   private JButton jbFirst;
   private JButton jbPrev;
   private JButton jbNext;
   private JButton jbLast;
   private JButton jbExit;
   
   private JMenuBar menuBar = new JMenuBar();
   private JMenu fileMenu = new JMenu("File");
   private JMenu helpMenu = new JMenu("Help");
   private JMenuItem newMenuItem = new JMenuItem("Load");
   private JMenuItem exitMenuItem = new JMenuItem("Exit");
   private JMenuItem aboutMenuItem=  new JMenuItem("About");
   
   private JFrame aboutMessage;
   
   public static void main(String[] args) {
      
      new OrdersScreen();
   
   }
   
   public OrdersScreen() {
      
      // Set Title      
      this.setTitle("Rishi Wadekar's Ordering System");
      this.setLayout(new BorderLayout(2,2));
      this.setSize(500,400);
      this.setLocationRelativeTo(null);
            
      // Set MenuBar
      this.setJMenuBar(menuBar);
      menuBar.add(fileMenu);
      menuBar.add(helpMenu);
      fileMenu.add(newMenuItem);
      fileMenu.addSeparator();
      exitMenuItem.addActionListener(this);
      fileMenu.add(exitMenuItem);
      aboutMenuItem.addActionListener(this);
      helpMenu.add(aboutMenuItem);
      
      // Set Header
      jpHeader = new JPanel(new FlowLayout());
      String headerText = "<html><b><font color='orange' size=5>" + 
                  "Rishi Wadekar's Ordering System</font><b></html>";
      JLabel jlHeader = new JLabel(headerText,SwingConstants.CENTER);
      jpHeader.add(jlHeader);
      
      // Set Fields
      
      jpFields = new JPanel(new GridLayout(0,2));
      
      // Vehicle Type
      jpFields.add(new JLabel("Vehicle type: ", JLabel.RIGHT));
      jcbVehicles = new JComboBox(VEHICLE_LIST);
      jcbVehicles.addItemListener(this);
      jpFields.add(jcbVehicles);
      
      // Model
      jlModel = new JLabel("Model ", JLabel.RIGHT);
      jpFields.add(jlModel);
      jtfModel = new JTextField("");
      jpFields.add(jtfModel);
      
      // Color
      jlColor = new JLabel("Color ", JLabel.RIGHT);
      jpFields.add(jlColor);
      jtfColor = new JTextField("");
      jpFields.add(jtfColor);
      
      // Cost
      jlCost = new JLabel("Cost ", JLabel.RIGHT);
      jpFields.add(jlCost);
      jtfCost = new JTextField("");
      jpFields.add(jtfCost);
      
      // Attribute1
      jlAttribute1 = new JLabel("", JLabel.RIGHT);
      jpFields.add(jlAttribute1);
      jcbAttribute1 = new JComboBox();
      jpFields.add(jcbAttribute1);

      // Attribute2
      jlAttribute2 = new JLabel("", JLabel.RIGHT);
      jpFields.add(jlAttribute2);
      jcbAttribute2 = new JComboBox();
      jpFields.add(jcbAttribute2);
      
      // Set Buttons
      jpButtons = new JPanel(new GridLayout(0,6));
      
      jbSave = new JButton("SAVE");
      jbFirst = new JButton("FIRST");
      jbPrev = new JButton("PREV");
      jbNext = new JButton("NEXT");
      jbLast = new JButton("LAST");
      jbExit = new JButton("EXIT");
      jbExit.addActionListener(this);
      
      jpButtons.add(jbSave);
      jpButtons.add(jbFirst);
      jpButtons.add(jbPrev);
      jpButtons.add(jbNext);
      jpButtons.add(jbLast);
      jpButtons.add(jbExit);
      
      // Set Panel as required
      this.add(jpHeader, BorderLayout.NORTH);
      this.add(jpFields, BorderLayout.CENTER);
      this.add(jpButtons, BorderLayout.SOUTH);
      
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      pack();
      setVisible(true);
   }
   
   /**
     * Method:       itemStateChanged
     * Description:  this method is used to display the 2 new vehicle 
     *               attributes deoending on the vehicle type 
     *               selection. <BR>             
     */
   public void itemStateChanged(ItemEvent ie) {
   
      String[] attributeLabels;
      String[] choices;
      
      int state = ie.getStateChange();
      if ( state != ItemEvent.SELECTED ) {
         return;
      }
		
      String item = (String)ie.getItem();
      
      // Car
      if( item.equals("Car") ){
         
         attributeLabels = Car.getAttributeLabels();
         // Car Attribute1
         jlAttribute1.setText(attributeLabels[0]);
         choices = Car.getCarTypeArray();
         jcbAttribute1.removeAllItems();
         for(String s:choices){
            jcbAttribute1.addItem(s);
         }
         
         // Car Attribute2
         jlAttribute2.setText(attributeLabels[1]);
         choices = Car.getCarTowingArray();
         jcbAttribute2.removeAllItems();
         for(String s:choices){
            jcbAttribute2.addItem(s);
         }
      }
      
      else if (item.equals("Truck")) {
      
         attributeLabels = Truck.getAttributeLabels();
         // Truck Attribute1
         jlAttribute1.setText(attributeLabels[0]);
         choices = Truck.getTruckLoadArray();
         jcbAttribute1.removeAllItems();
         for(String s:choices){
            jcbAttribute1.addItem(s);
         }
         
         // Truck Attribute2
         jlAttribute2.setText(attributeLabels[1]);
         choices = Truck.getTruckEngineArray();
         jcbAttribute2.removeAllItems();
         for(String s:choices){
            jcbAttribute2.addItem(s);
         }
      }
      
      else if (item.equals("Helicopter")) {
      
         attributeLabels = Helicopter.getAttributeLabels();
         // Helicopter Attribute1
         jlAttribute1.setText(attributeLabels[0]);
         choices = Helicopter.getRotorTypeArray();
         jcbAttribute1.removeAllItems();
         for(String s:choices){
            jcbAttribute1.addItem(s);
         }
         
         // Helicopter Attribute2
         jlAttribute2.setText(attributeLabels[1]);
         choices = Helicopter.getHelicopterRoleArray();
         jcbAttribute2.removeAllItems();
         for(String s:choices){
            jcbAttribute2.addItem(s);
         }
      }
      
      else if (item.equals("Boat")) {
      
         attributeLabels = Boat.getAttributeLabels();
         // Boat Attribute1
         jlAttribute1.setText(attributeLabels[0]);
         choices = Boat.getBoatTypeArray();
         jcbAttribute1.removeAllItems();
         for(String s:choices){
            jcbAttribute1.addItem(s);
         }
         
         // Truck Attribute2
         jlAttribute2.setText(attributeLabels[1]);
         choices = Boat.getBoatConstructArray();
         jcbAttribute2.removeAllItems();
         for(String s:choices){
            jcbAttribute2.addItem(s);
         }
      }
   }  // end itemStateChanged
   
   /**
     * Method:       actionPerformed
     * Description:  this method is used to carry out functions on 
     *               action events.          
     */
   public void actionPerformed(ActionEvent ae) {
   
      if(ae.getSource() == jbExit) {
         System.exit(1);
      }
      if(ae.getSource() == exitMenuItem) {
         System.exit(2);
      }
      if(ae.getSource() == aboutMenuItem) {
         aboutMessage = new JFrame();
         JOptionPane.showMessageDialog(aboutMessage, "Rishi " + 
                           "Wadekar. Homework #07, GUI Shell");
      }

   }  // end actionPerformed
}