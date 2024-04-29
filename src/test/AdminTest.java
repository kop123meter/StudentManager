package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import role.Admin;
import role.Professor;
import role.Student;
import Course.Course;

public class AdminTest {
    private Admin admin;
    private ArrayList<Course> coursesList;
    private ArrayList<Professor> professorsList;
    private ArrayList<Student> studentsList;
    private ArrayList<Admin> adminList;

    @BeforeEach
    void setUp() {
        admin = new Admin(1, "Admin Name", "adminUser", "adminPass", "admin");
        coursesList = new ArrayList<>();
        professorsList = new ArrayList<>();
        studentsList = new ArrayList<>();
        adminList = new ArrayList<>();
        
        // Adding a course, professor, and student for test cases
        coursesList.add(new Course("CS101", "Intro to Computer Science", "Dr. Alice", "MWF", "10:00", "11:00", 30));
        professorsList.add(new Professor("Dr. Alice", 101, "alice101", "password123"));
        studentsList.add(new Student(201, "Bob Student", "bob202", "pass123"));
    }

    @Test
    void testAddNewCourse() {
        Course newCourse = new Course("MA101", "Mathematics 101", "Dr. Bob", "TR", "09:00", "10:30", 40);
        admin.addNewCourse(coursesList, newCourse);
        assertTrue(coursesList.contains(newCourse));
    }

    @Test
    void testDeleteCourse() {
        assertTrue(admin.deleteCourse(coursesList, "CS101"));
        assertFalse(coursesList.contains(new Course("CS101", "Intro to Computer Science", "Dr. Alice", "MWF", "10:00", "11:00", 30)));
    }

    @Test
    void testAddNewProfessor() {
        Professor newProfessor = new Professor("Dr. Bob", 102, "bob102", "secure123");
        assertTrue(admin.addNewProfessor(professorsList, newProfessor));
        assertTrue(professorsList.contains(newProfessor));
    }

    @Test
    void testDeleteProfessor() {
        assertTrue(admin.deleteProfessor(professorsList, 101));
        assertFalse(professorsList.stream().anyMatch(p -> p.getUID() == 101));
    }

    @Test
    void testAddNewStudent() {
        Student newStudent = new Student(202, "Charlie", "charlie303", "pass456");
        assertTrue(admin.addNewStudent(studentsList, newStudent));
        assertTrue(studentsList.contains(newStudent));
    }

    @Test
    void testDeleteStudent() {
        assertTrue(admin.deleteStudent(studentsList, 201));
        assertFalse(studentsList.stream().anyMatch(s -> s.getUID() == 201));
    }

    @Test
    void testViewAllCourses() {
        admin.viewAllCourses(coursesList);
        // This test would need a way to capture console output or a change to return a String from the method
    }
}
