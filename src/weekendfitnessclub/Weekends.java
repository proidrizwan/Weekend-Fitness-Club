import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This method is responsible
 * to perform all operations
 * asked by the main program.
 */
public class Weekends implements Serializable {
    // Private data members
    private List<Day> days;
    private List<Lesson> lessons;
    private List<Customer> customers;
    private Random random;

    /**
     * Weekends constructor
     * initializes all the objects.
     */
    public Weekends() {
        random = new Random();
        days = new ArrayList<>();
        lessons = new ArrayList<>();
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
        if (customers.isEmpty()) {
            System.out.println("\nNo Customers to show.");
            return;
        }
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

    /**
     * This method sets
     * the lessons.
     */
    public void setLessons() {
        lessons.add(new Lesson("SPIN", 100));
        lessons.add(new Lesson("YOGA", 300));
        lessons.add(new Lesson("BACK SQUAT", 200));
        lessons.add(new Lesson("POWER BUILDING", 700));
        lessons.add(new Lesson("STRETCHING", 350));
        lessons.add(new Lesson("AEROBIC", 650));
        lessons.add(new Lesson("BODY SCULPT", 200));
        lessons.add(new Lesson("ZUMBA", 400));
    }

    /**
     * This method gets
     * a random lesson
     * from the lesson list.
     *
     * @return Random Lesson
     */
    public Lesson getRandomLesson() {

        Lesson lesson = lessons.get(random.nextInt(lessons.size()));

        return new Lesson(lesson.getType(), lesson.getPrice());
    }

    /**
     * This method sets
     * 8 weeks and with
     * each week contains
     * 2 days.
     */
    public void setDays() {
        for (int i = 0; i < 8; i++) {
            days.add(new Day("Saturday", getRandomLesson(), getRandomLesson()));
            days.add(new Day("Sunday", getRandomLesson(), getRandomLesson()));
        }
    }

    /**
     * This method shows
     * all information of
     * a given day by the user.
     *
     * @param userDay Day provided by user
     */
    public void showDays(String userDay) {
        System.out.println();
        print(68);
        System.out.printf("%-27s %-18s %21s\n", "|", "Day : " + userDay, "|");
        print(68);
        System.out.printf("| %-5s | %-15s | %-20s | %-15s |\n", "Week", "Lesson No", "Fitness Type", "Lesson Price");
        print(68);

        for (int i = 0; i < days.size(); i++) {
            Day day = days.get(i);

            // Checking if the
            // day matches with
            // the user given value

            if (day.getDayName().equalsIgnoreCase(userDay)) {
                System.out.printf("| %-5s | %-15s | %-20s | %-15s |\n", (i / 2) + 1, "Lesson One",
                        day.getLessonOne().getType(),
                        day.getLessonOne().getPrice());

                System.out.printf("| %-5s | %-15s | %-20s | %-15s |\n", (i / 2) + 1, "Lesson Two",
                        day.getLessonTwo().getType(),
                        day.getLessonTwo().getPrice());
            }
        }
        print(68);
    }

    /**
     * This method shows
     * all information of a
     * given lesson.
     *
     * @param userLesson Lesson
     */
    public void showLesson(String userLesson) {
        System.out.println();
        print(68);
        System.out.printf("%-27s %-18s %21s\n", "|", "Lesson : " + userLesson, "|");
        print(68);
        System.out.printf("| %-5s | %-15s | %-20s | %-15s |\n", "Week", "Day", "Lesson No", "Lesson Price");
        print(68);

        for (int i = 0; i < days.size(); i++) {
            Day day = days.get(i);

            // finding the day name
            String dayName = "Saturday";

            if ((i % 2) != 0) {
                dayName = "Sunday";
            }

            // Checking if it is the first lesson or second
            if (day.getLessonOne().getType().equalsIgnoreCase(userLesson)) {
                System.out.printf("| %-5s | %-15s | %-20s | %-15s |\n", (i / 2) + 1, dayName,
                        "Lesson One",
                        day.getLessonOne().getPrice());
            } else if (day.getLessonTwo().getType().equalsIgnoreCase(userLesson)) {
                System.out.printf("| %-5s | %-15s | %-20s | %-15s |\n", (i / 2) + 1, dayName,
                        "Lesson Two",
                        day.getLessonTwo().getPrice());
            }
        }
        print(68);
    }

    /**
     * This method shows
     * all available lessons.
     */
    public void showAvailableLessons() {
        // List to store lessons
        List<String> lessons = new ArrayList<>();

        // Iterating each day.
        for (Day day : days) {
            // Setting for the first lesson
            String lessonOne = day.getLessonOne().getType();
            if (matches(lessonOne) && !lessons.contains(lessonOne)) {
                lessons.add(lessonOne);
            }

            // Setting for the second lessson
            String lessonTwo = day.getLessonTwo().getType();
            if (matches(lessonTwo) && !lessons.contains(lessonTwo)) {
                lessons.add(lessonTwo);
            }
        }

        // Printing information
        System.out.print("\nAvailable Lessons are ");
        for (int i = 0; i < lessons.size() - 1; i++) {
            System.out.print(lessons.get(i) + ", ");
        }
        System.out.println(lessons.get(lessons.size() - 1));
    }

    /**
     * This method checks
     * if the given lesson
     * is valid or not.
     *
     * @param userLesson User Lesson
     * @return boolean value true if matches, false otherwise
     */
    public boolean matches(String userLesson) {
        for (Lesson lesson : lessons) {
            if (lesson.getType().equalsIgnoreCase(userLesson)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method gets
     * the number of weeks.
     *
     * @return Number of Weeks
     */
    public int getNumberOfWeeks() {
        return days.size() / 2;
    }

    /**
     * This method gets
     * a lesson that matches
     * this information.
     *
     * @param week      Number of Week
     * @param day       Number of Day
     * @param lesson    Number of Lesson
     * @return Lesson object.
     */
    public Lesson getLesson(int week, int day, int lesson) {
        Lesson targetLesson;
        if (day == 1) {
            if (lesson == 1) {
                targetLesson = days.get((week * 2) - 2).getLessonOne();
            } else {
                targetLesson = days.get((week * 2) - 2).getLessonTwo();
            }
        } else {
            if (lesson == 1) {
                targetLesson = days.get((week * 2) - 1).getLessonOne();
            } else {
                targetLesson = days.get((week * 2) - 1).getLessonTwo();
            }
        }
        return targetLesson;
    }

    /**
     * This method removes
     * a customer.
     *
     * @param week          Number of Week
     * @param day           Number of Day
     * @param lesson        Number of Lesson
     * @param lessonType    Number of Lesson Type
     * @param customer      Customer Object
     */
    public boolean removeCustomer(int week, int day, int lesson, String lessonType, Customer customer) {
        Lesson targetLesson = getLesson(week, day, lesson);

        if (!lessonType.isEmpty() && !targetLesson.getType().equalsIgnoreCase(lessonType)) {
            System.out.println("\nMismatched Information Provided!!! Please Try Again");
            return false;
        }

        if (!targetLesson.contains(customer)) {
            System.out.println("\nCustomer " + customer.getName() + " has not booked this lesson.");
            return false;
        }

        targetLesson.removeCustomer(customer);
        customer.cancelLesson(targetLesson);

        System.out.println("\nPrevious Lesson Type: " + lessonType + " cancelled successfully.");
        return true;
    }

    /**
     * This method shows
     * all lesson information
     * of a customer.
     *
     * @param customer Customer Object
     */
    public void showLesson(Customer customer) {
        System.out.println();
        print(86);
        System.out.printf("%-23s %-40s %21s\n", "|", "Customer Name : " + customer.getName(), "|");
        print(86);
        System.out.printf("| %-5s | %-15s | %-20s | %-15s | %-15s |\n", "Week", "Day", "Lesson No", "Fitness Type", "Lesson Price");
        print(86);

        for (int i = 0; i < days.size(); i++) {
            Day day = days.get(i);
            if (day.getLessonOne().contains(customer)) {
                System.out.printf("| %-5s | %-15s | %-20s | %-15s | %-15s |\n", (i / 2) + 1, day.getDayName(), "Lesson One",
                        day.getLessonOne().getType(),
                        day.getLessonOne().getPrice());
            } else if (day.getLessonTwo().contains(customer)) {
                System.out.printf("| %-5s | %-15s | %-20s | %-15s | %-15s |\n", (i / 2) + 1, day.getDayName(), "Lesson Two",
                        day.getLessonTwo().getType(),
                        day.getLessonTwo().getPrice());
            }
        }
        print(86);
    }

 


}
