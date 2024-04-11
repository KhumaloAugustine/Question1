package main.com.library.models;

public class Book {

    private final String title;
    private final String author;
    private final String isbn;
    private boolean available; // Flag indicating if the book is available

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true; // Initially available
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrow() {
        available = false;
    }

    public void returnBook() {
        available = true;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + isbn + ")";
    }
}