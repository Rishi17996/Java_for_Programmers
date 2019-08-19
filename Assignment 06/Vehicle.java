import java.util.*;
import java.io.*;

/**
  *   Name:        Rishi Wadekar                            <BR>
  *   Course:      Java for Programmers ISTE-200 2018-FALL  <BR>
  *   Homework:    #06, File I/O                            <BR>
  *   Date:        10/21/2018                               <BR>
  * <BR>
  *   Class:       Vehicle                                  <BR>
  *   Purpose:     This class contains the Vehicle constructor. It serves 
  *                as a parent class which contains the common attributes 
  *                and methods of the classes that will inherit it. It is
  *                an abstract class and it implements Vinfo interface.
  * <BR>
  *   @see Truck
  *   @see Car
  *   @see Boat
  *   @see Vinfo
  */

public abstract class Vehicle implements Vinfo, Serializable {

   private String vehicleModel;
   private String vehicleColor;
   private double vehicleCost;
   private String vehIs;
   private transient Scanner sc = new Scanner(System.in);
   
   public Vehicle(String _vehIs) {
   
      String temporaryInput = "";
      double costInput;
      
      
      // Vehicle Model
      System.out.printf("\t%-7s: ", "Model");
      temporaryInput = sc.nextLine();
      this.setVehicleModel(temporaryInput);
      
      // Vehicle Color
      System.out.printf("\t%-7s: ", "Color");
      temporaryInput = sc.nextLine();
      this.setVehicleColor(temporaryInput);
      
      // Vehicle Cost 
      costInput = checkCost();
      this.setVehicleCost(costInput);
      
      // Vehicle Is
      this.setVehIs(_vehIs);
   
   }  // end Vehicle constructor
   
   // Accessor for Vehicle Model
   public String getVehicleModel() {
      return vehicleModel;
   }
   
   // Mutator for Vehicle Model
   public void setVehicleModel(String _model) {
      this.vehicleModel = _model;
   }
   
   //Accessor for Vehicle Color
   public String getVehicleColor() {
      return vehicleColor;
   }
   
   // Mutator for Vehicle Color
   public void setVehicleColor(String _color) {
      this.vehicleColor = _color;
   }

   //Accessor for Vehicle Cost
   public double getVehicleCost() {
      return vehicleCost;
   }
      
   // Mutator for Vehicle Cost
   public void setVehicleCost(double _cost) {
      if(_cost >= 0) {
         this.vehicleCost = _cost;
      }
   }
   
   // Accessor for Vehicle Is
   public String getVehIs() {
      return vehIs;
   }
   
   //Mutator for Vehicle Is
   public void setVehIs(String _vehIs) {
      this.vehIs = _vehIs;
   }
   
   /**
     * Method:       checkCost
     * Description:  this method checks the user input for the cost of the
     *               vehicle. It checks if the cost is a double value and
     *               is greater than or equal to zero. <BR>
     * @return       The returned value is a double which indicated the 
     *               cost of the vehicle. <BR>
     */
   public static double checkCost() {
      Scanner sc = new Scanner(System.in);
      double userInput = 0;
      while (true) {
         System.out.printf("\t%-7s: $", "Cost");
         if (!sc.hasNextDouble()) {
             System.out.println("Invalid input. Must be a number >= 0");
             sc.nextLine(); // clear carriage return
         }
         else {
            userInput = sc.nextDouble();
            if(userInput < 0) {
               System.out.println("Invalid input. Must be a number >= 0");
               continue;
            }
            else {
               return userInput;
            }
         }
      }
   }  // end checkCost
   
   /**
     * Method:        showMenu
     * @param prompt  It is the description of the options presented
     *                to the user.
     * @param choices It is the final array which contains the options 
     *                from which the user should select.
     * Description:   This method is used to show the menu of choices from
     *                which the user should select the required element. The
     *                user input is checked if it is an integer which is within
     *                the range of the number of options (elements in the array).
     * @return        The returned value is an integer that corresponds to
     *                the index of the selected element from the choices 
     *                array. <BR>
     */
   public static int showMenu(String prompt, String[] choices) {
   
      Scanner sc = new Scanner(System.in);
      System.out.println(prompt);
      for(int i = 0; i < choices.length; i++) {      
         System.out.println("\t"+(i+1)+". "+ choices[i] );       
      }
      int userInput = 0;
      while (true) {
         System.out.print("\tChoice: ");   
         try {
            userInput = sc.nextInt();
         }
         catch(NumberFormatException nfe) {
            System.out.println("Please enter a valid number.");
         }
         catch(InputMismatchException ime) {
            System.out.println("Please enter a number.");
         }
         finally {
            if(userInput <1 || userInput > choices.length) {
            System.out.printf("Invalid input. Must be a valid number between %d and %d.%n", 
                                                                        1, choices.length);
            sc.nextLine();  // clear carriage return
            continue;
            }
            else {
               return (userInput-1); //subtracted -1 to point to correct index location.
            }
         }
      }
   }  // end showMenu
   
   /**
     * Method:       toString
     * Description:  the toString() method uses Accessors defined above and 
     *               to get the actual values of the Vehicle attributes. <BR>
     * @return       The returned value is a formatted string which prints the
     *               elements of the Vehicle order in the desired format. 
     *               
     */
   public String toString() {
      return String.format("%s:%n\t%-10s: %s%n\t%-10s: %s%n\t%-10s: %.2f%n\t%-10s: %.2f",
              getVehIs(),"Model",getVehicleModel(), "Color", getVehicleColor(), "Cost", 
                                            getVehicleCost(), "MPG/GPH", gasMileage());
   }  // end toString
        
} // end Class Vehicle