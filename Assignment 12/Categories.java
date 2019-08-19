/**
  *   Name:        Rishi Wadekar                            <BR>
  *   Course:      Java for Programmers ISTE-200 2018-FALL  <BR>
  *   Homework:    #12, XML, Network, GUI                   <BR>
  *   Date:        12/08/2018                               <BR>
  * <BR>
  *   Class:       Categories                               <BR>
  *   Purpose:     This class contains the Categories constructor. 
  *                It is an attribute of the Results class.
  * <BR>
  *   @see Results
  */

public class Categories {

   private String categoryValue;
   
   public Categories(String _categoryValue) {
      
      setCategoryValue(_categoryValue);
      
   }  // end constructor Categories
   
   // Mutators
   
   public void setCategoryValue(String _categoryValue) {
      categoryValue = _categoryValue;
   }
   
   // end Mutators
   
   // Accessors
   
   public String getCategoryValue() {
      return categoryValue;
   }
   
   // end Accessors

}  // end class Categories