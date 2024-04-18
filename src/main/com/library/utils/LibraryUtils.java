package main.com.library.utils;

import main.com.library.models.Book;
import java.util.List;

public class LibraryUtils {

    /**
     * Finds a book by its title in a list of books.
     *
     * @param books The list of books to search.
     * @param title The title of the book to find.
     * @return The Book object if found, otherwise null.
     */
    public static Book findBookByTitle(List<Book> books, String title) {
        // Iterate through the list of books
        for (Book book : books) {
            // Check if the title matches (case-insensitive comparison)
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book; // Book found, return it
            }
        }
        return null; // Book not found in the list
    }
}