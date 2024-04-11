package main.com.library.controllers;

import main.com.library.models.Book;
import main.com.library.models.Library;
import main.com.library.views.LibraryView;

import java.util.ArrayList;
import java.util.List;

public class LibraryController {

    private final List<Library> libraries; // List of available libraries
    private LibraryView view;

    public LibraryController() {
        this.libraries = new ArrayList<>();
        // Add libraries (name, address) to the list
        libraries.add(new Library("Mountain View Library", "1 Main St."));
        libraries.add(new Library("Forest Creek Library", "5 Elm St."));
        this.view = new LibraryView(null); // View doesn't depend on a specific library initially
    }

    public void run() {
        int choice;
        Library currentLibrary = null; // Stores the currently selected library

        do {
            view.displayWelcomeMessage();
            System.out.println("\nSelect Library:");
            int i = 1;
            for (Library library : libraries) {
                System.out.println(i + ". " + library.getName());
                i++;
            }
            System.out.print("Enter your choice: ");
            choice = view.getUserChoice();

            if (choice > 0 && choice <= libraries.size()) {
                currentLibrary = libraries.get(choice - 1);
                view = new LibraryView(currentLibrary); // Update view with selected library
                libraryMenu(currentLibrary); // Handle library-specific actions
            } else {
                System.out.println("Invalid library choice.");
            }
        } while (choice != 4);

        System.out.println("\nThank you for using the library system!");
    }

    private void libraryMenu(Library library) {
        int choice;
        do {
            view.displayWelcomeMessage();
            view.displayLibraryMenu(library.getName()); // Display library-specific name
            choice = view.getUserChoice();
            switch (choice) {
                case 1:
                    library.printAvailableBooks();
                    break;
                case 2:
                    borrowBook(library);
                    break;
                case 3:
                    returnBook(library);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private void borrowBook(Library library) {
        view.displayBorrowBookMenu();
        String title = view.getBookTitleInput();
        Book book = findBookByTitle(library, title);
        if (book != null) {
            library.borrowBook(book);
        } else {
            System.out.println("Book not found in " + library.getName() + " Library.");
        }
    }

    private void returnBook(Library library) {
        view.displayReturnBookMenu();
        String title = view.getBookTitleInput();
        Book book = findBookByTitle(library, title);
        if (book != null) {
            library.returnBook(book);
        } else {
            System.out.println("Book not found in " + library.getName() + " Library.");
        }
    }

    private Book findBookByTitle(Library library, String title) {
        for (Book book : library.getAvailableBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}