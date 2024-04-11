import main.com.library.controllers.LibraryController;
import main.com.library.models.Library;
import main.com.library.views.LibraryView;

public class Main {

    public static void main(String[] args) {
        LibraryController controller = new LibraryController();
        controller.run();
    }
}