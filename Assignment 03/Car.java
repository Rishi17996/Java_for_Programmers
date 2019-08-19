/**
*Purpose:   Car.java is the Car class used in the Truck-Car problem.
*           It takes control of the execuion after a new Car object 
*           is created. 
*Caveats :  Note that it does not include the main method. Main method
*           is included in Orders.java
*Date:      09/24/2018
*@author    Rishi Wadekar
*/

import java.util.*;

class Car {

   // Attributes of the Car object. 
   private String carModel;
   private String carColor;
   private double carCost = 0;
   final String [] CARTYPE = {"Sedan","Coupe","Wagon"};
   public int carTypeIndex = -1;
   final String [] CARTOWINGPKG = {"Included", "Not Included"};
   public int carTowingIndex = -1;
   
   // Car constructor
   public Car() {
      String temporaryInput = "";
      double costInput;
      Scanner sc = new Scanner(System.in);
      System.out.println("Entering Car order: ");
      
      // Car Model
      System.out.printf("%10s: ", "Model");
      temporaryInput = sc.nextLine();
      this.setCarModel(temporaryInput);
      
      // Car Color
      System.out.printf("%10s: ", "Color");
      temporaryInput = sc.nextLine();
      this.setCarColor(temporaryInput);
      
      // Car Cost. Note that, here, checkCost() has been called to 
      // validate the cost input before storing it in the carCost variable. 
      costInput = checkCost();
      this.setCarCost(costInput);
      
      // Car Type
      System.out.println("What type of Car is this?");
      for(int i=0; i< CARTYPE.length; i++) {
         //Note here i+1 is used to show value starting from 1.
         System.out.println("\t"+(i+1)+". "+ CARTYPE[i] );
      }
      // carIndexType is the index used to pinpoint the exact Car Type.
      carTypeIndex = checkInput(CARTYPE.length);
      
      // Is the Towing package included in the car?
      System.out.println("Does this car have a towing package?");
      System.out.println("\t1. Yes" );
      System.out.println("\t2. No" );
      carTowingIndex = checkInput(CARTOWINGPKG.length);
   }
   
   // Method to check the validity of the input. This method will also be used for Truck.
   // This method is static as the Truck() constructor also uses this method to verify 
   // user input. 
   public static int checkInput(int a) {
      Scanner sc = new Scanner(System.in);
      int userInput = 0;
      while (true) {
         System.out.print("\tChoice: ");
         if (!sc.hasNextInt()) {
             System.out.printf("Invalid input. Must be a valid number betwee %d and %d%n",1,a);
             sc.nextLine(); // clear carriage return
         } 
         else {
            userInput = sc.nextInt();
            if(userInput <1 || userInput > a) {
               System.out.printf("Invalid input. Must be a valid number betwee %d and %d%n",1,a);
               continue;
            }
            else {
               return (userInput-1); //subtracted -1 to point to correct index location.
            }
         }
      }
   }
   
   // Method to check if the cost entered is valid. This method will also be used by Truck()
   // constructor.
   public static double checkCost() {
      Scanner sc = new Scanner(System.in);
      double userInput = 0;
      while (true) {
         System.out.printf("%10s: $", "Cost");
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
         
   }
   
   // Accessor for Car Model
   public String getCarModel() {
      return carModel;
   }
   
   // Mutator for Car Model
   public void setCarModel(String _model) {
      this.carModel = _model;
   }
   
   //Accessor for Car Color
   public String getCarColor() {
      return carColor;
   }
   
   // Mutator for Car Color
   public void setCarColor(String _color) {
      this.carColor = _color;
   }

   //Accessor for Car Cost
   public double getCarCost() {
      return carCost;
   }
      
   // Mutator for Car Cost
   public void setCarCost(double _cost) {
      if(_cost >= 0) {
         this.carCost = _cost;
      }
   }
   
   //Accessor for Car Type
   public String getCarType() {
      return CARTYPE[carTypeIndex];
   }
   
   //Accessor for Car Towing Package
   public String getCarTowingPkg() {
      return CARTOWINGPKG[carTowingIndex];
   }
   
   // the toString() method uses Accessors defined above to get the actual values of the 
   // Car attributes.
   public String toString() {
      return String.format("%s:%n%-10s: %s%n%-10s: %s%n%-10s: $%.2f%n%-10s: %s%n%-10s: %s%n", 
                "Car", "Model", getCarModel(), "Color", getCarColor(), "Cost", getCarCost(), 
                               "Type", getCarType(), "Towing", getCarTowingPkg());
   }
}