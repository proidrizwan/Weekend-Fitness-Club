/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package weekendfitnessclub;

/**
 *
 * @author Sc
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Sc
 */
public class Weekends implements Serializable{
    
    // Private data members
   
  
    private final List<Customer> customers;
    
     /**
     * Weekends constructor
     * initializes all the objects.
     */
    public Weekends() {
       
       
        customers = new ArrayList<>();
    }
    
      /**
     * This method adds a customer.
     *
     * @param customer Customer Object.
     */
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    
     /**
     * This method checks
     * if the customer exits,
     * or not by customer name.
     *
     * @param customerName Customer Name
     * @return boolean value true, if exists, false otherwise
     */
    public boolean isCustomerExists(String customerName) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(customerName)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * This method gets
     * the number of customers.
     *
     * @return Number of customers
     */
    public int customerCount() {
        return customers.size();
    }
    /**
     * This method shows all customers
     */
    public void showAllCustomers() {
        print(93);
        System.out.printf("%-30s %-25s %36s\n", "|", "Customer List", "|");
        print(93);
        System.out.printf("| %-5s | %-15s | %-25s | %-15s | %-10s |\n", "SL", "Name", "Address", "Phone Number", "Number of Lessons");
        print(93);
        for (int i = 0; i < customers.size(); i++) {
            System.out.printf("| %-5s | %s |\n", (i + 1), customers.get(i));
        }
        print(93);
    }
    
    /**
     * This method prints
     * '-' character for n times.
     *
     * @param n Number of '-'
     */
    public void print(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
 /**
     * This method gets
     * the customer object
     * at index i.
     *
     * @param i Index
     * @return Customer Object.
     */
    public Customer getCustomer(int i) {
        return customers.get(i);
    }
    
}
