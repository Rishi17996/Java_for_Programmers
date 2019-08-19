/**
  *   Name:        Rishi Wadekar                            <BR>
  *   Course:      Java for Programmers ISTE-200 2018-FALL  <BR>
  *   Homework:    #05, Exceptions, Interface               <BR>
  *   Date:        10/14/2018                               <BR>
  * <BR>
  *   Class:       Helicopter                               <BR>
  *   Purpose:     This class contains the Helicopter constructor. It inherits 
  *                the Vehicle class and adds some attributes of its own. <BR>
  *   Usage:       Put this class in the same folder containing Vinfo, Order, 
  *                Vehicle and its child classes. Also add the following line  
  *                to the Vinfo class. 
  *                final static double HELICOPTERMILEAGE = 7.2;
  * <BR>
  *   @see Vehicle
  */

class Helicopter extends Vehicle {

   private final String [] ROTORTYPE = {"Single Tail Rotor","No Tail Rotor", "Tandem Rotor"};
   private int rotorTypeIndex = -1;
   private final String [] HELICOPTERROLE = {"Transport", "Utility", "Assault"};
   private int helicopterRoleIndex = -1;
     
   public Helicopter() {
      super();
      
      // Helicopter Rotor
      rotorTypeIndex = showMenu("What type is the rotor?", ROTORTYPE);
      
      // Helicopter Role
      helicopterRoleIndex = showMenu("What is the role of the helicopter?", HELICOPTERROLE);
      
   }  // end Helicopter constructor
   
   //Accessor for Helicopter Rotor
   public String getRotorType() {
      return ROTORTYPE[rotorTypeIndex];
   }
   
   //Accessor for Helicopter Role
   public String getHelicopterRole() {
      return HELICOPTERROLE[helicopterRoleIndex];
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
      return String.format("%s:%n%s\t%-10s: %.2f %s%n\t%-10s: %s%n\t%-10s: %s%n", 
                      "Helicopter", super.toString(), "MPG/GPH", this.gasMileage(), 
                          "miles per gallon", "Rotor", this.getRotorType(), "Role", 
                                                         this.getHelicopterRole());
   }  // end toString

}