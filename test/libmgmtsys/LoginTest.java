package libmgmtsys;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for the Login class.
 * 
 * @author Ali Usmani
 */
public class LoginTest {

    public LoginTest() {
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
     * Test of IsOwner method, of class Login.
     */
    @Test
    public void testIsOwner() {
        System.out.println("IsOwner");
        Login instance = new Login();
        boolean result = instance.IsOwner("admin", "admin");
        assertTrue(result);
    }

    /**
     * Test of IsCustomer method, of class Login.
     */
    @Test
    public void testIsCustomer() {
        System.out.println("IsCustomer");
        Login instance = new Login();
        Customer customer = new Customer("JohnDoe", "password", 100);
        Customers.getInstance().addCustomer(customer);
        boolean result = instance.IsCustomer("JohnDoe", "password");
        assertTrue(result);
    }
}
