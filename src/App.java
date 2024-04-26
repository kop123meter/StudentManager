import java.util.ArrayList;
import java.util.Scanner;

import role.*;
import Course.Course;

/**
 * App
 *@author Ze Li and Chenwei Tang
 */
public class App {

    ArrayList<Admin> adminList = new ArrayList<Admin>();
    ArrayList<Professor> userList = new ArrayList<Professor>();
    ArrayList<Course> coursesList = new ArrayList<Course>();
    Course course = new Course();
    Student student = new Student();
    Professor professor = new Professor();
    Admin admin = new Admin();


    public void setUp(){
        // Setup Course
        course.initCourseList("src/courseInfo.txt", coursesList);
    }

    public void printLogin(){
        System.out.println("--------------------------------");
        System.out.println("Student Management System");
        System.out.println("--------------------------------");
        System.out.println("1 -- Login as a student");
        System.out.println("2 -- Login as a professor");
        System.out.println("3 -- Login as an admin");
        System.out.println("4 -- Quit the System");
    }

    public int userInputOption(){
        System.out.println("Please enter your option, eg. '1'.");
        Scanner input = new Scanner(System.in);
        String username = input.nextLine();
        username = username.trim();

        input.close();  
        try{
            int option = Integer.parseInt(username);
            return option;
        }catch(Exception e){
           // System.out.println("Invalid Input");
            return -1;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        App app = new App();
        app.setUp();        
        app.printLogin();
    
    }
}
