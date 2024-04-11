package main.com.library.models;
// Import the Book class if it's in a different package

public class DummyBooks {

    /**
     * Provides an array of pre-defined Book objects for demonstration purposes.
     *
     * @return An array of Book objects containing dummy book data.
     */
    public static Book[] getDummyBooks() {
        return new Book[]{
                // Book 1
                new Book.Builder()
                        .title("The Lord of the Rings")
                        .author("J.R.R. Tolkien")
                        .isbn("9780261102694")
                        .build(),

                // Book 2
                new Book.Builder()
                        .title("Pride and Prejudice")
                        .author("Jane Austen")
                        .isbn("9780140435225")
                        .build(),

                // Book 4
                new Book.Builder()
                        .title("The Hitchhiker's Guide to the Galaxy")
                        .author("Douglas Adams")
                        .isbn("9780345391803")
                        .build(),

                // Book 5
                new Book.Builder()
                        .title("Frankenstein")
                        .author("Mary Shelley")
                        .isbn("9781822057387")
                        .build(),

                // Book 6
                new Book.Builder()
                        .title("The Adventures of Sherlock Holmes")
                        .author("Arthur Conan Doyle")
                        .isbn("9780143039828")
                        .build(),

                // Book 7
                new Book.Builder()
                        .title("Nineteen Eighty-Four")
                        .author("George Orwell")
                        .isbn("9780451524935")
                        .build(),

                // Book 8
                new Book.Builder()
                        .title("The Catcher in the Rye")
                        .author("J. D. Salinger")
                        .isbn("9780316769482")
                        .build(),

                // Book 9
                new Book.Builder()
                        .title("One Hundred Years of Solitude")
                        .author("Gabriel García Márquez")
                        .isbn("9780553278876")
                        .build(),

                // Book 10
                new Book.Builder()
                        .title("The Great Gatsby")
                        .author("F. Scott Fitzgerald")
                        .isbn("9780743273565")
                        .build(),
        };
    }
}
