package main.com.library.models;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private final String name;
    private final String address;
    private final String hours; // Hours of operation (common for all libraries)
    private final List<Book> books; // Collection of books in the library

    public Library(String name, String address) {
        this.name = name;
        this.address = address;
        this.hours = "9AM to 5PM daily"; // Common hours
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Successfully added \"" + book.getTitle() + "\" by " + book.getAuthor());
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public boolean borrowBook(Book book) {
        if (book.isAvailable()) {
            book.borrow();
            System.out.println("Successfully borrowed \"" + book.getTitle() + "\" by " + book.getAuthor());
            return true;
        } else {
            System.out.println("\"" + book.getTitle() + "\" is not available for borrowing.");
            return false;
        }
    }

    public void returnBook(Book book) {
        book.returnBook();
        System.out.println("Successfully returned \"" + book.getTitle() + "\" by " + book.getAuthor());
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getHours() {
        return hours;
    }

    public void printAvailableBooks() {
        System.out.println("\nAvailable Books at " + name + " Library:");
        if (getAvailableBooks().isEmpty()) {
            System.out.println("  There are currently no available books.");
        } else {
            for (Book book : getAvailableBooks()) {
                System.out.println("  - " + book);
            }
        }
    }
}