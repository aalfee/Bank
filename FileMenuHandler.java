import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.StringTokenizer;


public class FileMenuHandler implements ActionListener {
   BankGUI myGui;
   TextArea entryList;
   TextArea printList;
   
   public FileMenuHandler (BankGUI mg, TextArea el, TextArea pl) {
      myGui = mg;
      entryList = el;
      printList = pl;
   } //constructor
   
   public void actionPerformed(ActionEvent event) {
      String menuName = event.getActionCommand();
      // if open is clicked, it will open a file menu
      if (menuName.equals("Open"))
         openFile(myGui);
      else if (menuName.equals("Quit"))
         // if quit is clicked, the program will end
          System.exit(0); 
      
   } //actionPerformed
   
   public void openFile(BankGUI mg) {
      JFileChooser chooser = new JFileChooser();
      chooser.showOpenDialog(null);
      String filename = (chooser.getSelectedFile()).getAbsolutePath();
      // it will read the chosen file and send it to print it onto the gui
      BankGUI.printFileToGUI(readFile(filename), entryList, printList);    
   }
   
   public static String[] readFile(String filename) {
      // method will read an inputed file and use the
      // StringTokenizer class to read all the dates
      int counter = 0;
      int tokenCounter = 0;
      TextFileInput in = new TextFileInput(filename);
      String line = in.readLine();
      while (line != null) { 
         // counts the amount tokens in file
         StringTokenizer token = new StringTokenizer(line, ",");
         tokenCounter += token.countTokens();
         line = in.readLine();
      } // close while
      
      String[] money = new String[tokenCounter];
      TextFileInput file = new TextFileInput(filename);
      String line2 = file.readLine();
      
      while (line2 != null) { 
         // takes each token on a given line and puts it in a string array
         StringTokenizer token2 = new StringTokenizer(line2, ",");
         while (token2.hasMoreTokens()) {
            money[counter++] = token2.nextToken();
         } // close while
         line2 = file.readLine();
      } // close while
      
      return money;
   } // close readFile


}