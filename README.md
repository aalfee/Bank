# Bank Project
## Description

The "Bank" project is a Java application that provides a graphical user interface (GUI) for managing financial entries. It allows users to open files containing monetary data, display entries, and perform operations such as searching and inserting entries.

# How to Run
1. Run the Main Class:
- Execute the 'Main' class to initiate the GUI.
- The GUI will provide options to open files, display entries, and perform various operations.
```sh
// Example command to run the Main class
javac Main.java
java Main
```

# Files
1. BankGUI.java:

-Contains the main GUI class with functionalities to display entries, create menu bars, and handle user interactions.

2. EditMenuHandler.java:

-Manages actions related to the "Edit" menu in the GUI, including searching and inserting monetary entries.

3. Entry.java:

-Defines the Entry class representing individual entries with log counts.

4. FileMenuHandler.java:

-Handles actions related to the "File" menu, including opening files and quitting the program.

5. Main.java:

-Initiates the GUI by calling the initiateGUI method in the BankGUI class.

6. Money.java:

Represents monetary entries, including methods to convert and display monetary values.

7. Print.java:

Provides functions for calculating and displaying total, mean, median, and mode of monetary entries.

# How to Use
1. Open a File:

- Click on the "File" menu and select "Open" to choose a text file containing monetary amounts (e.g., text.txt).

2. Display Entries:

- Entries will be displayed in the GUI, showing both unsorted and sorted lists.

3. Search Entries:

- Use the "Edit" menu and select "Search" to prompt for a monetary amount. The GUI will display filtered entries matching the specified amount.

4. Insert Entry:

- Use the "Edit" menu and select "Insert" to prompt for a new monetary amount. The GUI will display modified entries with the inserted amount.

# Screenshots
![Alt text](/relative/path/to/img.jpg?raw=true "Optional Title")

# Dependencies
`Java Swing Library`

# Author
Alfiya Valitova
