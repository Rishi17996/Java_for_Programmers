/**
  *   Name:        Rishi Wadekar                            <BR>
  *   Course:      Java for Programmers ISTE-200 2018-FALL  <BR>
  *   Homework:    #08, GUI Shell                           <BR>
  *   Date:        11/05/2018                               <BR>
  * <BR>
  *   Class:       Car                                      <BR>
  *   Purpose:     This class contains the Car constructor. It inherits 
  *                the Vehicle class and adds some attributes of its own. <BR>
  * <BR>
  *   @see Vehicle
  */
  
public class Car extends Vehicle {

   // Attributes of the Car object. 
   private final static String [] CARTYPE = {"Sedan","Coupe","Wagon"};
   private String carType;
   private final static String [] CARTOWINGPKG = {"Included", "Not Included"};
   private String carTowing;
   private final static String VEHICLE_IS = "Car";
   private final static String [] ATTRIBUTELABELS = {"Type ", "Towing "};
   
   // Car constructor
   public Car(String _model, String _color, double _cost, String _att1, String _att2) {
      super(VEHICLE_IS, _model, _color, _cost);
            
      // Car Type
      setCarType(_att1);
      
      // Car Towing Package
      setCarTowing(_att2);
      
   }  // end Car constructor
   
   //Accessor for Car Type
   public String getCarType() {
      return carType;
   }
   
   //Mutator for Car Type
   public void setCarType(String _att1) {
      carType = _att1;
   }
   
   //Accessor for Car Towing Package
   public String getCarTowingPkg() {
      return carTowing;
   }
   
   // Mutator for Car Towing Package
   public void setCarTowing(String _att2) {
      carTowing = _att2;
   }
   
   // Accessor for Car attribute labels
   public static String[] getAttributeLabels() {
      return ATTRIBUTELABELS;
   }
   
   // Accessor for Car Type Array
   public static String[] getCarTypeArray() {
      return CARTYPE;
   }
   
   // Accessor for Car Towing Package array
   public static String[] getCarTowingArray() {
      return CARTOWINGPKG;
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
      if(carTowing.equals("Included")) {
      
         if(carType.equals("Sedan")) {
         
            mileage = SEDAN_MPG - 3;
         
         }
         else if(carType.equals("Coupe")) {
         
            mileage = COUPE_MPG - 3;
         
         }
         else if(carType.equals("Wagon")) {
         
            mileage = WAGON_MPG - 3;
         
         }
      
      }
      else if(carTowing.equals("Not Included")) {
      
         if(carType.equals("Sedan")) {
         
            mileage = SEDAN_MPG;
         
         }
         else if(carType.equals("Coupe")) {
         
            mileage = COUPE_MPG;
         
         }
         else if(carType.equals("Wagon")) {
         
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
      return String.format("%s%n\t%-10s: %s%n\t%-10s: %s%n", 
           super.toString(), "Type", getCarType(), "Towing", 
                                         getCarTowingPkg());
   }  // end toString
   
}  // end Class Car