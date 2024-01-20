import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// this class handles actions related to the "Edit" menu in the GUI.
// it specifically responds to the "Search" option, prompting the user to enter a year.
// Once a year is entered, it calls a method in Date212GUI to display dates matching that year.
public class EditMenuHandler implements ActionListener {
    BankGUI myGui;         // reference to the main GUI
    TextArea entryList;  // text area for displaying filtered unsorted dates
    TextArea printList;    // text area for displaying filtered sorted dates

    // constructor to initialize the handler with references to the GUI and text areas.
    public EditMenuHandler(BankGUI mg, TextArea entries, TextArea prints) {
        myGui = mg;                           // this is the handler for the gui
        entryList = entries;            // this is for the filteredUnsorted text area
        printList = prints;                // this is for the filteredSorted text area
    }
   
    // this method is called when an action (like a button click) is performed in the "Edit" menu.
    // it prompts the user to input a year, then displays dates matching that year in the GUI.
    public void actionPerformed(ActionEvent event) {
        String menuName = event.getActionCommand();

        if(menuName.equals("Search")){
        // ask the user to enter a year using a pop-up input dialog.
        String userSearchInput = JOptionPane.showInputDialog("Enter the amount of Money to search: ");

        try {
            // convert the user input to an integer (year).
            double searchMoney = Double.parseDouble(userSearchInput);
            
            // call the displayFilteredDates method in Date212GUI to show dates for the entered year.
            myGui.displayFilteredMoney(searchMoney, entryList, printList);
        } catch (NumberFormatException ex) {
            // display an error message if the user enters something that is not a valid year.
            JOptionPane.showMessageDialog(null, "Invalid input. please enter a valid money entry.");
            }
        } else if (menuName.equals("Insert")){
            String userInsertInput = JOptionPane.showInputDialog("Enter the amount of Money to insert: ");
            
            double insertMoney = Double.parseDouble(userInsertInput);
            Money newMoney = new Money(insertMoney);
            myGui.displayInsertedMoney(newMoney, entryList, printList);
        }
    }
}
