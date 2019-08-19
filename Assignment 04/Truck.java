/**
  *   Name:        Rishi Wadekar                            <BR>
  *   Course:      Java for Programmers ISTE-200 2018-FALL  <BR>
  *   Homework:    #04, Vehicle                             <BR>
  *   Date:        10/01/2018                               <BR>
  * <BR>
  *   Class:       Truck                                    <BR>
  *   Purpose:     This class contains the Truck constructor. It inherits 
  *                the Vehicle class and adds some attributes of its own. <BR>
  * <BR>
  *   @see Vehicle
  */

public class Truck extends Vehicle {
   
   final String [] TRUCKLOAD = {"Half-ton","Full-ton"};
   private int truckLoadIndex = -1;
   final String [] TRUCKENGINE = {"Less than 500cc", "500cc or more"};
   private int truckEngineIndex = -1;
     
   public Truck() {
      super();
      
      // Truck Load Size (Half-ton or Full-ton)
      truckLoadIndex = showMenu("What size truck is this?", TRUCKLOAD);
      
      // Truck Engine Size
      truckEngineIndex = showMenu("What is the engine size of the truck?", TRUCKENGINE);
      
   }  // end Truck constructor
   
   //Accessor for Truck Load 
   public String getTruckLoad() {
      return TRUCKLOAD[truckLoadIndex];
   }
   
   //Accessor for Truck Engine Size
   public String getTruckEngine() {
      return TRUCKENGINE[truckEngineIndex];
   }
   
   /**
     * Method:       toString
     * Description:  the toString() method uses Accessors defined above and 
     *               the accessors from the Parent class (Vehicle) to get 
     *               the actual values of the Truck attributes. <BR>
     * @return       The returned value is a formatted string which prints the
     *               elements of the Truck order in the desired format. 
     *               
     */
   public String toString() {
      return String.format("%s:%n\t%-10s: %s%n\t%-10s: %s%n\t%-10s: $%.2f%n\t%-10s: %s%n\t%-10s: %s%n",
                      "Truck", "Model", this.getVehicleModel(), "Color", this.getVehicleColor(),"Cost",
                  this.getVehicleCost(), "Load", this.getTruckLoad(), "Engine", this.getTruckEngine());
   }  // end toString
   
}  // end Class Truck