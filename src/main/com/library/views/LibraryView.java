package main.com.library.views;

import main.com.library.models.Library;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryView {

    private final Scanner scanner;
    private final Library library; // Optional reference to the currently selected library

    public LibraryView(Library library) {
        this.scanner = new Scanner(System.in);
        this.library = library;
    }

    public void displayWelcomeMessage() {
        if (library != null) {
            System.out.println("\nWelcome to the " + library.getName() + " Library!");
        } else {
            System.out.println("\nWelcome to the Library System!");
        }
        System.out.println("Hours: 9AM to 5PM daily"); // Common hours displayed here
    }

    public int getUserChoice() {
        int choice;
        do {
            try {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character after integer input
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input from buffer
                choice = -1; // Set choice to an invalid value to prompt again
            }
        } while (choice < 1); // Keep looping until a valid choice (greater than or equal to 1) is entered
        return choice;
    }

    public String getBookTitleInput() {
        System.out.print("Enter the title of the book: ");
        return scanner.nextLine().trim();
    }

    public void displayBorrowBookMenu() {
        System.out.println("\nBorrow a Book:");
    }

    public void displayReturnBookMenu() {
        System.out.println("\nReturn a Book:");
    }

    public void displayLibraryMenu(String libraryName) {
        System.out.println("\nMain Menu (" + libraryName + " Library):");
        System.out.println("1. Print Available Books");
        System.out.println("2. Borrow a Book");
        System.out.println("3. Return a Book");
        System.out.println("4. Exit");
    }
}