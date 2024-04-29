import java.util.ArrayList;
import java.util.Scanner;

import role.*;
import Course.Course;

/**
 * App
 *@author Ze Li and Chenwei Tang
 */
public class Controller {

    ArrayList<Admin> adminList = new ArrayList<Admin>();
    ArrayList<Professor> professorList = new ArrayList<Professor>();
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

        // Setup Professor
        professor.initProfessorList("src/profInfo.txt", professorList);
 
        // Setup Admin
        admin.initAdminList("src/adminInfo.txt", adminList);

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
        Controller app = new Controller();
        app.setUp(); 
        int option = -1;       
        while(true){
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
                Student tempStudent = new Student();
                app.student = tempStudent.studentLogin(username, password, app.studentList);
                if(app.student != null){
                    // app.printCourseList(app.coursesList);
                    int studentOption = -1;
                    while(true){
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
        


        else if(option==2){
            Professor tempProfessor = new Professor();
            app.professor = tempProfessor.findProfessor(username, password, app.professorList);
            if(app.professor != null){
                int professorOption = -1;
                while(true){
                    app.professor.menu();
                    System.out.println("Please enter your option, eg. '1'.");
                    professorOption = app.userInputOption(input.nextLine());
                    if(professorOption < 1 || professorOption > 3){
                        System.out.println("Invalid Input");
                        continue;
                    }
                    if(professorOption == 1){
                        app.professor.viewGivenCourses(app.coursesList);
                        app.printCourseList(app.professor.getCourseList());
                    } else if(professorOption == 2){
                        System.out.println("Please enter the course ID you want to view, eg. 'CSC207'.");
                        String courseID = input.nextLine();
                        app.professor.viewStudentList(courseID);
                    } else if(professorOption == 3){
                        break;
                    }
                }
            } else{
                System.out.println("Invalid username or password");
            }
        } // Option 2 loop // professor
       


        else if(option == 3){
            Admin tempAdmin = new Admin();
            app.admin = tempAdmin.adminLogin(username, password, app.adminList);
            if(app.admin != null){
                app.admin.menu();
                int adminOption = -1;
                while (true) {
                    adminOption = app.userInputOption(input.nextLine());
                 
                    if(adminOption == 8){
                        break;
                    }
                    else if(adminOption == 1){
                        app.printCourseList(app.coursesList);
                    }
                    else if(adminOption == 2){
                        String userAddCourseID = "0";
                        
                        while (true) {
                            System.out.println("Please enter the course ID you want to add, eg. 'CSC207'. Type 'q' to quit.");
                            userAddCourseID = input.nextLine();
                            if(userAddCourseID.toLowerCase().equals("q")){
                                break;
                            }
                            else if(app.course.checkCourseInList(userAddCourseID, app.coursesList) != null){
                                System.out.println("Course already exists");
                                continue;
                            }
                            else{
                                System.out.println("Please enter the course name, eg. 'Software Design'.");
                                String courseName = input.nextLine();
                                System.out.println("Please enter the course day, eg. 'MF'.");
                                String courseDay = input.nextLine();
                                System.out.println("Please enter the course start time, eg. '10:00'.");
                                String courseStartTime = input.nextLine();
                                System.out.println("Please enter the course end time, eg. '11:00'.");
                                String courseEndTime = input.nextLine();
                                System.out.println("Please enter the course capacity, eg. '30'.");
                                int courseCapacity = app.userInputOption(input.nextLine());
                                if(courseCapacity < 0){
                                    System.out.println("Invalid Input");
                                    continue;
                                }
                                System.out.println("Please enter the course lectuer's ID");
                                int professorID = app.userInputOption(input.nextLine());
                                if(professorID < 0){
                                    System.out.println("Invalid Input");
                                    continue;
                                }
                                Professor professor = app.professor.findProfessor(professorID, app.professorList);
                                if(professor == null){
                                    System.out.println("Professor not found, please add the professor first");
                                    System.out.println("Please enter the professor's name or typr 'q' to exit, eg. 'John Doe'.");
                                    String professorName = input.nextLine();
                                    if(professorName.toLowerCase().equals("q")){
                                        break;
                                    }
                                    System.out.println("Please enter the professor's username or typr 'q' to exit, eg. 'johndoe'.");
                                    String professorUsername = input.nextLine();
                                    if(professorUsername.toLowerCase().equals("q")){
                                        break;
                                    }
                                    System.out.println("Please enter the professor's password or typr 'q' to exit, eg. '1234'.");
                                    String professorPassword = input.nextLine();
                                    if(professorPassword.toLowerCase().equals("q")){
                                        break;
                                    }
                                    professor = new Professor(professorName,professorID, professorUsername, professorPassword);
                                    app.professorList.add(professor);
                                    System.out.println("Successfully added the professor:" +professorID + " " + professorName);
                                    break;
                                }
                                Course newCourse = new Course(userAddCourseID, 
                                                            courseName, 
                                                            professor.getName(),
                                                            courseDay,
                                                            courseStartTime,
                                                            courseEndTime,
                                                            courseCapacity);
                                app.admin.addNewCourse(app.coursesList, newCourse);
                            } // add course loop

                        } // add course loop
                      
                        
                    } // option 2 loop
                    else if(adminOption == 3){
                      System.out.println("Please enter the course ID you want to delete  or type 'q' to exit, eg. 'CSC207'.");
                      String courseID = input.nextLine();
                      if(courseID.toLowerCase().equals("q")){
                          break;
                      }
                      if(app.admin.deleteCourse(app.coursesList, courseID)){
                          System.out.println("Successfully deleted the course: " + courseID);
                      }
                    } // option 3 Delete Course
                    else if(adminOption == 4){
                      String addProfessorID = "0";
                      while (true) {
                        System.out.println("Please enter the Professor ID you want to add  or type 'q' to exit, eg. '005'.");
                        addProfessorID = input.nextLine();
                        if(addProfessorID.toLowerCase().equals("q")){
                            break;
                        }
                        int professorID = app.userInputOption(addProfessorID);
                        if(professorID < 0){
                            System.out.println("Invalid Input");
                            continue;
                        }
                        Professor professor = app.professor.findProfessor(professorID, app.professorList);
                        if(professor != null){
                            System.out.println("Professor already exists");
                            continue;
                        }
                        System.out.println("Please enter the professor's name or typr 'q' to exit, eg. 'John Doe'.");
                        String professorName = input.nextLine();
                        if(professorName.toLowerCase().equals("q")){
                            break;
                        }
                        System.out.println("Please enter the professor's username or typr 'q' to exit, eg. 'johndoe'.");
                        String professorUsername = input.nextLine();
                        if(professorUsername.toLowerCase().equals("q")){
                            break;
                        }
                        System.out.println("Please enter the professor's password or typr 'q' to exit, eg. '1234'.");
                        String professorPassword = input.nextLine();
                        if(professorPassword.toLowerCase().equals("q")){
                            break;
                        }
                        professor = new Professor(professorName,professorID, professorUsername, professorPassword);
                        if(app.admin.addNewProfessor(app.professorList, professor)){
                        System.out.println("Successfully added the professor:" +professorID + " " + professorName);}
                        break;
                      } // add professor loop
                     
                    } // option 4 Add Professor
                    else if(adminOption == 5){
                       String deleteProfessorID = "0";
                       while (true) {
                        System.out.println("Please enter the professor ID you want to delete  or type 'q' to exit, eg. '006'.");
                        deleteProfessorID = input.nextLine();
                        if(deleteProfessorID.toLowerCase().equals("q")){
                            break;
                        }
                        int professorID = app.userInputOption(deleteProfessorID);
                        if(professorID < 0){
                            System.out.println("Invalid Input");
                            continue;
                        }
                        if(app.admin.deleteProfessor(app.professorList, professorID)){
                            System.out.println("Successfully deleted the professor: " + professorID);
                        }
                       }
                    } // option 5 Delete Professor
                    else if(adminOption == 6){
                        String addStudentID = "0";
                        while (true) {
                            System.out.println("Please enter the new student ID you want to add  or type 'q' to exit, eg. '004'.");
                            addStudentID = input.nextLine();
                            if(addStudentID.toLowerCase().equals("q")){
                                break;
                            }
                            int studentID = app.userInputOption(addStudentID);
                            if(studentID < 0){
                                System.out.println("Invalid Input");
                                continue;
                            }
                            Student student = app.student.findStudent(studentID, app.studentList);
                            if(student != null){
                                System.out.println("Student already exists");
                                continue;
                            }
                            System.out.println("Please enter the student's name or typr 'q' to exit, eg. 'John Doe'.");
                            String studentName = input.nextLine();
                            if(studentName.toLowerCase().equals("q")){
                                break;
                            }
                            System.out.println("Please enter the student's username or typr 'q' to exit, eg. 'johndoe'.");
                            String studentUsername = input.nextLine();
                            if(studentUsername.toLowerCase().equals("q")){
                                break;
                            }
                            System.out.println("Please enter the student's password or typr 'q' to exit, eg. '1234'.");
                            String studentPassword = input.nextLine();
                            if(studentPassword.toLowerCase().equals("q")){
                                break;
                            }
                            student = new Student(studentID,studentName,studentUsername, studentPassword);
                            if(app.admin.addNewStudent(app.studentList, student)){
                            System.out.println("Successfully added the student:" +studentID + " " + studentName);
                            break;
                            }
                            
                        }
                    } // option 6 Add Student
                    else if(adminOption == 7){
                        String deleteStudentID = "0";
                        while (true) {
                            System.out.println("Please enter the new student ID you want to delete  or type 'q' to exit, eg. '004'.");
                            deleteStudentID = input.nextLine();
                            if(deleteStudentID.toLowerCase().equals("q")){
                                break;
                            }
                            int studentID = app.userInputOption(deleteStudentID);
                            if(studentID < 0){
                                System.out.println("Invalid Input");
                                continue;
                            }
                            if(app.admin.deleteStudent(app.studentList, studentID)){
                                System.out.println("Successfully deleted the student: " + studentID);
                                break;
                            }
                        }
                        
                    } // option 7 Delete Student
                    else if(adminOption == 8){
                        break;
                    }
                    else{
                        System.out.println("Invalid Input");
                    } 

                    app.admin.menu();
                } // admin loop
            }
            else{
                System.out.println("Invalid username or password");
            } // Admin login
            
        } // Admin option    




    
    } // System whole loop
        input.close();
    } // main function end   
} // class end
