/**
  *   Name:        Rishi Wadekar                            <BR>
  *   Course:      Java for Programmers ISTE-200 2018-FALL  <BR>
  *   Homework:    #04, Vehicle                             <BR>
  *   Date:        10/01/2018                               <BR>
  * <BR>
  *   Class:       Boat                                      <BR>
  *   Purpose:     This class contains the Boat constructor. It inherits 
  *                the Vehicle class and adds some attributes of its own. <BR>
  * <BR>
  *   @see Vehicle
  */

class Boat extends Vehicle {

   final String [] BOATTYPE = {"Pontoon","PWC","Sailboat"};
   private int boatTypeIndex = -1;
   final String [] BOATCONSTRUCT = {"Wood", "Fibreglass", "Steel"};
   private int boatConstructIndex = -1;
   
   public Boat() {
   
      super();
      
      // Boat Type
      boatTypeIndex = showMenu("What type of Boat is this?", BOATTYPE);
      
      // Boat Construction
      boatConstructIndex = showMenu("What is the boat's construction?", BOATCONSTRUCT);
   
   }  // end Boat
   
   // Accessor for Boat Type
   public String getBoatType() {
      return BOATTYPE[boatTypeIndex];
   }
   
   // Accessor for Car Towing Package
   public String getBoatConstruct() {
      return BOATCONSTRUCT[boatConstructIndex];
   }
   
   /**
     * Method:       toString
     * Description:  the toString() method uses Accessors defined above and 
     *               the accessors from the Parent class (Vehicle) to get 
     *               the actual values of the Boat attributes. <BR>
     * @return       The returned value is a formatted string which prints the
     *               elements of the Boat order in the desired format. 
     *               
     */
   public String toString() {
      return String.format("%s:%n\t%-10s: %s%n\t%-10s: %s%n\t%-10s: $%.2f%n\t%-10s: %s%n\t%-10s: %s%n", 
              "Boat", "Model", getVehicleModel(), "Color", getVehicleColor(), "Cost", getVehicleCost(), 
                                                "Type", getBoatType(), "Made of", getBoatConstruct());
   }  // end toString
   
}  // end Class Boat