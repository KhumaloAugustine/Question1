import main.com.library.controllers.LibraryController;

public class Main {

    //  The main entry point of the library system application
    public static void main(String[] args) {
        //  Create a LibraryController object to handle the application logic
        LibraryController controller = new LibraryController();
        //  Start the main program loop controlled by the LibraryController
        controller.run();
    }
}