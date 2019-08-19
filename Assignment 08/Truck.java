/**
  *   Name:        Rishi Wadekar                            <BR>
  *   Course:      Java for Programmers ISTE-200 2018-FALL  <BR>
  *   Homework:    #08, GUI Shell                           <BR>
  *   Date:        11/05/2018                               <BR>
  * <BR>
  *   Class:       Truck                                    <BR>
  *   Purpose:     This class contains the Truck constructor. It inherits 
  *                the Vehicle class and adds some attributes of its own. <BR>
  * <BR>
  *   @see Vehicle
  */

public class Truck extends Vehicle {
   
   private final static String [] TRUCKLOAD = {"Half-ton","Full-ton"};
   private String truckLoad;
   private final static String [] TRUCKENGINE = {"Less than 500cc", "500cc or more"};
   private String truckEngine;
   private final static String VEHICLE_IS = "Truck";
   private final static String [] ATTRIBUTELABELS = {"Load ", "Engine "};
     
   public Truck(String _model, String _color, double _cost, String _att1, String _att2) {
      
      super(VEHICLE_IS, _model, _color, _cost);
      
      // Truck Load Size (Half-ton or Full-ton)
      setTruckLoad(_att1);
      
      // Truck Engine Size
      setTruckEngine(_att2);
      
   }  // end Truck constructor
   
   //Accessor for Truck Load 
   public String getTruckLoad() {
      return truckLoad;
   }
   
   // Mutator for truck load
   public void setTruckLoad(String _att1) {
      truckLoad = _att1;
   }
   
   //Accessor for Truck Engine Size
   public String getTruckEngine() {
      return truckEngine;
   }
   
   // Mutator for truck engine size
   public void setTruckEngine(String _att2) {
      truckEngine = _att2;
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