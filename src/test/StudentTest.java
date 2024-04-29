package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import role.Student;
import Course.Course;

public class StudentTest {
    private Student student;
    private ArrayList<Student> studentList;
    private ArrayList<Course> coursesList;
    
    @BeforeEach
    void setUp() {
        // initial course and student
        student = new Student(1, "Ab Cd", "abcd", "password590");
        studentList = new ArrayList<>();
        coursesList = new ArrayList<>();
        // add a new course called CIS571
        coursesList.add(new Course("CIS571", "Computer Organization and Design", "Joseph L Devietti", "TR", "12:00", "13:30", 170));
        studentList.add(student);
    }

    @Test
    void testStudentLogin() {
        // login test
        Student loggedInStudent = student.studentLogin("abcd", "password590", studentList);
        assertNotNull(loggedInStudent);
        assertEquals("Ab Cd", loggedInStudent.getName());
    }

    @Test
    void testAddStudentCourse() {
        //add course test
        student.addStudentCourse(coursesList, "CIS571");
        assertFalse(student.getCourseList().isEmpty());
        assertEquals(1, student.getCourseList().size());
    }

    @Test
    void testViewEnrolledCourses() {
        // test enrolled courses
        student.addStudentCourse(coursesList, "CIS571");
        String expectedInfo = "CIS571|Course Name: Computer Organization and Design,12:00-13:30 on TR, with course capacity: 169, students: 1, lecturer: Joseph L Devietti";
        assertEquals(expectedInfo, student.getCourseList().get(0).printCourseInfo());
    }

    @Test
    void testDropCourse() {
        // drop course test
        student.addStudentCourse(coursesList, "Computer Science");
        student.dropCourse("Computer Science");
        assertTrue(student.getCourseList().isEmpty());
    }

    @Test
    void testViewGrades() {
        // view grades test
        student.addStudentCourse(coursesList, "CIS571");
        student.getCourseList().get(0).setGrade("A");
    }
}
