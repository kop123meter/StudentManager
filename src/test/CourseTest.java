package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import Course.Course;
import role.Student;

public class CourseTest {
    private Course course;
    private ArrayList<Course> coursesList;

    @BeforeEach
    void setUp() {
        course = new Course("CS101", "Intro to Computer Science", "Dr. Alice", "MWF", "10:00", "11:00", 30);
        coursesList = new ArrayList<>();
        coursesList.add(course);
    }

    @Test
    void testCourseProperties() {
        assertEquals("CS101", course.getCourseID());
        assertEquals("Intro to Computer Science", course.getCourseName());
        assertEquals("MWF", course.getCourseDay());
        assertEquals("10:00", course.getCourseStartTime());
        assertEquals("11:00", course.getCourseEndTime());
        assertEquals(30, course.getCourseCapacity());
    }


    @Test
    void testCheckCourseInList() {
        Course foundCourse = course.checkCourseInList("CS101", coursesList);
        assertNotNull(foundCourse);
        assertEquals("CS101", foundCourse.getCourseID());
    }

    @Test
    void testTimeConflictDetection() {
        Course conflictingCourse = new Course("MA102", "Mathematics 102", "Dr. Bob", "MWF", "10:30", "11:30", 25);
        coursesList.add(conflictingCourse);
        Course result = course.checkTimeConflict(conflictingCourse, coursesList);
        assertNotNull(result);
        assertEquals("CS101", result.getCourseID());
    }

    @Test
    void testPrintCourseInfo() {
        String expectedInfo = "CS101|Course Name: Intro to Computer Science,10:00-11:00 on MWF, with course capacity: 30, students: 0, lecturer: Dr. Alice";
        assertEquals(expectedInfo, course.printCourseInfo());
    }

}
