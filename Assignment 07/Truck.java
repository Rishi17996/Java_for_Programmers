/**
  *   Name:        Rishi Wadekar                            <BR>
  *   Course:      Java for Programmers ISTE-200 2018-FALL  <BR>
  *   Homework:    #07, GUI Shell                           <BR>
  *   Date:        10/29/2018                               <BR>
  * <BR>
  *   Class:       Truck                                    <BR>
  *   Purpose:     This class contains the Truck constructor. It inherits 
  *                the Vehicle class and adds some attributes of its own. <BR>
  * <BR>
  *   @see Vehicle
  */

public class Truck extends Vehicle {
   
   private final static String [] TRUCKLOAD = {"Half-ton","Full-ton"};
   private int truckLoadIndex = -1;
   private final static String [] TRUCKENGINE = {"Less than 500cc", "500cc or more"};
   private int truckEngineIndex = -1;
   private final static String VEHICLE_IS = "Truck";
   private final static String [] ATTRIBUTELABELS = {"Load ", "Engine "};
     
   public Truck() {
      super(VEHICLE_IS);
      
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
   
   // Accessor for Truck attribute labels
   public static String[] getAttributeLabels() {
      return ATTRIBUTELABELS;
   }
   
   // Accessor for Truck Load array
   public static String[] getTruckLoadArray() {
      return TRUCKLOAD;
   }
   
   // Accessor for Truck Engine array
   public static String[] getTruckEngineArray() {
      return TRUCKENGINE;
   }
   
   /**
     * Method:       gasMileage
     * Description:  this method is used to get the gas mileage value for Truck
     *               <BR>
     * @return       The returned value is a double indicating the miles per 
     *               gallon for the Truck.             
     */
   public double gasMileage() {
   
      return (50 - (Math.sqrt(getVehicleCost())/10.0));
   
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
     return String.format("%s%n\t%-10s: %s%n\t%-10s: %s%n", super.toString(), 
               "Load", this.getTruckLoad(), "Engine", this.getTruckEngine());
   }  // end toString
   
}  // end Class Truck