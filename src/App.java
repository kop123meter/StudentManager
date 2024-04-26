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



    public void setUp(){
        // Setup Course
        FileInfoReader courseInfo = new FileInfoReader("src/courseInfo.txt");
        for (int i = 0; i < courseInfo.getFileLength(); i++){
            String[] courseInfoArray = courseInfo.getFileContent().get(i).split(";");
            for(int j = 0; j < courseInfoArray.length; j++){
                courseInfoArray[j] = courseInfoArray[j].trim();
            }
            Course course = new Course(courseInfoArray[0], courseInfoArray[1], courseInfoArray[2], courseInfoArray[3], courseInfoArray[4], courseInfoArray[5], Integer.parseInt(courseInfoArray[6]));
            coursesList.add(course);
        }
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
