/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package weekendfitnessclub;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sc
 */
public class CustomerTest {
     // Test data
    private final String name = "John Smith";
    private final String address = "123 Main St, Anytown UK";
    private final String phoneNumber = "555-1234";
    
    @Test
    public void testConstructor() {
        Customer customer = new Customer(name, address, phoneNumber);
        assertNotNull(customer);
        assertEquals(name, customer.getName());
        assertEquals(address, customer.getAddress());
        assertEquals(phoneNumber, customer.getPhoneNumber());
    }

    @Test
    public void testSetName() {
        Customer customer = new Customer(name, address, phoneNumber);
        String newName = "Jane Doe";
        customer.setName(newName);
        assertEquals(newName, customer.getName());
    }

    @Test
    public void testSetAddress() {
        Customer customer = new Customer(name, address, phoneNumber);
        String newAddress = "456 Maple Ave, Anytown USA";
        customer.setAddress(newAddress);
        assertEquals(newAddress, customer.getAddress());
    }

    @Test
    public void testSetPhoneNumber() {
        Customer customer = new Customer(name, address, phoneNumber);
        String newPhoneNumber = "555-5678";
        customer.setPhoneNumber(newPhoneNumber);
        assertEquals(newPhoneNumber, customer.getPhoneNumber());
    }
    
}
