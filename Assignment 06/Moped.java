import java.util.*;

/**
  *	Name: 	   Miguel Angel Galan   <BR>
  *	Course:	   4002-218-01       	<BR>
  *	Homework:	#6, Vehicle    		<BR>
  *	Date:	      10/21/18       		<BR>
  *<BR>
  *	Class:	   Moped     			<BR>
  *	Purpose:	   This class extends from vehicle class and uses
  *               its methods to gather informtion for Mopeds.
  *               The constructor uses a parameter to determine
  *               the prompt for the vehicle and calls the vehicle
  *               constructor along with the show menu method. It
  *               also has two getters and a string formater for
  *               a display of the gathered information. 
  *			                           <BR>
  *                                    <BR>
  *	@author Miguel Angel Galan
  *	@version 2.0				
  *	@see Vehicle
  */

public class Moped extends Vehicle {
   private int chosenMopedType, chosenMopedEngineSize;
   final static String VEHICLE_IS = "Moped";
   final private String mopedTypePrompt = "What type of moped is this? ";
   final static private String engineMopedSizePrompt = "What is the engine size of the moped (CC)? ";
   final static private String [ ] typesOfMopeds = new String [ ]{"Standard", "Sport"};
   final static private String [ ] engineMopedSizes = new String [ ]{"50", "150", "250"};   
   
   
   /**
     * Constructor method calls on other methods to 
     * request user information from vehicle class.        <BR>
     * <BR> 
     * @param  option is used to determine which prompt to display 
     */
   public Moped(){
      super(VEHICLE_IS); 
      chosenMopedType = showMenu(mopedTypePrompt, typesOfMopeds); 
      chosenMopedEngineSize = showMenu(engineMopedSizePrompt, engineMopedSizes);  
   }
       
   /**
     * toString method formats the gathered information and
     * returned to the class that called it. Such as model,
     * color, cost, moped size and engine size of vehicle.
     *        <BR>
     *        <BR> 
     * @return  Formated string of the gathered information. 
     */  
   public String toString( ){
      return String.format("%s %14s%-15s\n %14s%-15s\n", 
               super.toString( ), "Moped size: ",getMopedType( ),
               "Engine: ", getMopedEngineSize( ));
   }
    
   /**
     * Accessor method to receive the engine of moped.
     *        <BR>
     *        <BR> 
     * @return  String of the engine size. 
     */   
   public String getMopedEngineSize( ){
      return engineMopedSizes[chosenMopedEngineSize];
   }
   
   /**
     * Accessor method to receive the moped size.
     *        <BR>
     *        <BR> 
     * @return  String of the moped size. 
     */     
   public String getMopedType( ){
      return typesOfMopeds[chosenMopedType];
   }
   
   
   /**
     * Accessor method to receive the gas milage using interface VInfo.
     *        <BR>
     * <BR> 
     * @return  double of the gas mileage. 
     */
   public double gasMileage( ){
      double mopedGasMileage = 0;
      
      if(chosenMopedEngineSize == 0){
            mopedGasMileage = FIFTYCC;
         }else if(chosenMopedEngineSize == 1){
            mopedGasMileage = ONEFIFTYCC;
            }else {
               mopedGasMileage = TWOFIFTYCC;
               }              
      
      return mopedGasMileage;
    }     
    
}//end of public class moped  