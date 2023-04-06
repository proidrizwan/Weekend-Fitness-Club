
package weekendfitnessclub;


import java.io.Serializable;

/**
 * This class contains
 * both customer and rating.
 */
public class CustomerRating implements Serializable {
    // Private data members
    private Customer customer;
    private int rating;
    private String review;

    /**
     * Customer Rating constructor
     * sets the customer.
     *
     * @param customer Customer Object
     */
    public CustomerRating(Customer customer) {
        this.customer = customer;
    }

    /**
     * This method sets
     * the user review.
     *
     * @param review User Review
     */
    public void setReview(String review) {
        this.review = review;
    }

    /**
     * This method sets
     * the user rating.
     *
     * @param rating User Rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * This method gets
     * the customer object
     *
     * @return Customer Object
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * This method gets
     * the customer rating.
     *
     * @return Customer Rating.
     */
    public int getRating() {
        return rating;
    }
}
