/**
  *   Name:        Rishi Wadekar                            <BR>
  *   Course:      Java for Programmers ISTE-200 2018-FALL  <BR>
  *   Homework:    #05, Exceptions, Interface               <BR>
  *   Date:        10/14/2018                               <BR>
  * <BR>
  *   Class:       Car                                      <BR>
  *   Purpose:     This class contains the Car constructor. It inherits 
  *                the Vehicle class and adds some attributes of its own. <BR>
  * <BR>
  *   @see Vehicle
  */
  
public class Car extends Vehicle {

   // Attributes of the Car object. 
   private final String [] CARTYPE = {"Sedan","Coupe","Wagon"};
   private int carTypeIndex = -1;
   private final String [] CARTOWINGPKG = {"Included", "Not Included"};
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
     * Method:       gasMileage
     * Description:  this method is used to get the gas mileage value for Car
     *               <BR>
     * @return       The returned value is a double indicating the miles per 
     *               gallon for the Car.             
     */
   public double gasMileage() {
      
      double mileage = 0;   
      if(carTowingIndex == 0) {
      
         if(carTypeIndex == 0) {
         
            mileage = SEDAN_MPG - 3;
         
         }
         else if(carTypeIndex == 1) {
         
            mileage = COUPE_MPG - 3;
         
         }
         else if(carTypeIndex == 2) {
         
            mileage = WAGON_MPG - 3;
         
         }
      
      }
      else {
      
         if(carTypeIndex == 0) {
         
            mileage = SEDAN_MPG;
         
         }
         else if(carTypeIndex == 1) {
         
            mileage = COUPE_MPG;
         
         }
         else if(carTypeIndex == 2) {
         
            mileage = WAGON_MPG;
         
         }
      
      }
      return mileage;
      
   }  // end Car gasMileage
   
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
      return String.format("%s:%n%s\t%-10s: %.2f %s%n\t%-10s: %s%n\t%-10s: %s%n", 
         "Car", super.toString(), "MPG/GPH", this.gasMileage(), "miles per gallon", 
                                "Type", getCarType(), "Towing", getCarTowingPkg());
   }  // end toString
   
}  // end Class Car