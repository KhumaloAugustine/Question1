package main.com.library.models;

public class Book {

    //  Stores the title of the book
    private final String title;

    //  Stores the author's name
    private final String author;

    //  Stores the International Standard Book Number (unique identifier)
    private final String isbn;

    //  Flag to indicate if the book is available for borrowing (true) or borrowed (false)
    private boolean available;

    //  Private constructor to prevent direct object creation (use builder instead)
    private Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true;
    }

    //  Getter method to access the book's title
    public String getTitle() {
        return title;
    }

    //  Getter method to access the author's name
    public String getAuthor() {
        return author;
    }

    //  Getter method to access the ISBN number
    public String getIsbn() {
        return isbn;
    }

    //  Checks if the book is currently available for borrowing
    public boolean isAvailable() {
        return available;
    }

    //  Marks the book as borrowed (sets available to false)
    public void borrow() {
        available = false;
    }

    //  Marks the book as returned (sets available to true)
    public void returnBook() {
        available = true;
    }

    //  Defines how a Book object is represented as a string
    //  This format displays title, author, and ISBN in parentheses
    @Override
    public String toString() {
        return title + " by " + author + " (" + isbn + ")";
    }

    //  Nested static builder class for creating Book objects
    public static class Builder {

        private String title;
        private String author;
        private String isbn;

        // Consistent naming convention (member variable name matches setter method name)
        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder isbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public Book build() {
            // Validate data if needed before creating the Book object
            return new Book(title, author, isbn);
        }
    }
}