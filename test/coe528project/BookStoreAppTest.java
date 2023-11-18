package coe528project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests for the BookStoreApp class.
 * 
 * @author Ali Usmani
 */
public class BookStoreAppTest {

    public BookStoreAppTest() {
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
     * Test of totalCost method, of class BookStoreApp.
     */
    @Test
    public void testTotalCost() {
        System.out.println("totalCost");
        // Create sample books
        Book book1 = new Book("Book1", 25.0);
        Book book2 = new Book("Book2", 30.0);
        List<Book> selectedBooks = new ArrayList<>();
        selectedBooks.add(book1);
        selectedBooks.add(book2);
        BookStoreApp instance = new BookStoreApp(selectedBooks, false);
        double expResult = 55.0;
        double result = instance.totalCost();
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of totalCost method with redemption, of class BookStoreApp.
     */
    @Test
    public void testTotalCostWithRedemption() {
        System.out.println("totalCost with redemption");
        Book book1 = new Book("Book1", 25.0);
        Book book2 = new Book("Book2", 30.0);
        List<Book> selectedBooks = new ArrayList<>();
        selectedBooks.add(book1);
        selectedBooks.add(book2);
        BookStoreApp instance = new BookStoreApp(selectedBooks, true);
        double expResult = 0.0;
        double result = instance.totalCost();
        assertEquals(expResult, result, 0.001);
    }
}
