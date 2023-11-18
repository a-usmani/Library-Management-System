package coe528project;

import javafx.scene.control.CheckBox;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for the book class.
 * 
 * @author Ali Usmani
 */
public class BookTest {

    public BookTest() {
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
     * Test of getBookName and setBookName methods, of class book.
     */
    @Test
    public void testGetAndSetBookName() {
        System.out.println("getBookName and setBookName");
        Book instance = new Book("Sample Book", 20.0);
        String expResult = "Sample Book";
        String result = instance.getBookName();
        assertEquals(expResult, result);
        instance.setBookName("New Book");
        expResult = "New Book";
        result = instance.getBookName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBookPrice and setBookPrice methods, of class book.
     */
    @Test
    public void testGetAndSetBookPrice() {
        System.out.println("getBookPrice and setBookPrice");
        Book instance = new Book("Sample Book", 20.0);
        double expResult = 20.0;
        double result = instance.getBookPrice();
        assertEquals(expResult, result, 0.001);
        instance.setBookPrice(30.0);
        expResult = 30.0;
        result = instance.getBookPrice();
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of getSelect and setSelect methods, of class book.
     */
    @Test
    public void testGetAndSetSelect() {
        System.out.println("getSelect and setSelect");
        Book instance = new Book("Sample Book", 20.0);
        CheckBox checkBox = new CheckBox();
        CheckBox expResult = checkBox;
        CheckBox result = instance.getSelect();
        assertEquals(expResult, result);
        instance.setSelect(checkBox);
        expResult = checkBox;
        result = instance.getSelect();
        assertEquals(expResult, result);
    }
}
