/**
Purpose: This program works to construct an instance of Spaceship by
referencing the Vehicle class and setting specific values to a spaceship
within the attributes here to pass in.

Caveats: None known.

Date: October 14th, 2018
@author Kailin Berg
@version 1.0
*/

public class Spaceship extends Vehicle
{
   //Attributes
   private String boosters;
   private String purpose;
   
   final String firstPrompt = "Does the spaceship have rocket boosters?";
   final String secondPrompt = "Is this spaceship meant to carry humans or equipment?";

   final String [] boostersOptions = {"Yes", "No"};
   final String [] purposeOptions = {"Humans", "Equipment"};

   /**
      This constructor calls the constructor from the Vehicle parent class in order to set the first three values.
      To get the last two values that are specific to the class, it calls the showMenu() method from Vehicle and passes
      in specific values that are then returned.
      @return: none
   */
   public Spaceship()
   {  
      this.callVehicle();
      this.setBooster(boostersOptions[this.showMenu(firstPrompt, boostersOptions)]);
      this.setPurpose(purposeOptions[this.showMenu(secondPrompt,purposeOptions)]);  
   } //End of Car()

   //All Get/Set Methods
   public void setBooster (String p_Booster) 
   {
      boosters = p_Booster;
   }
   
   public String getBooster()
   {
      return boosters;
   }
   
   public void setPurpose (String p_purpose)
   {
      purpose = p_purpose;
   }
   
   public String getPurpose() {
      return purpose;
   }
   
   //End of Get/Set Methods

   /**
      This method parses all of the informationto a toString method in order to use it for printing in the main. It takes the first
      three attributes from the toString method in the parent Vehicle, and the 2 specific values from this class.
      @return: objectString, which has the information of the truck (Model, Color, Cost, Load, and Engine)
   */
   public String toString() 
   {
      String objectString = String.format("Spaceship" + super.toString() + "\n Boosters Present: " + getBooster() + "\n Carrying Purpose: " + getPurpose());
      return objectString;
   } //End of toString()
   
   //Constants I used in Vinfo:
  //final static int equipmentMPG = 115;
  //final static int humanMPG = 120;
  //final static int rocketBooster = 30;
   public double gasMileage() {
      double finalGas = 0.0;
   
      if(this.getPurpose() == purposeOptions[0]) {
         if(this.getBooster() == boostersOptions[0]) {
            finalGas = humanMPG + rocketBooster;
         }
         else {
            finalGas = humanMPG;
         }
      }
      else {
         if(this.getPurpose() == purposeOptions[0]) {
            if(this.getBooster() == boostersOptions[0]){
               finalGas = equipmentMPG + rocketBooster;
            }
         }  
         else {
            finalGas = equipmentMPG;
         }
      }
      return finalGas;
   }// end of gasMileage()
} //End of Spaceship()