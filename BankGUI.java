import java.awt.*;
import java.util.*;
import javax.swing.*;


public class BankGUI extends JFrame {
// This is the beginning of the program
    public static BankGUI initiateGUI(BankGUI myGUI) {
        myGUI = new BankGUI();                                                // Creating a new GUI
        myGUI.setSize(300, 450);                                    // Setting the size of the GUI in pixes width and height
        myGUI.setLocation(200, 200);                                         // Setting the location 200 pixes right and 200 pixes down
        myGUI.setLayout(new GridLayout(2,1));                         // "The GUI should have a GridLayout with one row and two columns"
        myGUI.setTitle("BankGUI");                // Setting the title of the window/program itself
        myGUI.setDefaultCloseOperation(EXIT_ON_CLOSE);                         
        Container myContentPane = myGUI.getContentPane();       // Creating the main "page" where all the content goes                
        TextArea entryList = new TextArea();                                        // Creating a text area to append all our text and sorted dates to
        TextArea printList = new TextArea();                                      // this text area is for the unsorted dates
        // Set a detault font for EntryList 
        entryList.setFont(new Font("Serif sans", Font.PLAIN, 20));
        // Setting a bigger font size
        myContentPane.add(entryList);                                             // Connecting the unsorted text area to appear on the ContentPane
        myContentPane.add(printList);                                             // Connecting the sorted text area to the ContentPane
        entryList.append("Entries List"+ "\n\n");                                    // Initalizing the text area to contain titles of the lists
        printList.append("Statistics" + "\n\n");
        JMenuBar menuBar = new JMenuBar();                                       // This section initializes the menu bar to hold:
        myGUI.createFileMenuBar(menuBar, entryList, printList);                      //     the file input menu bar (with "quit" option)
        myGUI.createEditMenuBar(menuBar, entryList, printList);                      //     the edit menu bar and search option
        myGUI.setVisible(true);                                                // "Turns on" the GUI itself
        return myGUI;                                                            // returns the object GUI back to the main class
    }

    // This class is responsible for creating the menu to input a file and quit the program
    public void createFileMenuBar(JMenuBar menuBar, TextArea sorted, TextArea unsorted) {
        JMenuItem item1;
        JMenu fileMenu = new JMenu("File");                                    // The first tab in the menu called "File" is initialized
        FileMenuHandler fmh = new FileMenuHandler(this, sorted, unsorted);       // and an instance of the FileMenuHandler class is created 
        item1 = new JMenuItem("Open");                                      //      the first option in the "File" tab is called "Open"
        item1.addActionListener(fmh);                                            //      will open any file for reading using addActionListener
        fileMenu.add(item1);                                                     // This appends the item "Open" onto the menu "File" 
        fileMenu.addSeparator();                                                 // This creates a little separation between the next item
        JMenuItem item2 = new JMenuItem("Quit");                            //      which is called "Quit", and will close the program
        item2.addActionListener(fmh);
        fileMenu.add(item2);
        setJMenuBar(menuBar);                                                    // This updates the menuBar that was passed in and attaches
        menuBar.add(fileMenu);                                                   //     the fileMenu we just created
    }
    // Similarly to the createFileMenuBar, this creates a menu to edit the lists and display only certain year dates
    public void createEditMenuBar(JMenuBar menuBar, TextArea unsorted, TextArea sorted) {
        JMenu editMenu = new JMenu("Edit");                                    // This creates the tab in the menu called "Edit"
        EditMenuHandler emh = new EditMenuHandler(this, unsorted, sorted);       // and an instance of the EditMenuHandler is created
        JMenuItem item1 = new JMenuItem("Search");                          //      the first option in the "Edit" tab is called "Search"
        JMenuItem item2 = new JMenuItem("Insert");
        JMenuItem item3 = new JMenuItem("Font");
        item1.addActionListener(emh);                                            //      will prompt the user for a year when clicked
        item2.addActionListener(emh);
        item2.addActionListener(emh);
        editMenu.add(item1);                                                     // This appends the item "Search" onto the meny "Edit"
        editMenu.addSeparator();
        editMenu.add(item2);
        editMenu.addSeparator();
        editMenu.add(item3);
        setJMenuBar(menuBar);
        menuBar.add(editMenu);
    }

    // Use ArrayList instead of DateNode                          // Using "sdl" variable name for SortedDate212List shorthand                  // Using "udl" variable name for UnsortedDate212List shorthand
    static ArrayList<Money> el = new ArrayList<>();
    static ArrayList<Money> fel = new ArrayList<>();

    // This method prints the dates from the list passed in onto the GUI
    public static void printFileToGUI(String[] list, TextArea entryList, TextArea printList) {
        Money.clearCount();
        Entry.clearLogCount();
        Print.clearTotal();
        el.clear();
        for (int i = 0; i < list.length; i++) {                                 // For loop iterator 
            el.add(new Money(list[i]));
        
        }

        entryList.setText("Entries List" +"\n\n");                  // Also underlining to show the start of a new list
        for (Money money : el) {
            entryList.append(money.toString() + "\n");
        }
        printList.setText("Statistics" + "\n\n");                        // Provide clear sign of the updates TextArea                                       // Using collections.sort() method to arrange the arraylist form smallest to largest // Iterate through the arraylist and append the string to the GUI       // according to the compareTo function in the Date212 class                                  
            printList.append(Print.toString(el) + "\n");
        }
    


    public void displayFilteredMoney(Double searchMoney, TextArea entryList, TextArea printList) {
    if (BankGUI.el.isEmpty()) {                                             // Checks if the sorted ArrayList is empty (or if no files were open already)
        JOptionPane.showMessageDialog(null, "Please open a file to load data first.");
        return;
    }
    // Clear the existing content in the filtered TextArea
    entryList.setText("Filtered Entries List" + "\n\n");       // Provide a clear sign of an updates TextArea
    printList.setText("Statistics" + "\n\n");             // Underline serves as the start of the list

    for (Money money : BankGUI.el) {
        if (money.getValueAsDouble() == searchMoney) {                                     // Iterate through the udl and compare each date's year                                                //      to the searchYear inputed by user
            fel.add(money);
            entryList.append(money.toString() + "\n");                        //      if it matches, we append the year
            }
    }

    // Same logic follows for the printedList 
    Print.clearTotal();         // clear the new total 
    printList.append(Print.toString(fel) + "\n");   
    }   // displayFilteredMoney

public void displayInsertedMoney(Money insertMoney, TextArea entryList, TextArea printList) {
    if (BankGUI.el.isEmpty() ) {                                             // Checks if the sorted ArrayList is empty (or if no files were open already)
        JOptionPane.showMessageDialog(null, "Please open a file to load data first.");
        return;
    }
    // Clear the existing content in the filtered TextArea
    entryList.setText("Modified Entries List" + "\n\n");       // Provide a clear sign of an updates TextArea
    printList.setText("Statistics" + "\n\n");             // Underline serves as the start of the list

    el.add(insertMoney);            // add the new money to the og list

    for (Money money : BankGUI.el) {                                    // Iterate through the udl and compare each date's year                                                //      to the searchYear inputed by user
            fel.add(money);
            entryList.append(money.toString() + "\n");                        //      if it matches, we append the year
    }

    // Same logic follows for the printedList 
    Print.clearTotal();         // clear the new total 
    printList.append(Print.toString(fel) + "\n");   
    }

} // JFrame
