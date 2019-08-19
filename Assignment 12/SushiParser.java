import java.io.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import java.util.ArrayList;
import javax.xml.stream.*;

/**
  *   Name:        Rishi Wadekar                            <BR>
  *   Course:      Java for Programmers ISTE-200 2018-FALL  <BR>
  *   Homework:    #12, XML, Network, GUI                   <BR>
  *   Date:        12/08/2018                               <BR>
  * <BR>
  *   Class:       SushiParser                              <BR>
  *   Purpose:     This class is used to parse the XML file and
  *                store the data read from it into instances of
  *                Results.
  *                          
  * <BR>
  *   @see SushiMain
  *   @see Results
  */

public class SushiParser {
   
   private DocumentBuilder builder;
   private XPath path;
   
   
   public SushiParser() throws ParserConfigurationException {
   
      DocumentBuilderFactory dbFactory = 
                        DocumentBuilderFactory.newInstance();
      builder = dbFactory.newDocumentBuilder();
      XPathFactory xpFactory = XPathFactory.newInstance();
      path = xpFactory.newXPath();
      
   }  // end constructor SushiParser
   
   
   /**
     * Parses the file and retuens the array list of results
     * read from the xml file.
     *
     * @param fileName      file name of the XML file to be read
     * @return results      an object of type ArrayList<Results>
     */
   public ArrayList<Results> parse(String fileName) throws 
        SAXException, IOException, XPathExpressionException {
      
      File f = new File(fileName);
      Document doc = builder.parse(f);
      ArrayList<Results> results = new ArrayList<Results>();
      int resultCount = Integer.parseInt(path.evaluate(
                      "count(/query/results/Result)", doc));
      
      String location = "/query/results/Result[";
      
      for(int i = 1; i <= resultCount; i++) {
         String title = path.evaluate(location + i + 
                                            "]/Title", doc);
         String address = path.evaluate(location + i + 
                                          "]/Address", doc);
         String city = path.evaluate(location + i + 
                                             "]/City", doc);
         String state = path.evaluate(location + i + 
                                            "]/State", doc);
         String phone = path.evaluate(location + i + 
                                            "]/Phone", doc);
         String latitude = path.evaluate(location + i + 
                                         "]/Latitude", doc);
         String longitude = path.evaluate(location + i + 
                                        "]/Longitude", doc);
         String avgRating = path.evaluate(location + i + 
                             "]/Rating/AverageRating", doc);
         String totalRatings = path.evaluate(location + i + 
                              "]/Rating/TotalRatings", doc);
         String totalReviews = path.evaluate(location + i + 
                              "]/Rating/TotalReviews", doc);
         String lastReviewDate = path.evaluate(location + 
                        i + "]/Rating/LastReviewDate", doc);
         String lastReviewIntro = path.evaluate(location + 
                       i + "]/Rating/LastReviewIntro", doc);
         String distance = path.evaluate(location + i + 
                                         "]/Distance", doc);
         String url = path.evaluate(location + i + "]/Url", 
                                                       doc);
         String clickUrl = path.evaluate(location + i + 
                                         "]/ClickUrl", doc);
         String mapUrl = path.evaluate(location + i + 
                                           "]/MapUrl", doc);
         String businessUrl = path.evaluate(location + i + 
                                      "]/BusinessUrl", doc);
         String businessClickUrl = path.evaluate(location + 
                             i + "]/BusinessClickUrl", doc);
         
         // Categories
         String categories = null;
         int categoryCount = Integer.parseInt(path.evaluate(
                 "count(" + location + Integer.toString(i) + 
                                      "]/Categories/Category)", doc));
//          System.out.println(categoryCount);
         
         if(categoryCount >= 1) {
            categories = path.evaluate(location + i + 
                                     "]/Categories/Category[1]", doc);        
         }
         
         for(int j = 2; j <= categoryCount; j++) {
            categories += ", " + path.evaluate(location + i + 
            "]/Categories/Category[" + j + "]", doc);
         }
         
//          System.out.println(categories);
         // Rating instance
         Rating r = new Rating(avgRating, totalRatings, 
                totalReviews, lastReviewDate, lastReviewIntro);
         
         // Categories instance
         Categories c = new Categories(categories);
         
         // Results instance
         Results result = new Results(title, address, city, 
           state, phone, latitude, longitude, r, distance, url, 
           clickUrl, mapUrl, businessUrl, businessClickUrl, c);
         
         // Adding to arraylist
         results.add(result);
         
      }  // end for loop
      
      return results;
      
   }  // end method parse
   
   
   /**
     * Converts the data from the table to an XML file.
     *
     * @param fileName      file name of the XML file to be written
     * @param tableData     2D String array which stores the values 
     *                      in the table.
     */ 
   public void writeFile(String[][] tableData, String fileName) {
   
      int rows = tableData.length;
      String outFile = fileName.substring(0, fileName.length() - 
                                                4) + "_out.xml";
      try {
         OutputStream os = new FileOutputStream(
                                             new File(outFile));
         XMLStreamWriter xsw = XMLOutputFactory.newInstance().
              createXMLStreamWriter(new OutputStreamWriter(os));
         xsw.writeStartDocument();
            xsw.writeStartElement("results");
               for(int i = 0; i < rows; i++) {
                  xsw.writeStartElement("Result");
                     xsw.writeStartElement("Title");
                        xsw.writeCharacters(tableData[i][0]);
                     xsw.writeEndElement();
                     xsw.writeStartElement("Address");
                        xsw.writeCharacters(tableData[i][1]);
                     xsw.writeEndElement();
                     xsw.writeStartElement("City");
                        xsw.writeCharacters(tableData[i][2]);
                     xsw.writeEndElement();
                     xsw.writeStartElement("State");
                        xsw.writeCharacters(tableData[i][3]);
                     xsw.writeEndElement();
                     xsw.writeStartElement("Phone");
                        xsw.writeCharacters(tableData[i][4]);
                     xsw.writeEndElement();
                     xsw.writeStartElement("Rating");
                        xsw.writeStartElement("AverageRating");
                           xsw.writeCharacters(tableData[i][5]);
                        xsw.writeEndElement();
                        xsw.writeStartElement("TotalRatings");
                           xsw.writeCharacters(tableData[i][6]);
                        xsw.writeEndElement();
                        xsw.writeStartElement("LastReviewDate");
                           xsw.writeCharacters(tableData[i][7]);
                        xsw.writeEndElement();
                     xsw.writeEndElement();
                  xsw.writeEndElement();
               }
            xsw.writeEndElement();
         xsw.writeEndDocument();
         xsw.flush();
         xsw.close();
      }
      catch(Exception ex) {}
      
   
   }  // end method writeFile

}  // end class SushiParser