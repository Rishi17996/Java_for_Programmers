/**
  *   Name:        Rishi Wadekar                            <BR>
  *   Course:      Java for Programmers ISTE-200 2018-FALL  <BR>
  *   Homework:    #12, XML, Network, GUI                   <BR>
  *   Date:        12/08/2018                               <BR>
  * <BR>
  *   Class:       Results                                  <BR>
  *   Purpose:     This class contains the Results constructor. 
  *                It stores the atttribute values of Results.
  *                          
  * <BR>
  *   @see Rating
  *   @see Categories
  */

public class Results {
  
   private String title;
   private String address;
   private String city;
   private String state;
   private String phone;
   private String latitude;
   private String longitude;
   private Rating rating;
   private String distance;
   private String url;
   private String clickUrl;
   private String mapUrl;
   private String businessUrl;
   private String businessClickUrl;
   private Categories categories;
   
   public Results(String _title, String _address, String _city, 
                String _state, String _phone, String _latitude, 
           String _longitude, Rating _rating, String _distance, 
                 String _url, String _clickUrl, String _mapUrl, 
                 String _businessUrl, String _businessClickUrl, 
                                      Categories _categories) {
      
      title = _title;
      address = _address;
      city = _city;
      state = _state;
      phone = _phone;
      latitude = _latitude;
      longitude = _longitude;
      rating = _rating;
      distance = _distance;
      url = _url;
      clickUrl = _clickUrl;
      mapUrl = _mapUrl;
      businessUrl = _businessUrl;
      businessClickUrl = _businessClickUrl;
      categories = _categories;
      
   }  // end constructor Results
   
   // Accessors
   
   public String getTitle() {
      return title;
   }
   
   public String getAddress() {
      return address;
   }
   
   public String getCity() {
      return city;
   }
   
   public String getState() {
      return state;
   }
   
   public String getPhone() {
      return phone;
   }
   
   public String getLatitude() {
      return latitude;
   }
   
   public String getLongitude() {
      return longitude;
   }
   
   public Rating getRating() {
      return rating;
   }
   
   public String getUrl() {
      return url;
   }
   
   public String getClickUrl() {
      return clickUrl;
   }
   
   public String getMapUrl() {
      return mapUrl;
   }
   
   public String getBusinessUrl() {
      return businessUrl;
   }
   
   public String getBusinessClickUrl() {
      return businessClickUrl;
   }
   
   public Categories getCategories() {
      return categories;
   }

}  // end class Results