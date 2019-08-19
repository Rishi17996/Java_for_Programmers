import java.util.*;
import java.io.*;

/**
  *   Name:        Rishi Wadekar                            <BR>
  *   Course:      Java for Programmers ISTE-200 2018-FALL  <BR>
  *   Homework:    #06, File I/O                            <BR>
  *   Date:        10/21/2018                               <BR>
  * <BR>
  *   Class:       Order                                    <BR>
  *   Purpose:     This class contains the main method. No input regarding the 
  *                vehicle is taken here. Also, the input taken here is 
  *                case-insensitive. <BR>
  * <BR>
  *   @see Vehicle
  */

class Orders {
   
   // ArrayList of Vehicle elements to store the Truck, Car, Boat 
   // and/or Helicopter objects created by the user.
   ArrayList<Vehicle> vehicleArray = new ArrayList<Vehicle>();
   String fileName_dat = "VehicleOrder.dat";
   String fileName_txt = "VehicleOrder.txt";
   Scanner scanInput = new Scanner(System.in);

   public static void main(String[] args) {
      
      System.out.println("Rishi Wadekar");
      System.out.println("Java for Programmers ISTE-200 2018-FALL");
      System.out.println("Homework # 5");
      System.out.println();
      
      Orders carOrder = new Orders();
      carOrder.loadOrder();
      carOrder.takeOrder();
      carOrder.saveOrder();
      
   }  // end main   
   
   /**
     * Method:       takeOrder
     * Description:  this method is used to take the order.<BR>
     * @return       return type is void.
     */
   public void takeOrder() {
   
      char vehicleType, newVehicle = 'y'; 
      
      // This do-while loop helps us to take multiple orders from the user.   
      do {
      
         System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n%s","What do you want to order?", 
                    "B/b for Boat", "C/c for Car", "H/h for Helicopter", "T/t for Truck", 
                                                       "M/m for Moped", "Your choice: ");
         vehicleType = scanInput.next().charAt(0);
         vehicleType = Character.toUpperCase(vehicleType);
         
         // If the user wants to order a car, a new Car oobject will be created
         // and the control of the code shifts to the Car constructor.
         if(vehicleType == 'C') {
            System.out.println("Entering Car order: ");
            Vehicle newCar = new Car();
            vehicleArray.add(newCar);
            appendFile(newCar.toString());
         }
         // If the user wants to order a truck, a new Truck oobject will be created
         // and the control of the code shifts to the Truck constructor.
         else if(vehicleType == 'T') {
            System.out.println("Entering Truck order: ");
            Vehicle newTruck = new Truck();
            vehicleArray.add(newTruck);
            appendFile(newTruck.toString());
         }
         // If the user wants to order a boat, a new Boat oobject will be created
         // and the control of the code shifts to the Boat constructor.
         else if(vehicleType == 'B') {
            System.out.println("Entering Boat order: ");
            Vehicle newBoat = new Boat();
            vehicleArray.add(newBoat);
            appendFile(newBoat.toString());
         }
         else if(vehicleType == 'H') {
            System.out.println("Entering Helicopter order: ");
            Vehicle newHelicopter = new Helicopter();
            vehicleArray.add(newHelicopter);
            appendFile(newHelicopter.toString());
         }
         else if(vehicleType == 'M') {
            System.out.println("Entering Moped order: ");
            Vehicle newMoped = new Moped();
            vehicleArray.add(newMoped);
            appendFile(newMoped.toString());
         }
         else {
            System.out.printf("%s:%n%s%n%s%n%s%n%s%n%s",
            "Enter one of the following", "T/t for Truck", "C/c for Car", 
                  "B/b for Boat", "H/h for Helicopter", "M/m for Moped");
         }
         
         System.out.println();
         System.out.printf("%s%n%s%n%s%n%s",
             "Do you want to order another vehicle?", "Y/y = Yes", 
                       "Any other input for No", "Your choice: ");
         newVehicle = scanInput.next().charAt(0);
         System.out.println(); 
         newVehicle = Character.toUpperCase(newVehicle);
         
      }while(newVehicle == 'Y'); // end of the do-while loop
      
      // Loading the previous order and appending the current order to it
      
      // Printing the objects stored in the arraylist using an 
      // enhanced for loop.
      for(Vehicle v: vehicleArray) {
         System.out.println(v);
      }
      
      System.out.println("Thank you for using Rishi Wadekar's Ordering System.");
   }  //end takeOrder
   
  /**
     * Method:       loadOrder
     * Description:  this method is used to check whether the file exists
     *               and if yes, then loads the contents of the file into
     *               the Vehicle arrayList.<BR>
     * @return       return type is void.
     */ 
   public void loadOrder() {
      try
      {
         File file = new File(fileName_dat);
         if(file.exists()){  
            ObjectInputStream di = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName_dat)));
            vehicleArray = (ArrayList<Vehicle>)di.readObject();
            di.close();
         }
      } 
      catch (Exception ex)
      {
         ex.printStackTrace();
      }
   }  // end loadOrder
   
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
}