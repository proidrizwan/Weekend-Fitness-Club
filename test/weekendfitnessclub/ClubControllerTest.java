/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package weekendfitnessclub;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sc
 */
public class ClubControllerTest {
    
   private Weekends weekends;
    
    @Before
    public void setUp() {
        weekends = new Weekends();
    }
    
    @Test
    public void testAddCustomer() {
        Customer customer = new Customer("John Doe", "123 Main St UK", "555-1234");
        weekends.addCustomer(customer);
       // assertEquals(1, weekends.customerCount());
        assertTrue(weekends.isCustomerExists("John Doe"));
    }
    
     @Test
    public void testShowAllCustomers() {
        Customer customer1 = new Customer("John Doe", "123 Main St", "555-1234");
        Customer customer2 = new Customer("Jane Smith", "456 Elm St", "555-5678");
        weekends.addCustomer(customer1);
        weekends.addCustomer(customer2);
        weekends.showAllCustomers();
        // Check the output manually
    }
}
