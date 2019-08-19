import java.util.*;

/**
  *   Name:        Rishi Wadekar                            <BR>
  *   Course:      Java for Programmers ISTE-200 2018-FALL  <BR>
  *   Homework:    #04, Vehicle                             <BR>
  *   Date:        10/01/2018                               <BR>
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
      System.out.println("Homework # 4");
      System.out.println();
      
      Scanner scanInput = new Scanner(System.in);
      
      // This do-while loop helps us to take multiple orders from the user.   
      do {
      
         System.out.print("Do you want to order a Truck (T/t), Car (C/c) or a Boat (B/b)? ");
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
         else {
            System.out.println("Enter either T/t or C/c or B/b.");
         }
         
         System.out.println();
         System.out.println("Do you want to order another vehicle? Y/y = Yes, N/n = No");
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
      }
      
      System.out.println("Thank you for using Rishi Wadekar's Ordering System.");
      
   }  // end main   
   
}  //end Order