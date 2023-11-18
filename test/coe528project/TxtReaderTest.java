package coe528project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;

/**
 * Tests for the txtreader class.
 * 
 * @author Ali Usmani
 */
public class TxtReaderTest {

    public TxtReaderTest() {
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
     * Test of readCustomer method, of class txtreader.
     */
    @Test
    public void testReadCustomer() {
        System.out.println("readCustomer");
        TxtReader instance = TxtReader.getInstance();
        File file = new File("customerRecord.txt");
        assertTrue(file.exists());
        instance.readCustomer("customerRecord.txt");
        assertFalse(Customers.getInstance().getCustomerList().isEmpty());
    }

    /**
     * Test of readBooks method, of class txtreader.
     */
    @Test
    public void testReadBooks() {
        System.out.println("readBooks");
        TxtReader instance = TxtReader.getInstance();
        File file = new File("bookRecord.txt");
        assertTrue(file.exists());
        instance.readBooks("bookRecord.txt");
        assertFalse(EditBooks.getInstance().getBookList().isEmpty());
    }
}