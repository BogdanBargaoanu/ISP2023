import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Test {
@org.junit.Test
    public void testButton() {
    SwingUtilities.invokeLater(new Runnable() {
        List<Book> books=new ArrayList<>();
        public void run() {
            LibraryBookManagementSystem bookManagementSystem = new LibraryBookManagementSystem();
            bookManagementSystem.setVisible(true);
            books=bookManagementSystem.getBookRecords();
            assertEquals(null,books);
        }
    });
    }
}
