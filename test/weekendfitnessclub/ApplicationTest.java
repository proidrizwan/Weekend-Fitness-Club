
package weekendfitnessclub;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


import static org.junit.Assert.*;

public class ApplicationTest {
    private Lesson lesson;
    private Customer customer;
    private Weekends weekends;

    @Before
    public void setUp() {
        weekends = new Weekends();
        customer = new Customer("John", "UK", "91827536152");
        lesson = new Lesson("SPIN", 500);
    }

    @Test
    public void addCustomerToLessonTest() {
        assertTrue(lesson.addCustomer(customer));
    }

    @Test
    public void addCustomerToSameLessonTest() {
        lesson.addCustomer(customer);
        assertFalse(lesson.addCustomer(customer));
    }
    @Test
    public void isCustomerExistsTest() {
       
        weekends.addCustomer(customer);
        // assertEquals(1, weekends.customerCount());
        assertTrue(weekends.isCustomerExists("John"));
    }
    
    @Test
    public void addMoreThanFiveCustomerToLessonTest() {
        lesson.addCustomer(new Customer("John1", "UK", "1111111111"));
        lesson.addCustomer(new Customer("John2", "UK", "2222222222"));
        lesson.addCustomer(new Customer("John3", "UK", "3333333333"));
        lesson.addCustomer(new Customer("John4", "UK", "4444444444"));
        lesson.addCustomer(new Customer("John5", "UK", "5555555555"));
        assertFalse(lesson.addCustomer(customer));
    }

    @Test
    public void removeCustomerFromLessonTest() {
        lesson.addCustomer(new Customer("John1", "UK", "1111111111"));
        lesson.addCustomer(new Customer("John2", "UK", "2222222222"));
        lesson.addCustomer(new Customer("John3", "UK", "3333333333"));
        lesson.addCustomer(customer);
        lesson.removeCustomer(customer);
        assertEquals(3, lesson.getNumberOfCustomers());
    }

    @Test
    public void lessonContainsCustomerTest() {
        lesson.addCustomer(customer);
        assertTrue(lesson.contains(customer));
    }

    @Test
    public void addCustomerToListTest() {
        weekends.addCustomer(customer);
        assertEquals(1, weekends.customerCount());
    }

    @Test
    public void weekendsContainsCustomerTest() {
        weekends.addCustomer(customer);
        assertTrue(weekends.isCustomerExists(customer.getName()));
    }

    @Test
    public void weekendsGetRandomLessonTest() {
        weekends.setLessons();
        assertNotNull(weekends.getRandomLesson());
    }

    @Test
    public void weekendsGetLessonBySpecificDataTest() {
        weekends.setLessons();
        weekends.setDays();
        int weekNo = 1;
        int dayNo = 1;
        int lessonNo = 1;
        assertNotNull(weekends.getLesson(weekNo, dayNo, lessonNo));
    }

    @Test
    public void bookLessonForCustomerByDayTest() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\n1\n1\n1\n".getBytes());
        System.setIn(in);

        assertTrue(Booking.bookingFeatures(new Application(), customer));

        System.setIn(sysInBackup);
    }

    @Test
    public void bookLessonForCustomerByTypeTest() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("2\nYOGA\n1\n1\n1\n".getBytes());
        System.setIn(in);

        boolean result = Booking.bookingFeatures(new Application(), customer);

        if (result) {
            assertTrue(result);
        } else {
            assertFalse(result);
        }

        System.setIn(sysInBackup);
    }

    @Test
    public void changeBookingTest() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("John1\nUK\n1111111111\n1\n1\n1\n1\n1\n1\n1\n1\n1\nSPIN\n".getBytes());
        System.setIn(in);

        try {
            Application app = new Application();
            app.addCustomer();
            Booking.bookLesson(app);

            boolean result = Booking.changeBooking(app);

            if (result) {
                assertTrue(result);
            } else {
                assertFalse(result);
            }
        } catch (Exception e) {
        }

        System.setIn(sysInBackup);
    }

    @Test
    public void cancelLessonTest() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("John1\nUK\n1111111111\n1\n1\n1\n1\n1\n1\n1\n1\n1\nSPIN\n".getBytes());
        System.setIn(in);

        try {
            Application app = new Application();
            app.addCustomer();
            Booking.bookLesson(app);

            boolean result = Booking.cancelBooking(app);

            if (result) {
                assertTrue(result);
            } else {
                assertFalse(result);
            }
        } catch (Exception e) {
            fail();
        }

        System.setIn(sysInBackup);
    }
}
