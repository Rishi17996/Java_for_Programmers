/**
*Purpose:   Order.java contains the main method to run the Truck-Car
*           Ordering problem. 
*Date:      09/24/2018
*@author    Rishi Wadekar
*/

import java.util.*;

class Order {

   public static void main(String[] args) {
   
      char vehicleType, newVehicle = 'y';
      
      // ArrayList to store the Truck and/or Car objects created by the user. 
      ArrayList vehicleArray = new ArrayList();
      
      System.out.println("Rishi Wadekar's Ordering System (218-HW3)");
      System.out.println();
      
      Scanner scanInput = new Scanner(System.in);
      
      // This do-while loop helps us to take multiple orders from the user.   
      do {
         System.out.print("Do you want to order a Truck (T/t) or a car (C/c)? ");
         vehicleType = scanInput.next().charAt(0);
         vehicleType = Character.toUpperCase(vehicleType);
         
         // If the user wants to order a car, a new Car oobject will be created
         // and the control of the code shifts to the Car() constructor.
         if(vehicleType == 'C') {
            Car newCar = new Car();
            vehicleArray.add(newCar);
         }
         // If the user wants to order a truck, a new Truck oobject will be created
         // and the control of the code shifts to the Truck() constructor.
         else if(vehicleType == 'T') {
            Truck newTruck = new Truck();
            vehicleArray.add(newTruck);
         }
         else {
            System.out.println("Enter either T/t or C/c.");
         }
         System.out.println();
         System.out.println("Do you want to order another vehicle? Y/y = Yes, N/n = No");
         newVehicle = scanInput.next().charAt(0);
         System.out.println(); 
         newVehicle = Character.toUpperCase(newVehicle);
      }while(newVehicle == 'Y'); // end of the do-while loop
      
      // Printing the objects stored in the arraylist.
      for(Object obj: vehicleArray) {
         if(obj instanceof Car) {
            Car c = (Car)obj;
            System.out.println(c);
         }
         else if(obj instanceof Truck) {
            Truck t = (Truck)obj;
            System.out.println(t);
         } 
      }
      
      System.out.println("Thank you for using Rishi Wadekar's Ordering System.");
   } // end main   
} //end Orders