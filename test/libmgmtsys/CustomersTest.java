package libmgmtsys;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for the Customers class.
 * 
 * @author Ali Usmani
 */
public class CustomersTest {

    public CustomersTest() {
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
     * Test of addCustomer method, of class Customers.
     */
    @Test
    public void testAddCustomer() {
        System.out.println("addCustomer");
        Customer customer = new Customer("JohnDoe", "password", 100);
        Customers instance = Customers.getInstance();
        instance.addCustomer(customer);
        int expResult = 1;
        int result = instance.getCustomerList().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteCustomer method, of class Customers.
     */
    @Test
    public void testDeleteCustomer() {
        System.out.println("deleteCustomer");
        Customer customer = new Customer("JohnDoe", "password", 100);
        Customers instance = Customers.getInstance();
        instance.addCustomer(customer);
        instance.deleteCustomer(customer);
        int expResult = 0;
        int result = instance.getCustomerList().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of checkUsername method, of class Customers.
     */
    @Test
    public void testCheckUsername() {
        System.out.println("checkUsername");
        Customers instance = Customers.getInstance();
        boolean result1 = instance.checkUsername("JohnDoe");
        assertFalse(result1);
        Customer customer = new Customer("JohnDoe", "password", 100);
        instance.addCustomer(customer);
        boolean result2 = instance.checkUsername("JohnDoe");
        assertTrue(result2);
    }
}
