/**
  *   Name:        Rishi Wadekar                            <BR>
  *   Course:      Java for Programmers ISTE-200 2018-FALL  <BR>
  *   Homework:    #08, GUI Shell                           <BR>
  *   Date:        11/05/2018                               <BR>
  * <BR>
  *   Class:       Boat                                      <BR>
  *   Purpose:     This class contains the Boat constructor. It inherits 
  *                the Vehicle class and adds some attributes of its own. <BR>
  * <BR>
  *   @see Vehicle
  */

class Boat extends Vehicle {

   private final static String [] BOATTYPE = {"Pontoon","PWC","Sailboat"};
   private String boatType;
   private final static String [] BOATCONSTRUCT = {"Wood", "Fibreglass", "Steel"};
   private String boatConstruct;
   private final static String VEHICLE_IS = "Boat";
   private final static String [] ATTRIBUTELABELS = {"Type ", "Made of "};
   
   public Boat(String _model, String _color, double _cost, String _att1, String _att2) {
   
      super(VEHICLE_IS, _model, _color, _cost);
      
      // Boat Type
      setBoatType(_att1);
      
      // Boat Construction
      setBoatConstruct(_att2);
   
   }  // end Boat
   
   // Mutator for Boat Type
   public void setBoatType(String _att1) {
      boatType = _att1;
   }
   
   // Accessor for Boat Type
   public String getBoatType() {
      return boatType;
   }
   
   // Mutator for Boat Construct
   public void setBoatConstruct(String _bc) {
      boatConstruct= _bc;
   }
   
   // Accessor for Boat Construct
   public String getBoatConstruct() {
      return boatConstruct;
   }
   
   // Accessor for Boat attribute labels
   public static String[] getAttributeLabels() {
      return ATTRIBUTELABELS;
   }
   
   // Accessor for Boat Type array
   public static String[] getBoatTypeArray() {
      return BOATTYPE;
   }
   
   // Accessor for Boat Construct array
   public static String[] getBoatConstructArray() {
      return BOATCONSTRUCT;
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
      if(boatType.equals("Pontoon")) {
         
         mileage = PONTOON_GPH;
         
      }
      else if(boatType.equals("PWC")) {
         
         mileage = PWC_GPH;
         
      }
      else if(boatType.equals("Sailboat")) {
         
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