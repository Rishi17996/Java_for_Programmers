/**
*Purpose:   Truck.java contains the Truck() constructor. It takes control of the 
*           execution after a new Truck object is created.
*Caveats:   This does not contain the main method. Main method is contained in
*           Orders.java
*Date:      09/24/2018
*@author    Rishi Wadekar
*/

import java.util.*;

class Truck {
   private String truckModel;
   private String truckColor;
   private double truckCost = 0;
   final String [] TRUCKLOAD = {"Half-ton","Full-ton"};
   public int truckLoadIndex = -1;
   final String [] TRUCKENGINE = {"Less than 500cc", "500cc or more"};
   public int truckEngineIndex = -1;
     
   public Truck() {
      String temporaryInput = "";
      double costInput;
      Scanner sc = new Scanner(System.in);
      
      // Truck Model
      System.out.println("Entering Truck order: ");
      System.out.printf("%10s: ", "Model");
      temporaryInput = sc.nextLine();
      this.setTruckModel(temporaryInput);
      
      // Truck Color
      System.out.printf("%10s: ", "Color");
      temporaryInput = sc.nextLine();
      this.setTruckColor(temporaryInput);
      
      // Setting the Truck Cost value. Note that the checkCost() method has been 
      // called from the Car class. 
      costInput = Car.checkCost();
      this.setTruckCost(costInput);
      
      // Truck Load Size (Half-ton or Full-ton)
      System.out.println("What size truck is this?");
      for(int i = 0; i < TRUCKLOAD.length; i++) {
         System.out.println("\t" + (i+1) + ". " + TRUCKLOAD[i]);
      }
      truckLoadIndex = Car.checkInput(TRUCKLOAD.length);
      
      // Truck Engine Size (Really big or Not so Big)
      System.out.println("What is the engine size of the truck?");
      for(int i = 0; i < TRUCKENGINE.length; i++) {
         System.out.println("\t" + (i+1) + ". " + TRUCKENGINE[i]);
      }
      truckEngineIndex = Car.checkInput(TRUCKENGINE.length);
   }
   
   //Accessor for Truck Model
   public String getTruckModel() {
      return truckModel;
   }
   
   //Mutator for Truck Model
   private void setTruckModel(String _model) {
      this.truckModel = _model;
   }
   
   //Accessor for Truck Color
   public String getTruckColor() {
      return truckColor;
   }
   
   //Mutator for Truck Color
   public void setTruckColor(String _color) {
      this.truckColor = _color;
   }
   
   //Accessor for Truck Cost
   public double getTruckCost() {
      return truckCost;
   }
   
   //Mutator for Truck Cost
   public void setTruckCost(double _cost) {
      if(_cost >= 0) {
         this.truckCost = _cost;
      }
   }
   
   //Accessor for Truck Load 
   public String getTruckLoad() {
      return TRUCKLOAD[truckLoadIndex];
   }
   
   //Accessor for Truck Engine Size
   public String getTruckEngine() {
      return TRUCKENGINE[truckEngineIndex];
   }
   
   // the toString() method uses Accessors defined above to get the actual values of the 
   // Truck attributes.
   public String toString() {
      return String.format("%s:%n%-10s: %s%n%-10s: %s%n%-10s: $%.2f%n%-10s: %s%n%-10s: %s%n",
                      "Truck", "Model", this.getTruckModel(), "Color", this.getTruckColor(),
                         "Cost", this.getTruckCost(), "Load", this.getTruckLoad(), "Engine",
                                                                     this.getTruckEngine());
   }
}