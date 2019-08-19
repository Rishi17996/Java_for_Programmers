/**
  *   Name:        Rishi Wadekar                            <BR>
  *   Course:      Java for Programmers ISTE-200 2018-FALL  <BR>
  *   Homework:    #06, File I/O                            <BR>
  *   Date:        10/21/2018                               <BR>
  * <BR>
  *   Class:       Boat                                      <BR>
  *   Purpose:     This class contains the Boat constructor. It inherits 
  *                the Vehicle class and adds some attributes of its own. <BR>
  * <BR>
  *   @see Vehicle
  */

class Boat extends Vehicle {

   private final String [] BOATTYPE = {"Pontoon","PWC","Sailboat"};
   private int boatTypeIndex = -1;
   private final String [] BOATCONSTRUCT = {"Wood", "Fibreglass", "Steel"};
   private int boatConstructIndex = -1;
   private final static String VEHICLE_IS = "Boat";
   
   public Boat() {
   
      super(VEHICLE_IS);
      
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
     * Method:       gasMileage
     * Description:  this method is used to get the gas mileage value for Boat
     *               <BR>
     * @return       The returned value is a double indicating the gallons per 
     *               hour for the Boat.             
     */
   public double gasMileage() {
   
      double mileage = 0;
      if(boatTypeIndex == 0) {
         
         mileage = PONTOON_GPH;
         
      }
      else if(boatTypeIndex == 1) {
         
         mileage = PWC_GPH;
         
      }
      else if(boatTypeIndex == 2) {
         
         mileage = SAILBOAT_GPH;
         
      }
      return mileage;   
   
   }  // end Boat gasMileage
   
   /**
     * Method:       toString
     * Description:  the toString() method uses Accessors defined above and 
     *               the accessors from the Parent class (Vehicle) to get 
     *               the actual values of the Boat attributes. <BR>
     * @return       The returned value is a formatted string which prints the
     *               elements of the Boat order in the desired format.              
     */
   public String toString() {
      return String.format("%s%n\t%-10s: %s%n\t%-10s: %s%n", 
         super.toString(), "Type", getBoatType(), "Made of", 
                                        getBoatConstruct());
   }  // end toString
   
   
}  // end Class Boat