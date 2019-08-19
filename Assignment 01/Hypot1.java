/**
*Purpose:	This program will compute the hypotenuse of a right triange
*				using the Pythagorean Theorem: <br>
*				(a*a) + (b*b) = (c*c) <br>
*				where a, b are the shorter sides of the triangle and c is
*				longest side. <br>
*Caveats:   Non-numerical input will terminate the program <br>
*Date:      09/02/2018
*@author:   Rishi Wadekar
*/

import java.util.*;

public class Hypot1 {
	public static void main(String[] args) {
		
		Scanner scanTheInput = new Scanner(System.in);
		
		double hypotenuse;
		double d1;
		double d2;
		
		// Assuming the two string values entered are really
		// numbers, try to convert them to doubles.
		
		try {
			System.out.print("Enter the first number: ");
			d1 = Double.parseDouble(scanTheInput.next());
         
			System.out.print("Enter the second number: ");
			d2 = Double.parseDouble(scanTheInput.next());
			
         //check if numbers are negative or zero
         if (d1<=0 || d2<0) {
            System.out.print("Input should be positive numbers");
            System.exit(2);
         } else {
            //calculating the hypotenuse if the input is numerical
            hypotenuse = Math.sqrt((d1*d1) + (d2*d2));
		   	System.out.print("The hypotenuse of a right triangle with sides of ");
		   	System.out.print(d1 + " and " + d2);
		   	System.out.println(" is " + hypotenuse);
         }		
      }
		catch(NumberFormatException nfe) { 
			System.out.println("Input needs to be a number.");
         //Terminating the program in case of non-numerical input
			System.exit(3);
		}
	}
}