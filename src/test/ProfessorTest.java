package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import role.Professor;
import Course.Course;

public class ProfessorTest {
    private Professor professor;
    private ArrayList<Professor> professorList;
    private ArrayList<Course> coursesList;
    
    @BeforeEach
    void setUp() {
        professor = new Professor("Dr. Smith", 101, "smith101", "password590");
        professorList = new ArrayList<>();
        coursesList = new ArrayList<>();
        professorList.add(professor);
        
        // add some courses
        coursesList.add(new Course("CS101", "Computer Science", "Dr. Smith", "T", "09:00", "10:30", 30));
        coursesList.add(new Course("MA101", "Mathematics", "Dr. Smith", "W", "10:00", "11:30", 25));
        coursesList.add(new Course("PH101", "Physics", "Dr. Johnson", "F", "14:00", "15:30", 20));
    }

    @Test
    void testFindProfessor() {
        // find professor test
        Professor foundProfessor = professor.findProfessor("smith101", "password590", professorList);
        assertNotNull(foundProfessor);
        assertEquals("Dr. Smith", foundProfessor.getName());
    }

    @Test
    void testInitProfessorList() {
        // init professor test
        Professor anotherProfessor = new Professor("Dr. Johnson", 102, "johnson102", "password590");
        professorList.add(anotherProfessor);
        assertEquals(2, professorList.size());
    }

    @Test
    void testViewGivenCourses() {
        // view given courses test
        professor.viewGivenCourses(coursesList);
        assertEquals(2, professor.getCourseList().size());
    }

    @Test
    void testViewStudentList() {
        // student view test
        professor.addCourse(coursesList.get(0)); // add course to 
        professor.viewStudentList("CS101");
    }
}
