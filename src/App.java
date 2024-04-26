import java.util.ArrayList;
import java.util.Scanner;

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
    Student student = new Student();
    professor 


    public void setUp(){
        // Setup Course
        course.initCourseList("src/courseInfo.txt", coursesList);
    }

    public void printLogin(){
        System.out.println('-' * 20);
        System.out.println("Student Management System");
        System.out.println('-' * 20);
        System.out.println("1 -- Login as a student");
        System.out.println("2 -- Login as a professor");
        System.out.println("3 -- Login as an admin");
        System.out.println("4 -- Quit the System");
    }

    public int userInput(){
        System.out.println("Please enter your option, eg. '1'.");
        Scanner input = new Scanner(System.in);
        String username = input.nextLine();
        username = username.trim();
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
        int option = app.userInput();
        switch(option){
            case 1:
                // Login as a student
                break;
            case 2:
                // Login as a professor
                break;
            case 3:
                // Login as an admin
                break;
            case 4:
                // Quit the System
                break;
            default:
                System.out.println("Invalid Option");
        }
        
    }
}
