/**
  *   Name:        Rishi Wadekar                            <BR>
  *   Course:      Java for Programmers ISTE-200 2018-FALL  <BR>
  *   Homework:    #05, Exceptions, Interface               <BR>
  *   Date:        10/14/2018                               <BR>
  * <BR>
  *   Class:       Vinfo                                    <BR>
  *   Purpose:     This is an interface with the gas mileage constants.
  *                It has an abstract (implicitly) method gasMileage
  *                which the method implementing it should define. <BR>
  * <BR>
  *   @see Vehicle
  */
public abstract interface Vinfo {

   double gasMileage();
   final static double SEDAN_MPG = 23.7;
   final static double COUPE_MPG = 28.3;
   final static double WAGON_MPG = 19.5;
   final static double PONTOON_GPH = 3.5;
   final static double PWC_GPH = 2.2;
   final static double SAILBOAT_GPH = 0;
   final static double HELICOPTERMILEAGE = 7.2;
   
   //Constants for Spaceship class by Kailin Berg
   final static int equipmentMPG = 115;
   final static int humanMPG = 120;
   final static int rocketBooster = 30;

   //Constants for SwiftDzire class by Hitesh Shinde
   final static double mpgFullBodyKit = 20; 
   final static double mpgGroundEffectsKit = 25; 
   final static double mpgAutomatic = 5;
}