import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents
 * a lesson.
 */
public class Lesson implements Serializable {
    // Private Data Members
    private String type;
    private double price;
    private List<CustomerRating> customers;

    /**
     * Lesson constructor
     * sets the variables.
     *
     * @param type      Type of the lesson
     * @param price     Price of the lesson
     */
    public Lesson(String type, double price) {
        this.type = type;
        this.price = price;
        customers = new ArrayList<>();
    }

    /**
     * This method adds a customer
     * to the customer list.
     *
     * @param customer Customer Object
     * @return boolean value true if customer added, false otherwise.
     */
    public boolean addCustomer(Customer customer) {
        if (customers.size() != 5 && !contains(customer)) {
            customers.add(new CustomerRating(customer));
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method removes
     * a customer from the list.
     *
     * @param userCustomer Customer Object
     */
    public void removeCustomer(Customer userCustomer) {
        int index = 0;
        while (index < customers.size()){
            if (customers.get(index).getCustomer().equals(userCustomer)) {
                break;
            }
            index++;
        }
        customers.remove(index);
    }

  

    /**
     * This method checks
     * the customer is in
     * the list or not.
     *
     * @param userCustomer Customer Object
     * @return boolean value true if contains, false otherwise.
     */
    public boolean contains(Customer userCustomer) {
        for (CustomerRating customer : customers) {
            if (customer.getCustomer().equals(userCustomer)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method checks
     * if the lesson is
     * full of customer
     * or not.
     *
     * @return boolean value true if full, false otherwise
     */
    public boolean isFull() {
        return customers.size() == 5;
    }

    /**
     * This method gets
     * the type of the lesson.
     *
     * @return Lesson Type
     */
    public String getType() {
        return type;
    }

    /**
     * This method gets
     * the number of customers.
     *
     * @return Number of Customers
     */
    public int getNumberOfCustomers() {
        return customers.size();
    }

    /**
     * This method gets
     * the price of the lesson.
     *
     * @return Lesson Price
     */
    public double getPrice() {
        return price;
    }

  
}
