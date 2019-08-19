/**
*Purpose:   This program will calculate the standard deviation of the 
*           numbers entered by the users.
*Caveats:   Entering characters or strings will return an error and 
*           the code will exit.
*Date:      09/16/2018
*@author    Rishi Wadekar
*/


import java.util.*;
import java.lang.Math;

class Stdev {
   public static void main(String[] args) {
      System.out.println("Calculating Standard Deviation, by Rishi Wadekar.");
      
      Scanner scanInput = new Scanner(System.in);
      
      // NValues lets the program understand the number of values
      // the user will input. 
      System.out.print("Enter the total number of values: ");
      int NValues = scanInput.nextInt();
      
      // numberArray is the array in which the numbers entered by
      // the user will be stored. Naturally, it will be of length 
      // NValues.
      int[] numberArray = new int[NValues];
      
      // Using a 'for' loop to take input from the user and store
      // it in the numberArray.
      System.out.println("Enter the numbers (Either separated with "
                                + "a space or on different lines): ");
      for(int i = 0; i < numberArray.length; i++) {
         numberArray[i] = scanInput.nextInt();
      }
      
      // Computing the mean of the numbers.
      double mean = 0.0;
      int sum = 0;
      for(int i = 0; i < numberArray.length; i++) {
         sum += numberArray[i];
      } 
      mean = (double)sum/NValues;
      
      // Variable to store the summation of squares of differences
      // between the individual numbers and the average (mean)
      double sumOfSquaredDifferences = 0.0;
      
      // Calculating sum of the squared differences
      for(int i = 0; i < numberArray.length; i++) {
         sumOfSquaredDifferences += Math.pow(numberArray[i] - mean, 2);
      }
      
      double standardDev = 0.0;
      double stDevSquare = 0.0;
      
      // Calcuating square of standard deviation
      stDevSquare = (double)sumOfSquaredDifferences / NValues;
      
      // Calculating standard deviation
      standardDev = Math.sqrt(stDevSquare);
      System.out.println("The standard deviation of the entered numbers is: " +standardDev);
   }
}