import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Date;


/**
  *   Name:        Rishi Wadekar                            <BR>
  *   Course:      Java for Programmers ISTE-200 2018-FALL  <BR>
  *   Homework:    #12, XML, Network, GUI                   <BR>
  *   Date:        12/08/2018                               <BR>
  * <BR>
  *   Class:       SushiMain                                <BR>
  *   Purpose:     This class contains the main method.
  *                          
  * <BR>
  *   @see SushiMain
  *   @see Results
  */
class SushiMain extends JFrame implements ActionListener{
   
   private String[] TABLE_HEADERS = {"Title", "Address", "City", 
                             "State", "Phone", "Average Rating", 
                           "Total Ratings", "Last Review Date"};
   private String[] FILE_NAMES = {"RochesterSushi.xml", 
                                       "SanFranciscoSushi.xml"};
   private ArrayList<Results> results;                         
   private JPanel sushiPanel;
   private JPanel fileInputPanel;
   private JLabel fileInputLabel;
   private JTextField fileInputTextField;
   private JComboBox jcbFiles;
   private JButton fileInputButton;
   private JButton clearButton;
   private JButton writeFileButton;
   private JTable sushiTable;
   private DefaultTableModel dtmSushi;
   private String fileName;
   
   
   public static void main(String[] args) {
      
      new SushiMain();     
      
   }
   
   /**
  *   Constructor: SushiMain
  */
   public SushiMain() {
      
      // title
      this.setTitle("Rishi Wadekar's Sushi Parser");
      
      // file input panel
      fileInputPanel = new JPanel();
      fileInputLabel = new JLabel("File Name: ", JLabel.RIGHT);
//       fileInputTextField = new JTextField("", 20);
      jcbFiles = new JComboBox(FILE_NAMES);
      fileInputButton = new JButton("Populate Table");
      fileInputButton.addActionListener(this);
      clearButton = new JButton("Clear Table");
      clearButton.addActionListener(this);
      writeFileButton = new JButton("Write File");
      writeFileButton.addActionListener(this);
      fileInputPanel.add(fileInputLabel);
      fileInputPanel.add(jcbFiles);
      fileInputPanel.add(fileInputButton);
      fileInputPanel.add(clearButton);
      fileInputPanel.add(writeFileButton);
      
      // JTable panel
      sushiPanel = new JPanel();
      dtmSushi = new DefaultTableModel(0, 0);
      
      dtmSushi.setColumnIdentifiers(TABLE_HEADERS);
      
      sushiTable = new JTable(dtmSushi);
      
      sushiPanel.add(sushiTable);
      sushiPanel.add(new JScrollPane(sushiTable), 
                                          BorderLayout.CENTER);
      
      this.add(fileInputPanel, BorderLayout.NORTH);
      this.add(sushiPanel, BorderLayout.CENTER);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.getContentPane().add(new JScrollPane(sushiTable, 
                  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
              JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
      this.setExtendedState(JFrame.MAXIMIZED_BOTH);
      this.setVisible(true);
   }
   
   
   /**
     * Overwritten method that respons to various action events.
     *
     */
   public void actionPerformed(ActionEvent ae) {
   
      // POPULATE
      if(ae.getSource() == fileInputButton) {
         
         try {
            SushiParser sushiParser = new SushiParser();
            fileName = String.valueOf(jcbFiles.getSelectedItem());
            results = sushiParser.parse(fileName);
            for(Results r: results) {
               Results result = (Results)r;
               Rating rating = result.getRating();
               String date = rating.getLastReviewDate();
               if(date.equals("")) {
                  date = null;
               }
               else {
                  date = String.valueOf(new Date(Long.valueOf(date)));
               }
               dtmSushi.addRow(new Object[] {result.getTitle(), 
                         result.getAddress(), result.getCity(), 
                          result.getState(), result.getPhone(), 
           rating.getAverageRating(), rating.getTotalRatings(), 
                                                        date});
            }
         }
         catch(Exception ex) {}
         
      }  // end TEST
      
      // CLEAR TABLE
      if(ae.getSource() == clearButton) {
         DefaultTableModel dm = 
                     (DefaultTableModel)sushiTable.getModel();
         while(dm.getRowCount() > 0) {
            dm.removeRow(0);
         }
      }  // end CLEAR TABLE
      
      // WRITE FILE
      if(ae.getSource() == writeFileButton) {
         int rows = sushiTable.getRowCount();
         int columns = sushiTable.getColumnCount();
         String[][] tableData = new String[rows][columns];
                  
         // Getting data from the table
         for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
               tableData[i][j] = String.valueOf(sushiTable.
                                           getValueAt(i, j));
            }
         }
         try {
            SushiParser sushiParser = new SushiParser();
            sushiParser.writeFile(tableData, fileName);
         }
         catch(Exception ex) {}
      }  // end WRITE FILE
   }
   
}