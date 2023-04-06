package weekendfitnessclub;
/**
 * This class is deals all the booking related tasks.
 */
public class Booking {

    /**
     * This method books a lesson
     */
    public static void bookLesson(Application app) {
        Customer customer = app.selectCustomer();

        if (customer == null) {
            return;
        }

        bookingFeatures(app, customer);
    }

    /**
     * This method provides booking
     * features.
     *
     * @param customer Customer Object
     * @return boolean value true if booked successfully, false otherwise
     */
    public static boolean bookingFeatures(Application app, Customer customer) {
        Weekends weekends = app.getWeekends();

        System.out.println("\nPlease select booking options");
        System.out.println("[Enter 1] Show Lesson By Day");
        System.out.println("[Enter 2] Show Lesson By Type");
        System.out.print("\nYour choice (1-2): ");

        int choice = app.takeInput();

        while (choice < 1 || choice > 2) {
            System.out.print("\nError!!! Invalid Option!!! Please Try Again: ");
            choice = app.takeInput();
        }

        if (choice == 1) {
            System.out.println("\nPlease select Day");
            System.out.println("[Enter 1] Saturday");
            System.out.println("[Enter 2] Sunday");
            System.out.print("\nYour choice (1-2): ");

            int day = app.takeInput();

            while (day < 1 || day > 2) {
                System.out.print("\nError!!! Invalid Option!!! Please Try Again: ");
                day = app.takeInput();
            }

            if (day == 1) {
                weekends.showDays("Saturday");
            } else {
                weekends.showDays("Sunday");
            }

            System.out.print("\nEnter Week No: ");
            int week = app.takeInput();

            while (week < 0 || week > weekends.getNumberOfWeeks()) {
                System.out.print("\nError!!! Invalid Number of Weeks!!! Please Try Again: ");
                week = app.takeInput();
            }

            System.out.print("\nPlease Select Lesson No\n");
            System.out.println("[Enter 1] Lesson One");
            System.out.println("[Enter 2] Lesson Two");
            System.out.print("\nYour choice (1-2): ");

            int lesson = app.takeInput();

            while (lesson < 1 || lesson > 2) {
                System.out.print("\nError!!! Invalid Option!!! Please Try Again: ");
                lesson = app.takeInput();
            }

            return bookCustomer(week, day, lesson, "", customer, weekends);
        } else {
            weekends.showAvailableLessons();
            System.out.print("\nEnter fitness type : ");
            String fitnessType = app.getKeyBoard().nextLine();
            weekends.showLesson(fitnessType);

            System.out.print("\nEnter Week No: ");
            int week = app.takeInput();

            while (week < 0 || week > weekends.getNumberOfWeeks()) {
                System.out.print("\nError!!! Invalid Number of Weeks!!! Please Try Again: ");
                week = app.takeInput();
            }

            System.out.println("\nPlease select Day");
            System.out.println("[Enter 1] Saturday");
            System.out.println("[Enter 2] Sunday");
            System.out.print("\nYour choice (1-2): ");

            int day = app.takeInput();

            while (day < 1 || day > 2) {
                System.out.print("\nError!!! Invalid Option!!! Please Try Again: ");
                day = app.takeInput();
            }

            System.out.print("\nPlease Select Lesson No\n");
            System.out.println("[Enter 1] Lesson One");
            System.out.println("[Enter 2] Lesson Two");
            System.out.print("\nYour choice (1-2): ");

            int lesson = app.takeInput();

            while (lesson < 1 || lesson > 2) {
                System.out.print("\nError!!! Invalid Option!!! Please Try Again: ");
                lesson = app.takeInput();
            }

            return bookCustomer(week, day, lesson, fitnessType, customer, weekends);
        }
    }

    /**
     * This method is responsible
     * for change an existing booking.
     */
    public static boolean changeBooking(Application app) {
        Weekends weekends = app.getWeekends();

        Customer customer = app.selectCustomer();

        if (customer == null) {
            return false;
        }

        if (customer.getLessons().size() == 0) {
            System.out.println("\nNo Lesson Exists!!! Please Book First!!!");
            return false;
        }

        weekends.showLesson(customer);

        System.out.print("\nEnter Week No: ");
        int week = app.takeInput();

        while (week < 0 || week > weekends.getNumberOfWeeks()) {
            System.out.print("\nError!!! Invalid Number of Weeks!!! Please Try Again: ");
            week = app.takeInput();
        }

        System.out.println("\nPlease select Day");
        System.out.println("[Enter 1] Saturday");
        System.out.println("[Enter 2] Sunday");
        System.out.print("\nYour choice (1-2): ");

        int day = app.takeInput();

        while (day < 1 || day > 2) {
            System.out.print("\nError!!! Invalid Option!!! Please Try Again: ");
            day = app.takeInput();
        }

        System.out.print("\nPlease Select Lesson No\n");
        System.out.println("[Enter 1] Lesson One");
        System.out.println("[Enter 2] Lesson Two");
        System.out.print("\nYour choice (1-2): ");

        int lesson = app.takeInput();

        while (lesson < 1 || lesson > 2) {
            System.out.print("\nError!!! Invalid Option!!! Please Try Again: ");
            lesson = app.takeInput();
        }

        System.out.print("\nEnter fitness type : ");
        String fitnessType = app.getKeyBoard().nextLine();

        Lesson targetLesson = weekends.getLesson(week, day, lesson);

        if (!targetLesson.getType().equalsIgnoreCase(fitnessType)) {
            System.out.println("\nMismatched Information Provided!!! Please Try Again");
            return false;
        }

        if (!targetLesson.contains(customer)) {
            System.out.println("\nCustomer " + customer.getName() + " has not booked this lesson.");
            return false;
        }

        System.out.println("\nFitness Type : " + fitnessType + " is selected to change.\n\nPlease Add a new Booking");

        if (bookingFeatures(app, customer)) {
            return weekends.removeCustomer(week, day, lesson, fitnessType, customer);
        } else {
            System.out.println("\nFitness Type :" + fitnessType + " can Not be changed.");
            return false;
        }
    }

    /**
     * This method is responsible
     * for cancel an existing booking.
     */
    public static boolean cancelBooking(Application app) {
        Weekends weekends = app.getWeekends();

        Customer customer = app.selectCustomer();

        if (customer == null) {
            return false;
        }

        if (customer.getLessons().size() == 0) {
            System.out.println("\nNo Lesson Exists!!! Please Book First!!!");
            return false;
        }

        weekends.showLesson(customer);

        System.out.print("\nEnter Week No: ");
        int week = app.takeInput();

        while (week < 0 || week > weekends.getNumberOfWeeks()) {
            System.out.print("\nError!!! Invalid Number of Weeks!!! Please Try Again: ");
            week = app.takeInput();
        }

        System.out.println("\nPlease select Day");
        System.out.println("[Enter 1] Saturday");
        System.out.println("[Enter 2] Sunday");
        System.out.print("\nYour choice (1-2): ");

        int day = app.takeInput();

        while (day < 1 || day > 2) {
            System.out.print("\nError!!! Invalid Option!!! Please Try Again: ");
            day = app.takeInput();
        }

        System.out.print("\nPlease Select Lesson No\n");
        System.out.println("[Enter 1] Lesson One");
        System.out.println("[Enter 2] Lesson Two");
        System.out.print("\nYour choice (1-2): ");

        int lesson = app.takeInput();

        while (lesson < 1 || lesson > 2) {
            System.out.print("\nError!!! Invalid Option!!! Please Try Again: ");
            lesson = app.takeInput();
        }

        System.out.print("\nEnter fitness type : ");
        String fitnessType = app.getKeyBoard().nextLine();



        return weekends.removeCustomer(week, day, lesson, fitnessType, customer);
    }

    /**
     * This method books
     * a customer.
     *
     * @param week          Number of Week
     * @param day           Number of Day
     * @param lesson        Number of Lesson
     * @param lessonType    Number of Lesson Type
     * @param customer      Customer Object
     * @return boolean value true, if booked successfully, false otherwise
     */
    public static boolean bookCustomer(int week, int day, int lesson, String lessonType, Customer customer, Weekends weekends) {
        Lesson targetLesson = weekends.getLesson(week, day, lesson);

        if (!lessonType.isEmpty() && !targetLesson.getType().equalsIgnoreCase(lessonType)) {
            System.out.println("\nMismatched Information Provided!!! Please Try Again");
            return false;
        }

        if (targetLesson.addCustomer(customer)) {
            customer.addLesson(targetLesson);
            System.out.println("\nNew Lesson " + targetLesson.getType() + " Added Successfully");
            return true;
        } else {
            if (targetLesson.isFull()) {
                System.out.println("\nLesson Capacity is full!!! Customer Booking Declined");
            }

            if (targetLesson.contains(customer)) {
                System.out.println("\nCustomer " + customer.getName() + " has already booked this lesson.");
            }

            return false;
        }
    }
}
