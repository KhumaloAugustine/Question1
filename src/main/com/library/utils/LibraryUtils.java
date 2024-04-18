package main.com.library.utils;

import main.com.library.models.Book;

import java.util.List;

public class LibraryUtils {

    public static Book findBookByTitle(List<Book> books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}

