/**
  *   Name:        Rishi Wadekar                            <BR>
  *   Course:      Java for Programmers ISTE-200 2018-FALL  <BR>
  *   Homework:    #12, XML, Network, GUI                   <BR>
  *   Date:        12/08/2018                               <BR>
  * <BR>
  *   Class:       Rating                                   <BR>
  *   Purpose:     This class contains the Rating constructor. 
  *                It is an attribute of the Results class.
  * <BR>
  *   @see Results
  */

public class Rating {

   private String averageRating;
   private String totalRatings;
   private String totalReviews;
   private String lastReviewDate;
   private String lastReviewIntro;
   
   public Rating(String _avgRating, String _totalRatings,
            String _totalReviews, String _lastReviewDate, 
                              String _lastReviewIntro) {
   
      setAverageRating(_avgRating);
      setTotalRatings(_totalRatings);
      setTotalReviews(_totalReviews);
      setLastReviewDate(_lastReviewDate);
      setLastreviewIntro(_lastReviewIntro);
   
   }  // end constructor Rating
   
   // Mutators
   
   public void setAverageRating(String _avg) {
      averageRating = _avg;
   }
   
   public void setTotalRatings(String _total) {
      totalRatings = _total;
   }
   
   public void setTotalReviews(String _totalReviews) {
      totalReviews = _totalReviews;
   }
   
   public void setLastReviewDate(String _lastReviewDate) {
      lastReviewDate = _lastReviewDate;
   }
   
   public void setLastreviewIntro(String _lastreviewIntro) {
      lastReviewIntro = _lastreviewIntro;
   }  
   
   // end Mutators
      
   // Accessors
   
   public String getAverageRating() {
      
      return averageRating;
   }
   
   public String getTotalRatings() {
      return totalRatings;
   }
   
   public String getTotalReviews() {
      return totalReviews;
   }
   
   public String getLastReviewDate() {
      return lastReviewDate;
   }
   
   public String getLastreviewIntro() {
      return lastReviewIntro;
   }
   
   // end Accessors
   
}  // end class Rating