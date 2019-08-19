/**
*Purpose:   This program will order 3 numbers taken from the user
*           in ascending order.
*Caveats:   Do not input characters or strings. In such a case, the
*           program will return an error and exit.
*Date:      09/16/2018
*@author    Rishi Wadekar
*/

import java.util.*;

class OrderNumbers {
   public static void main(String[] args) {
      Scanner scanInput = new Scanner(System.in);
      
      System.out.println("Ordering 3 whole numbers, by Rishi Wadekar.");
      System.out.print("Enter first number: ");
      int first = scanInput.nextInt();
      System.out.print("Enter second number: ");
      int second = scanInput.nextInt();
      System.out.print("Enter third number: ");
      int third = scanInput.nextInt();
      
      //variables to store the ordered numbers
      int biggest = 0, smallest = 0, middle = 0;
      
      //ordering numbers
      if (first >= second) {
         if (first >= third) {
            biggest = first;
            if (second >= third) {
               middle = second;
               smallest = third;
            }
            else {
               middle = third;
               smallest = second;
            }
         } 
         else {
            biggest = third;
            middle = first;
            smallest = second;
         }
      }
      else {
         if (second >= third) {
            biggest = second;
            if (first >= third) {
               middle = first;
               smallest = third;
            }
            else {
               middle = third;
               smallest = first;
            }
         }
         else {
           biggest = third;
           middle = second;
           smallest = first;
         }
      }
      
      System.out.println("Ordered numbers are: " + smallest + ", " 
                                        + middle + ", " + biggest);
   }
}