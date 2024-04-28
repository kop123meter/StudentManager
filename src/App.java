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
    ArrayList<Student> studentList = new ArrayList<Student>();
    Course course = new Course();
    Student student = new Student();
    Professor professor = new Professor();
    Admin admin = new Admin();


    public void setUp(){
        // Setup Course
        course.initCourseList("src/courseInfo.txt", coursesList);

        // Setup Student
        student.initStudentList("src/studentInfo.txt",studentList, coursesList);
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

    public int userInputOption(String userOption){
    
        String username = userOption.trim(); 
        try{
            int option = Integer.parseInt(username);
            return option;
        }catch(Exception e){
           // System.out.println("Invalid Input");
            return -1;
        }
    }

    public void printCourseList(ArrayList<Course> coursesList){
        for(Course course: coursesList){
            System.out.println(course.printCourseInfo());
        }
    }

    



    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        App app = new App();
        app.setUp(); 
        int option = -1;       
        while(option != 4){
            app.printLogin();
            System.out.println("Please enter your option, eg. '1'.");
            option = app.userInputOption(input.nextLine());
            if(option == 4){
                break;
            }
            else if(option < 1 || option > 3){
                System.out.println("Invalid Input");
                continue;
            }
            System.out.println("Please enter your username, or type 'q' to quit. ");
            String username = input.nextLine();
            if(username.equals("q")){
                continue;
            }
            System.out.println("Please enter your password, or type 'q' to quit. ");
            String password = input.nextLine();
            if(password.equals("q")){
                continue;
            }
            if(option == 1){
                app.student = app.student.studentLogin(username, password, app.studentList);
                if(app.student != null){
                    app.printCourseList(app.coursesList);
                    int studentOption = -1;
                    while(studentOption != 6){
                        app.student.menu();
                        System.out.println("Please enter your option, eg. '1'.");
                        studentOption = app.userInputOption(input.nextLine());
                        if(studentOption < 1 || studentOption > 6){
                            System.out.println("Invalid Input");
                            continue;
                        }
                        if(studentOption == 1){
                            app.printCourseList(app.coursesList);
                        } else if(studentOption == 2){
                            System.out.println("Please enter the course ID you want to add, eg. 'CSC207'.");
                            String courseID = input.nextLine();
                            app.student.addStudentCourse(app.coursesList, courseID);

                        } else if(studentOption == 3){
                            app.student.viewEnrolledCourses();
                        } else if(studentOption == 4){
                            System.out.println("Please enter the course ID you want to drop, eg. 'CSC207'.");
                            String courseID = input.nextLine();
                            app.student.dropCourse(courseID);
                        } else if(studentOption == 5){
                            app.student.viewGrades();
                        } else if(studentOption == 6){
                            break;
                        }
            } // srudent loop

            }// Student login if-else
            else{
                System.out.println("Invalid username or password");
            }
            }// Option 1 loop // srudent
    
        } // System whole loop
        input.close();
    } // main function end   
} // class end
