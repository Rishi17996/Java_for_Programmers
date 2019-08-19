import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;

/**
  *   Name:        Rishi Wadekar                            <BR>
  *   Course:      Java for Programmers ISTE-200 2018-FALL  <BR>
  *   Homework:    #08, GUI Shell                           <BR>
  *   Date:        11/05/2018                               <BR>
  * <BR>
  *   Class:       OrdersScreen                             <BR>
  *   Purpose:     This class contains the main method and is
  *                responsible for the GUI Shell. <BR>
  *
  */

public class OrdersScreen extends JFrame implements ItemListener, ActionListener {
   
   String [] VEHICLE_LIST = {"Select Vehicle... ", "Boat","Car", "Truck"};
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
   private JMenuItem loadMenuItem = new JMenuItem("Load");
   private JMenuItem exitMenuItem = new JMenuItem("Exit");
   private JMenuItem aboutMenuItem=  new JMenuItem("About");
   
   ArrayList<Vehicle> vehicleArray = new ArrayList<Vehicle>();
   String fileName_dat = "VehicleOrder.dat";
   String fileName_txt = "VehicleOrder.txt";
   private int orderCounter = 0;
   private String vehType;
   private String vehModel;
   private String vehColor;
   private Double vehCost;
   private String attribute_1;
   private String attribute_2;
   
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
      fileMenu.add(loadMenuItem);
      loadMenuItem.addActionListener(this);
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
      jbSave.addActionListener(this);
      jbFirst = new JButton("FIRST");
      jbFirst.addActionListener(this);
      jbPrev = new JButton("PREV");
      jbPrev.addActionListener(this);
      jbNext = new JButton("NEXT");
      jbNext.addActionListener(this);
      jbLast = new JButton("LAST");
      jbLast.addActionListener(this);
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
   
      // EXIT
      if(ae.getSource() == jbExit) {
         System.exit(1);
      }
      // FILE > EXIT
      if(ae.getSource() == exitMenuItem) {
         System.exit(2);
      }
      // HELP > ABOUT
      if(ae.getSource() == aboutMenuItem) {
         aboutMessage = new JFrame();
         JOptionPane.showMessageDialog(aboutMessage, "Rishi " + 
                           "Wadekar. Homework #08, GUI Shell");
      }
      // FILE > LOAD
      if(ae.getSource() == loadMenuItem) {
         try {
            File file = new File(fileName_dat);
            if(file.exists()){  
               ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(
                                                 new FileInputStream(fileName_dat)));
               vehicleArray = (ArrayList<Vehicle>)ois.readObject();
               ois.close();
               orderCounter = vehicleArray.size();
            }
            else {
               JFrame wrong = new JFrame();
               JOptionPane.showMessageDialog(wrong, "<html>Need to have a .dat file to" + 
                      " load it.<br> Save at least one order to create a new .dat file.");
            }
         } 
         catch (Exception ex) {
            ex.printStackTrace();
         }
      }
      // SAVE
      if(ae.getSource() == jbSave) {
         vehType = jcbVehicles.getSelectedItem().toString();
         vehModel = jtfModel.getText();
         vehColor = jtfColor.getText();
         vehCost = Double.parseDouble(jtfCost.getText());
         attribute_1 = jcbAttribute1.getSelectedItem().toString();
         attribute_2 = jcbAttribute2.getSelectedItem().toString();
         if(vehType.equals("Boat")) {
            Vehicle newBoat = new Boat(vehModel, vehColor, vehCost, attribute_1, attribute_2);
            vehicleArray.add(newBoat);
            appendFile(newBoat.toString());
            this.saveOrder();
            orderCounter += 1;
         }
         else if(vehType.equals("Car")) {
            Vehicle newCar = new Car(vehModel, vehColor, vehCost, attribute_1, attribute_2);
            vehicleArray.add(newCar);
            appendFile(newCar.toString());
            this.saveOrder();
            orderCounter += 1;
         }
         else if(vehType.equals("Truck")) {
            Vehicle newTruck = new Truck(vehModel, vehColor, vehCost, attribute_1, attribute_2);
            vehicleArray.add(newTruck);
            appendFile(newTruck.toString());
            this.saveOrder();
            orderCounter += 1;
         }
      }
      // FIRST
      if(ae.getSource() == jbFirst) {
         Vehicle v = vehicleArray.get(0);
         outputOrder(v, 0);
      }
      // LAST
      if(ae.getSource() == jbLast) {
         Vehicle v = vehicleArray.get(vehicleArray.size()-1);
         outputOrder(v, vehicleArray.size()-1);
      }
      // PREV
      if(ae.getSource() == jbPrev) {
         if(orderCounter == 0) {
            JFrame wrong = new JFrame();
            JOptionPane.showMessageDialog(wrong, "Cannot print the previous order to the first order.");
         } 
         else {
            Vehicle v = vehicleArray.get(orderCounter-1);
            outputOrder(v, orderCounter-1);
         }
         
      }
      // NEXT
      if(ae.getSource() == jbNext) {
         if(orderCounter == vehicleArray.size()-1) {
            JFrame wrong = new JFrame();
            JOptionPane.showMessageDialog(wrong, "Cannot print the order after last order.");
         }
         else {
            Vehicle v = vehicleArray.get(orderCounter+1);
            outputOrder(v, orderCounter+1);
         }         
      }

   }  // end actionPerformed
   
   /**
     * Method:       saveOrder
     * Description:  this method is used to save the order.<BR>
     * @return       return type is void.
     */
   public void saveOrder() {
      try {
         ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName_dat)));
         os.writeObject(vehicleArray);
         os.flush();
         os.close();
      } catch (Exception ex) {
         ex.printStackTrace();
      }
   }  // end saveOrder
   
   /**
     * Method:       appendFile
     * Description:  this method is used to save the formatted order
     *               output to a text file.<BR>
     * @return       return type is void.
     */
   public void appendFile(String _text) {
      
      String text;
      try {
         File file = new File(fileName_txt);
         // create a new file if not exists
         if( !file.exists() ) {
            file.createNewFile();
         }
         FileWriter out = new FileWriter(fileName_txt,true);
         BufferedWriter br = new BufferedWriter(out);
         text = _text;
         br.append(text,0,text.length());
         br.flush();
         br.close();
      }
         catch(IOException e) {
            System.out.println("Exception: " + e.getMessage());
      }
   }  // end appendFile
   
   /**
     * Method:       outputOrder
     * Description:  this method is used to display the order in the
     *               existing fields.
     *               <BR>
     * @return       return type is void.
     */
   public void outputOrder(Vehicle v, int _orderCounter) {
      if(v instanceof Boat) {
            jcbVehicles.setSelectedItem(v.getVehIs());
            jtfModel.setText(v.getVehicleModel());
            jtfColor.setText(v.getVehicleColor());
            jtfCost.setText(Double.toString(v.getVehicleCost()));
            jcbAttribute1.setSelectedItem(((Boat)v).getBoatType());
            jcbAttribute2.setSelectedItem(((Boat)v).getBoatConstruct());
            orderCounter = _orderCounter;
         }
         else if(v instanceof Car) {
            jcbVehicles.setSelectedItem(v.getVehIs());
            jtfModel.setText(v.getVehicleModel());
            jtfColor.setText(v.getVehicleColor());
            jtfCost.setText(Double.toString(v.getVehicleCost()));
            jcbAttribute1.setSelectedItem(((Car)v).getCarType());
            jcbAttribute2.setSelectedItem(((Car)v).getCarTowingPkg());
            orderCounter = _orderCounter;
         }
         else if(v instanceof Truck) {
            jcbVehicles.setSelectedItem(v.getVehIs());
            jtfModel.setText(v.getVehicleModel());
            jtfColor.setText(v.getVehicleColor());
            jtfCost.setText(Double.toString(v.getVehicleCost()));
            jcbAttribute1.setSelectedItem(((Truck)v).getTruckLoad());
            jcbAttribute2.setSelectedItem(((Truck)v).getTruckEngine());
            orderCounter = _orderCounter;
         }
   }
}