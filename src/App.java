import java.util.ArrayList;


import role.*;
import Course.Course;

/**
 * App
 *@author Ze Li and Chenwei Tang
 */
public class App {

    ArrayList<admin> adminList = new ArrayList<admin>();
    ArrayList<professor> userList = new ArrayList<professor>();
    ArrayList<Course> coursesList = new ArrayList<Course>();
    Course course = new Course();


    public void setUp(){
        // Setup Course
        course.initCourseList("src/courseInfo.txt", coursesList);
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        App app = new App();
        app.setUp();
        for (Course course : app.coursesList){
            System.out.println(course.printCourseInfo());
        }
        
    }
}
