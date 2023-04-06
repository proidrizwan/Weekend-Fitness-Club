
package weekendfitnessclub;

import java.io.Serializable;

/**
 * This class represents a
 * single day, either saturday or sunday.
 */
public class Day implements Serializable {
    // Private data members
    private String dayName;
    private Lesson lessonOne;
    private Lesson lessonTwo;

    /**
     * Day constructor sets
     * the variables.
     *
     * @param dayName       Day Name
     * @param lessonOne     First Lesson
     * @param lessonTwo     Second Lesson
     */
    public Day(String dayName, Lesson lessonOne, Lesson lessonTwo) {
        this.dayName = dayName;
        this.lessonOne = lessonOne;
        this.lessonTwo = lessonTwo;
    }

    /**
     * This method gets
     * the day name.
     *
     * @return Day name
     */
    public String getDayName() {
        return dayName;
    }

    /**
     * This method gets
     * the first lesson.
     *
     * @return First Lesson
     */
    public Lesson getLessonOne() {
        return lessonOne;
    }

    /**
     * This method gets
     * the second lesson.
     *
     * @return Second Lesson.
     */
    public Lesson getLessonTwo() {
        return lessonTwo;
    }

    /**
     * This method gets
     * a String representation
     * of the day.
     *
     * @return String Representation
     */
    @Override
    public String toString() {
        return "Day{" +
                "dayName='" + dayName + '\'' +
                ", lessonOne=" + lessonOne +
                ", lessonTwo=" + lessonTwo +
                '}';
    }
}
