package main.com.library.models;

import java.util.ArrayList;
import java.util.List;

import static main.com.library.utils.LibraryUtils.findBookByTitle;

public class Library {

    //  Stores the library's name
    private final String name;

    //  Stores the library's address
    private final String address;

    //  Stores the library's operating hours (assumed to be constant)
    private final String hours;

    //  List to store all the books in the library
    private final List<Book> books;

    //  List to store borrowed books (implementation for returning books)
    private List<Book> borrowedBooks;

    //  Constructor to create a new Library object
    public Library(String name, String address) {
        this.name = name;
        this.address = address;
        //  Sets default library hours
        this.hours = "9AM to 5PM daily";
        //  Initializes the book list as an empty ArrayList
        this.books = new ArrayList<>();
        this.borrowedBooks = new ArrayList<>();
    }

    //  Adds a new book to the library's collection
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Successfully added \"" + book.getTitle() + "\" by " + book.getAuthor());
    }

    //  Returns a list of all currently available books in the library
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            //  Checks if the book is available and adds it to the availableBooks list
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    //  Attempts to borrow a book (marks it unavailable if successful)
    public boolean borrowBook(Book book) {
        if (book.isAvailable()) {
            book.borrow();
            borrowedBooks.add(book); // Add borrowed book to the list
            System.out.println("Successfully borrowed \"" + book.getTitle() + "\" by " + book.getAuthor());
            return true;
        } else {
            System.out.println("\"" + book.getTitle() + "\" is not available for borrowing.");
            return false;
        }
    }

    //  Marks a book as returned (sets it available and removes from borrowed list)
    public void returnBook(Book book) {
        book.returnBook();
        borrowedBooks.remove(book); // Remove book from borrowed list
        System.out.println("Successfully returned \"" + book.getTitle() + "\" by " + book.getAuthor());
    }

    //  Searches for a borrowed book by title (case-insensitive and ISBN match)
    public Book findBorrowedBook(String title) {
        for (Book borrowedBook : borrowedBooks) {
            if (borrowedBook.getTitle().equalsIgnoreCase(title) &&
                    borrowedBook.getIsbn().equals(findBookByTitle(books, title).getIsbn())) {
                return borrowedBook;
            }
        }
        return null;
    }

    //  Getter method to access the library's name
    public String getName() {
        return name;
    }

    //  Getter method to access the library's address
    public String getAddress() {
        return address;
    }

    //  Getter method to access the library's hours
    public String getHours() {
        return hours;
    }

    //  Prints a list of all currently available books
    public void printAvailableBooks() {
        System.out.println("\nAvailable Books at " + name + " Library:");
        if (getAvailableBooks().isEmpty()) {
            System.out.println("  There are currently no available books.");
        } else {
            for (Book book : getAvailableBooks()) {
                //  Uses the Book object's toString() method for formatted output
                System.out.println("  - " + book);
            }
        }
    }
}