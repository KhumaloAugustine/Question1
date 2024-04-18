package main.com.library.controllers;

import main.com.library.models.Book;
import main.com.library.models.DummyBooks;
import main.com.library.models.Library;
import main.com.library.utils.LibraryUtils;
import main.com.library.views.LibraryView;

import java.util.ArrayList;
import java.util.List;

public class LibraryController {

    //  List to store all available libraries in the system
    private final List<Library> libraries;

    //  Reference to the library view object for user interaction
    private LibraryView view;

    public LibraryController() {
        this.libraries = new ArrayList<>();
        //  Add libraries (name, address) to the list during initialization
        libraries.add(new Library("Mountain View Library", "1 Main St."));
        libraries.add(new Library("Forest Creek Library", "5 Elm St."));

        // Add dummy books to each library
        for (Library library : libraries) {
            for (Book book : DummyBooks.getDummyBooks()) {
                library.addBook(book);
            }
        }

        //  Create an initial LibraryView object without a specific library assigned yet
        this.view = new LibraryView(null);
    }

    //  Main program loop that handles user interaction
    public void run() {
        int choice;
        //  Variable to store the currently selected library
        Library currentLibrary = null;

        do {
            //  Display welcome message using the view
            view.displayWelcomeMessage();
            System.out.println("\nSelect Library:");
            int i = 1;
            for (Library library : libraries) {
                //  Print numbered library names
                System.out.println(i + ". " + library.getName());
                i++;
            }
            System.out.print("Enter your choice: ");
            //  Get user input for library selection using the view
            choice = view.getUserChoice();

            //  Validate user choice (within library list range)
            if (choice > 0 && choice <= libraries.size()) {
                //  Set the currentLibrary based on the user's choice
                currentLibrary = libraries.get(choice - 1);
                //  Update the view with the selected library
                view = new LibraryView(currentLibrary);
                //  Display library-specific menu and handle actions
                libraryMenu(currentLibrary);
            } else {
                System.out.println("Invalid library choice.");
            }
        } while (choice != 4);

        System.out.println("\nThank you for using the library system!");
    }

    //  Menu for actions within a specific library
    private void libraryMenu(Library library) {
        int choice;
        do {
            //  Display welcome message and library name using the view
            view.displayWelcomeMessage();
            view.displayLibraryMenu(library.getName());
            choice = view.getUserChoice();
            switch (choice) {
                case 1:
                    //  Display available books using the library object
                    library.printAvailableBooks();
                    break;
                case 2:
                    //  Handle borrowing a book
                    borrowBook(library);
                    break;
                case 3:
                    //  Handle returning a book
                    returnBook(library);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    //  Process for borrowing a book (find by title and call library method)
    private void borrowBook(Library library) {
        view.displayBorrowBookMenu();
        String title = view.getBookTitleInput();

        //  Search for the book by title using LibraryUtils
        Book book = LibraryUtils.findBookByTitle(library.getAvailableBooks(), title);
        if (book != null) {
            //  Attempt to borrow the book using the library object
            library.borrowBook(book);
        } else {
            System.out.println("Book not found in " + library.getName() + " Library.");
        }
    }

    //  Process for returning a book (find by title and call library method)
    private void returnBook(Library library) {
        view.displayReturnBookMenu();
        String title = view.getBookTitleInput();
        //  Search for the book by title within the library's borrowed books list
        Book borrowedBook = library.findBorrowedBook(title);
        if (borrowedBook != null) {
            //  Book found in borrowed list, return it
            library.returnBook(borrowedBook);
        } else {
            System.out.println("Book not found in " + library.getName() + " Library.");
        }
    }
}