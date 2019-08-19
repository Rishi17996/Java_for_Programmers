/**
  *   Name:        Rishi Wadekar                            <BR>
  *   Course:      Java for Programmers ISTE-200 2018-FALL  <BR>
  *   Homework:    #07, GUI Shell                           <BR>
  *   Date:        10/29/2018                               <BR>
  * <BR>
  *   Class:       Helicopter                               <BR>
  *   Purpose:     This class contains the Helicopter constructor. It inherits 
  *                the Vehicle class and adds some attributes of its own. <BR>
  *   Usage:       Put this class in the same folder containing Vinfo, Order, 
  *                Vehicle and its child classes. Also add the following line  
  *                to the Vinfo class. 
  *                final static double HELICOPTERMILEAGE = 7.2;
  *                All helicopters have the same mileage. 
  * <BR>
  *   @see Vehicle
  */

class Helicopter extends Vehicle {

   private final static String [] ROTORTYPE = {"Single Tail Rotor","No Tail Rotor", "Tandem Rotor"};
   private int rotorTypeIndex = -1;
   private final static String [] HELICOPTERROLE = {"Transport", "Utility", "Assault"};
   private int helicopterRoleIndex = -1;
   private final static String VEHICLE_IS = "Helicopter";
   private final static String [] ATTRIBUTELABELS = {"Rotor ", "Role "};
     
   public Helicopter() {
      super(VEHICLE_IS);
      
      // Helicopter Rotor
      rotorTypeIndex = showMenu("What type is the rotor?", ROTORTYPE);
      
      // Helicopter Role
      helicopterRoleIndex = showMenu("What is the role of the helicopter?", HELICOPTERROLE);
      
   }  // end Helicopter constructor
   
   // Accessor for Helicopter Rotor
   public String getRotorType() {
      return ROTORTYPE[rotorTypeIndex];
   }
   
   // Accessor for Helicopter Role
   public String getHelicopterRole() {
      return HELICOPTERROLE[helicopterRoleIndex];
   }
   
   // Accessor for Helicopter attribute labels
   public static String[] getAttributeLabels() {
      return ATTRIBUTELABELS;
   }
   
   // Accessor for Helicopter rotor type array
   public static String[] getRotorTypeArray() {
      return ROTORTYPE;
   }
   
   // Accessor for Helicopter Role array
   public static String[] getHelicopterRoleArray() {
      return HELICOPTERROLE;
   }
   
   /**
     * Method:       gasMileage
     * Description:  this method is used to get the gas mileage value for 
     *               Helicopter. <BR>
     * @return       The returned value is a double indicating the miles per 
     *               gallon for the Helicopter.             
     */
   public double gasMileage() {
   
      return HELICOPTERMILEAGE;
   
   }  // end Helicopter gasMileage
   
   /**
     * Method:       toString
     * Description:  the toString() method uses Accessors defined above and 
     *               the accessors from the Parent class (Vehicle) to get 
     *               the actual values of the Helicopter attributes. <BR>
     * @return       The returned value is a formatted string which prints the
     *               elements of the Helicopter order in the desired format. 
     *               
     */
   public String toString() {
      return String.format("%s%n\t%-10s: %s%n\t%-10s: %s%n", 
             super.toString(), "Rotor", this.getRotorType(), 
                          "Role", this.getHelicopterRole());
   }  // end toString

}