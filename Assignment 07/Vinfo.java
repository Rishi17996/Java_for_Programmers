/**
  *   Name:        Rishi Wadekar                            <BR>
  *   Course:      Java for Programmers ISTE-200 2018-FALL  <BR>
  *   Homework:    #07, GUI Shell                           <BR>
  *   Date:        10/29/2018                               <BR>
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
   
}