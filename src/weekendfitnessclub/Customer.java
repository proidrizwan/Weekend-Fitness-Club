import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Customer class represents
 * all the customer features.
 */
public class Customer implements Serializable {
    // Private data members
    private String name;
    private String address;
    private String phoneNumber;
    private List<Lesson> lessons;

    /**
     * Customer constructor
     * sets all the values.
     *
     * @param name          Customer Name
     * @param address       Customer Address
     * @param phoneNumber   Customer Mobile Number
     */
    public Customer(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        lessons = new ArrayList<>();
    }

    /**
     * This method adds a
     * lesson.
     *
     * @param lesson    Lesson Object
     */
    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    /**
     * This method cancels a lesson.
     *
     * @param lesson    Lesson object
     */
    public void cancelLesson(Lesson lesson) {
        lessons.remove(lesson);
    }

    /**
     * This method gets
     * name of the customer.
     *
     * @return Customer Name
     */
    public String getName() {
        return name;
    }

    /**
     * This method gets
     * customer address.
     *
     * @return  Customer Address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method gets
     * customer phone number.
     *
     * @return phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * This method gets
     * customer lessons.
     *
     * @return Customer Lesson.
     */
    public List<Lesson> getLessons() {
        return lessons;
    }

    /**
     * This method gets
     * a specific lesson
     * at index i.
     *
     * @param i Index
     * @return Lesson at index i
     */
    public Lesson getLesson(int i) {
        return lessons.get(i);
    }

    /**
     * This method shows
     * customer information
     * in a readable format.
     *
     * @return String representation
     */
    @Override
    public String toString() {
        return String.format("%-15s | %-25s | %-15s | %-17s", getName(), getAddress(), getPhoneNumber(), lessons.size());
    }
}
