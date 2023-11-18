package libmgmtsys;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for the editBooks class.
 * 
 * @author Ali Usmani
 */
public class EditBooksTest {

    public EditBooksTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addBook method, of class EditBooks.
     */
    @Test
    public void testAddBook() {
        System.out.println("addBook");
        EditBooks instance = EditBooks.getInstance();
        Book book = new Book("Sample Book", 25.0);
        instance.addBook(book);
        int expResult = 1;
        int result = instance.getBookList().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteBook method, of class EditBooks.
     */
    @Test
    public void testDeleteBook() {
        System.out.println("deleteBook");
        EditBooks instance = EditBooks.getInstance();
        Book book = new Book("Sample Book", 25.0);
        instance.addBook(book);
        instance.deleteBook(book);
        int expResult = 0;
        int result = instance.getBookList().size();
        assertEquals(expResult, result);
    }
}
