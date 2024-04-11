package main.com.library.views;

import main.com.library.models.Library;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryView {

    //  Scanner object for user input
    private final Scanner scanner;

    //  Reference to the currently selected library (can be null for general messages)
    private final Library library;

    public LibraryView(Library library) {
        this.scanner = new Scanner(System.in);
        this.library = library;
    }

    //  Displays a welcome message depending on whether a specific library is selected
    public void displayWelcomeMessage() {
        if (library != null) {
            System.out.println("\nWelcome to the " + library.getName() + " Library!");
        } else {
            System.out.println("\nWelcome to the Library System!");
        }
        System.out.println("Hours: 9AM to 5PM daily");
    }

    //  Gets a valid integer choice from the user, handling potential input mismatches
    public int getUserChoice() {
        int choice;
        do {
            try {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume remaining newline character (if any)
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the scanner buffer after an exception
                choice = -1; // Set choice to an invalid value to repeat the loop
            }
        } while (choice < 1); // Repeat until a valid positive choice is entered
        return choice;
    }

    //  Gets the title of a book as a string from the user
    public String getBookTitleInput() {
        System.out.print("Enter the title of the book: ");
        return scanner.nextLine().trim(); // Read and trim user input
    }

    //  Displays a menu for borrowing a book
    public void displayBorrowBookMenu() {
        System.out.println("\nBorrow a Book:");
    }

    //  Displays a menu for returning a book
    public void displayReturnBookMenu() {
        System.out.println("\nReturn a Book:");
    }

    //  Displays the main menu with options specific to the selected library
    public void displayLibraryMenu(String libraryName) {
        System.out.println("\nMain Menu (" + libraryName + " Library):");
        System.out.println("1. Print Available Books");
        System.out.println("2. Borrow a Book");
        System.out.println("3. Return a Book");
        System.out.println("4. Exit");
    }
}