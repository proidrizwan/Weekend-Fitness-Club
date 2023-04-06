
package weekendfitnessclub;

import java.io.*;
import java.util.Scanner;

/**
 * This class is responsible
 * for all the user interactions.
 */
public class Application {
    /**
     * Scanner object to take input
     */
    private Scanner keyBoard;

    /**
     * Weekend Object to operate
     * the whole program.
     */
    private Weekends weekends;

    /**
     * Application constructor
     * initializes the instance
     * variables.
     */
    public Application() {
        keyBoard = new Scanner(System.in);
        readObject();
    }

    /**
     * This method reads
     * data from file.
     */
    public void readObject() {
        try {
            //Creating stream to read the object
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.txt"));
            weekends = (Weekends) in.readObject();
            //closing the stream
            in.close();
        } catch (Exception e) {
            // When the file is empty
            // it auto generates data.
            weekends = new Weekends();
            weekends.setLessons();
            weekends.setDays();
        }
    }

    /**
     * This method takes
     * input from the user.
     *
     * @return user input
     */


    /**
     * This method shows
     * the menu to the user.
     */
    public void showMenu() {
        System.out.println("\nPlease select your choice from these options");
        System.out.println("[Enter 1] Add Customer");
        System.out.println("[Enter 2] Show All Customers");
        System.out.println("[Enter 3] Book Lesson");
        System.out.println("[Enter 4] Change Booking");
        System.out.println("[Enter 5] Cancel Booking");
        System.out.println("[Enter 6] Add Review and Rating");
        System.out.println("[Enter 7] Report 1: Number of Customers per day with Average Rating");
        System.out.println("[Enter 8] Report 2: Fitness Lessons that generated Highest Income");
        System.out.println("[Enter 9] Exit");
        System.out.print("\nYour choice (1-9): ");
    }

    /**
     * This method adds
     * customer to the program.
     */
    public void addCustomer() {
        System.out.print("\nEnter Customer Name : ");
        String name = keyBoard.nextLine().trim();

        if (weekends.isCustomerExists(name)) {
            System.out.println("\nError!!! Customer Name Already Exists!!!");
            return;
        }

        System.out.print("Enter Customer Address : ");
        String address = keyBoard.nextLine();

        System.out.print("Enter Customer Mobile Number : ");
        String mobile = keyBoard.nextLine();

        weekends.addCustomer(new Customer(name, address, mobile));
        System.out.println("\nCustomer " + name + " added successfully.");
    }

    /**
     * This method shows
     * a list of customers
     */
    public void showCustomer() {
        weekends.showAllCustomers();
    }

    /**
     * This method helps user
     * to select a customer
     * and then returns the
     * customer object.
     *
     * @return Customer Object
     */
    public Customer selectCustomer() {
        if (weekends.customerCount() == 0) {
            System.out.println("\nNo Customer Exists!!! Please Add First!!!");
            return null;
        }

        System.out.println();
        weekends.showAllCustomers();

        System.out.print("\nEnter Customer Serial No : ");
        int sl = takeInput();

        // Loop executes until valid option is provided
        while (sl < 1 || sl > weekends.customerCount()) {
            System.out.print("\nError!!! Invalid Serial No!!! Please Try Again: ");
            sl = takeInput();
        }

        return weekends.getCustomer(sl - 1);
    }

    /**
     * This method is responsible
     * for add a review.
     */
    public void addReview() {
        Customer customer = selectCustomer();

        if (customer == null) {
            return;
        }

        if (customer.getLessons().size() == 0) {
            System.out.println("\nNo Lesson Exists!!! Please Book First!!!");
            return;
        }

        weekends.showLesson(customer);

        System.out.print("\nEnter Week No: ");
        int week = takeInput();

        while (week < 0 || week > weekends.getNumberOfWeeks()) {
            System.out.print("\nError!!! Invalid Number of Weeks!!! Please Try Again: ");
            week = takeInput();
        }

        System.out.println("\nPlease select Day");
        System.out.println("[Enter 1] Saturday");
        System.out.println("[Enter 2] Sunday");
        System.out.print("\nYour choice (1-2): ");

        int day = takeInput();

        while (day < 1 || day > 2) {
            System.out.print("\nError!!! Invalid Option!!! Please Try Again: ");
            day = takeInput();
        }

        System.out.print("\nPlease Select Lesson No\n");
        System.out.println("[Enter 1] Lesson One");
        System.out.println("[Enter 2] Lesson Two");
        System.out.print("\nYour choice (1-2): ");

        int lesson = takeInput();

        while (lesson < 1 || lesson > 2) {
            System.out.print("\nError!!! Invalid Option!!! Please Try Again: ");
            lesson = takeInput();
        }

        System.out.print("\nEnter fitness type : ");
        String fitnessType = keyBoard.nextLine();

        System.out.print("\nEnter Rating (1-5): ");

        int rating = takeInput();

        while (rating < 1 || rating > 5) {
            System.out.print("\nError!!! Invalid Rating!!! Please Try Again: ");
            rating = takeInput();
        }

        System.out.print("\nEnter Review : ");
        String review = keyBoard.nextLine();

        while (review.isEmpty()) {
            System.out.print("\nError!!! Review Can Not be Empty!!! Please Try Again: ");
            review = keyBoard.nextLine();
        }

        weekends.addReview(week, day, lesson, fitnessType, rating, review, customer);
    }

    /**
     * This method prints
     * the report 1.
     */
    public void report1() {
        weekends.report1();
    }

    /**
     * This method prints
     * the report 2.
     */
    public void report2() {
        weekends.report2();
    }

    /**
     * This method saves
     * the data to file and
     * stops the program.
     */
    public void saveAndExit() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.txt"));
            out.writeObject(weekends);
            out.close();
        } catch (IOException i) {
            System.out.println("File Not Found!");
        }
        System.out.println("\nThanks for using Weekend Fitness Club Application!!!");
        System.exit(0);
    }

    public Scanner getKeyBoard() {
        return keyBoard;
    }

    public Weekends getWeekends() {
        return weekends;
    }

    /**
     * This is the main
     * method of the program.
     *
     * @param args Command Line Arguments
     */
    public static void main(String[] args) {
        Application app = new Application();
        System.out.println("*** Welcome to Weekend Fitness Club (WFC) Application ***");

        // Performing while loop
        // until user wants to stop.
        while (true) {
            app.showMenu();
            int choice = app.takeInput();

            switch (choice) {
                case 1:
                    app.addCustomer();
                    break;
                case 2:
                    app.showCustomer();
                    break;
                case 3:
                    Booking.bookLesson(app);
                    break;
                case 4:
                    Booking.changeBooking(app);
                    break;
                case 5:
                    Booking.cancelBooking(app);
                    break;
                case 6:
                    app.addReview();
                    break;
                case 7:
                    app.report1();
                    break;
                case 8:
                    app.report2();
                    break;
                case 9:
                    app.saveAndExit();
                default:
                    System.out.println("\nOption not Valid!!! Please Try Again");
            }
        }
    }
}
