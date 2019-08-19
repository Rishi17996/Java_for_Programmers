import java.util.*;

/**
  *   Name:        Rishi Wadekar                            <BR>
  *   Course:      Java for Programmers ISTE-200 2018-FALL  <BR>
  *   Homework:    #05, Exceptions, Interface               <BR>
  *   Date:        10/14/2018                               <BR>
  * <BR>
  *   Class:       Order                                    <BR>
  *   Purpose:     This class contains the main method. No input regarding the 
  *                vehicle is taken here. Also, the input taken here is 
  *                case-insensitive. <BR>
  * <BR>
  *   @see Vehicle
  */

class Order {

   public static void main(String[] args) {
   
      char vehicleType, newVehicle = 'y';
      
      // ArrayList of Vehicle elements to store the Truck, Car and/or 
      // Boat objects created by the user. 
      ArrayList<Vehicle> vehicleArray = new ArrayList<Vehicle>();
      
      System.out.println("Rishi Wadekar");
      System.out.println("Java for Programmers ISTE-200 2018-FALL");
      System.out.println("Homework # 5");
      System.out.println();
      
      Scanner scanInput = new Scanner(System.in);
      
      // This do-while loop helps us to take multiple orders from the user.   
      do {
      
         System.out.printf("%s%n%s%n%s%n%s%n%s%n%s","What do you want to order?", 
                    "B/b for Boat", "C/c for Car", "H/h for Helicopter", "T/t for Truck", 
                                                                        "Your choice: ");
         vehicleType = scanInput.next().charAt(0);
         vehicleType = Character.toUpperCase(vehicleType);
         
         // If the user wants to order a car, a new Car oobject will be created
         // and the control of the code shifts to the Car constructor.
         if(vehicleType == 'C') {
            System.out.println("Entering Car order: ");
            Vehicle newCar = new Car();
            vehicleArray.add(newCar);
         }
         // If the user wants to order a truck, a new Truck oobject will be created
         // and the control of the code shifts to the Truck constructor.
         else if(vehicleType == 'T') {
            System.out.println("Entering Truck order: ");
            Vehicle newTruck = new Truck();
            vehicleArray.add(newTruck);
         }
         // If the user wants to order a boat, a new Boat oobject will be created
         // and the control of the code shifts to the Boat constructor.
         else if(vehicleType == 'B') {
            System.out.println("Entering Boat order: ");
            Vehicle newBoat = new Boat();
            vehicleArray.add(newBoat);
         }
         else if(vehicleType == 'H') {
            System.out.println("Entering Helicopter order: ");
            Vehicle newHelicopter = new Helicopter();
            vehicleArray.add(newHelicopter);
         }
         // Cannot integrate the Spaceship class by Kailin Berg as she has added a 
         // function named "callVehicle()" instead of using super().
//          else if(vehicleType == 'S') {
//             System.out.println("Entering Spaceship order: ");
//             Vehicle newSpaceship = new Spaceship();
//             vehicleArray.add(newSpaceship);
//          }
         // Cannot integrate the SwiftDzire class by Hitesh Shinde as he has added a 
         // function named "commonAttributes()" instead of using super().
//          else if(vehicleType == 'D') {
//             System.out.println("Entering SwiftDzire order: ");
//             Vehicle newSwiftDzire = new SwiftDzire();
//             vehicleArray.add(newSwiftDzire);
//          }
         else {
            System.out.printf("%s:%n%s%n%s%n%s%n%s","Enter one of the following", 
                   "T/t for Truck", "C/c for Car", "B/b for Boat", "H/h for Helicopter");
         }
         
         System.out.println();
         System.out.printf("%s%n%s%n%s%n%s","Do you want to order another vehicle?", 
         "Y/y = Yes", "Any other input for No", "Your choice: ");
         newVehicle = scanInput.next().charAt(0);
         System.out.println(); 
         newVehicle = Character.toUpperCase(newVehicle);
         
      }while(newVehicle == 'Y'); // end of the do-while loop
      
      // Printing the objects stored in the arraylist using an 
      // enhanced for loop.
      for(Vehicle v: vehicleArray) {
      
         if(v instanceof Car) {
         
            System.out.println((Car)v);
            
         }
         else if(v instanceof Truck) {
         
            System.out.println((Truck)v);
            
         }
         else if(v instanceof Boat) {
         
            System.out.println((Boat)v);
            
         }
         else if(v instanceof Helicopter) {
         
            System.out.println((Helicopter)v);
            
         }
//          else if(v instanceof Spaceship) {
//          
//             System.out.println((Spaceship)v);
//             
//          }
//          else if(v instanceof SwiftDzire) {
//          
//             System.out.println((SwiftDzire)v);
//             
//          }
      }
      
      System.out.println("Thank you for using Rishi Wadekar's Ordering System.");
      
   }  // end main   
   
}  //end Order