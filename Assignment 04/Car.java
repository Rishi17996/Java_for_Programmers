/**
  *   Name:        Rishi Wadekar                            <BR>
  *   Course:      Java for Programmers ISTE-200 2018-FALL  <BR>
  *   Homework:    #04, Vehicle                             <BR>
  *   Date:        10/01/2018                               <BR>
  * <BR>
  *   Class:       Car                                      <BR>
  *   Purpose:     This class contains the Car constructor. It inherits 
  *                the Vehicle class and adds some attributes of its own. <BR>
  * <BR>
  *   @see Vehicle
  */
  
public class Car extends Vehicle {

   // Attributes of the Car object. 
   final String [] CARTYPE = {"Sedan","Coupe","Wagon"};
   private int carTypeIndex = -1;
   final String [] CARTOWINGPKG = {"Included", "Not Included"};
   private int carTowingIndex = -1;
   
   // Car constructor
   public Car() {
      super();
            
      // Car Type
      carTypeIndex = showMenu("What type of Car is this?", CARTYPE);
      
      // Car Towing Package
      carTowingIndex = showMenu("Does this car have a towing package?", CARTOWINGPKG);
      
   }  // end Car constructor
   
   //Accessor for Car Type
   public String getCarType() {
      return CARTYPE[carTypeIndex];
   }
   
   //Accessor for Car Towing Package
   public String getCarTowingPkg() {
      return CARTOWINGPKG[carTowingIndex];
   }
   
   /**
     * Method:       toString
     * Description:  the toString() method uses Accessors defined above and 
     *               the accessors from the Parent class (Vehicle) to get 
     *               the actual values of the Car attributes. <BR>
     * @return       The returned value is a formatted string which prints the
     *               elements of the Car order in the desired format. 
     *               
     */
   public String toString() {
      return String.format("%s:%n\t%-10s: %s%n\t%-10s: %s%n\t%-10s: $%.2f%n\t%-10s: %s%n\t%-10s: %s%n", 
               "Car", "Model", getVehicleModel(), "Color", getVehicleColor(), "Cost", getVehicleCost(), 
                                                    "Type", getCarType(), "Towing", getCarTowingPkg());
   }  // end toString
   
}  // end Class Car