/**
*Purpose:	This program will compute the hypotenuse of a right triange
*				using the Pythagorean Theorem: <br>
*				(a*a) + (b*b) = (c*c) <br>
*				where a, b are the shorter sides of the triangle and c is
*				longest side. <br>
*Caveats:   All arguments entered after the 2nd argument will be ignored. <br>
*Date:      09/01/2018
*Example:	java Hypot 7 12 <br>
*@author    Rishi Wadekar
*/

public class Hypot {
	public static void main(String[] args) {
		double hypotenuse;
		double d1;
		double d2;
		
		// Verify that the two arguments were entered on the command line.
		if(args.length != 2) {
			System.out.println("You need to enter two arguments.");
			System.exit(1);
		}
		
		// Assuming the two string values entered are really 
		// numbers, try to convert them to doubles.
		try {
			d1 = Double.parseDouble(args[0]);
			d2 = Double.parseDouble(args[1]);
         
         //check if numbers are negative or zero
         if(d1<=0 || d2<=0) {
            System.out.print("Arguments should be positive numbers");
            System.exit(2);
         } else {
            //calculate the hypotenuse length if values entered are numbers
			   hypotenuse = Math.sqrt((d1*d1) + (d2*d2));
		   	System.out.print("The hypotenuse of a right triangle with sides of ");
			   System.out.print(d1 + " and " + d2);
			   System.out.println(" is " + hypotenuse);
         }
		}
		catch(NumberFormatException nfe) {             //if the values entered are not numbers
			System.out.println("Arguments need to be numbers.");
			System.exit(3);
		}
	}
}