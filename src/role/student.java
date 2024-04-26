package role;
import java.util.ArrayList;
import java.util.Scanner;

import Course.*;
/**
 * student
 * @author Ze Li and Chenwei Tang
 */
public class Student extends AbstractUser{
    
    private ArrayList<Course> takenCourseList = new ArrayList<Course>();

    Course course = new Course(); // used for calling functions in Course class
    public Student(){
        super();
    }
    public Student(int UID,String name,String username, String password){
        super(UID, name,username, password, "student");
    }

    /**
     * Initialize Course List
     * @param path the path of the file
     * @return void
     */
    public void initStudentList(String path,ArrayList<Student> studentList,ArrayList<Course> coursesList){
        // Initialize Course List
        FileInfoReader studentInfo = new FileInfoReader(path);
        // Get basic Information of the student
        for (int i = 0; i < studentInfo.getFileLength(); i++){
            String[] studentInfoArray = studentInfo.getFileContent().get(i).split(";");
            for(int j = 0; j < studentInfoArray.length; j++){
                studentInfoArray[j] = studentInfoArray[j].trim();
            }
            Student student = new Student(Integer.parseInt(studentInfoArray[0]), studentInfoArray[1], studentInfoArray[2], studentInfoArray[3]);
            if(studentInfoArray.length > 4){
                String[] courseList = studentInfoArray[4].split(",");
                for(int j = 0; j < courseList.length; j++){
                    courseList[j] = courseList[j].trim();
                }
                for (String temp_course: courseList){
                    String[] grad = temp_course.split(":");
                    Course tempcourse = course.checkCourseInList(grad[0], coursesList);
                    if(tempcourse != null){
                        tempcourse.setGrade(grad[1]);
                        student.takenCourseList.add(tempcourse);
                    }
                }
            }
            studentList.add(student);
        }
    }

    public void menu(){
        // Print Menu
        System.out.println("------------------------------");
        System.out.println("Welcome, "+ this.getName());
        System.out.println("------------------------------");
        System.out.println("1 -- View all courses");
        System.out.println("2 -- Add course to your list");
        System.out.println("3 -- View enrolled courses");
        System.out.println("4 -- Drop course in your list");
        System.out.println("5 -- View grades");
        System.out.println("6 -- Return to the main menu");


    }


    public void viewAllCourses(ArrayList<Course> coursesList){
        // View all courses
        for (Course course: coursesList){
            System.out.println(course.printCourseInfo());
        }
    }

    public void addStudentCourse(ArrayList<Course> coursesList, String name){
        // Add course to the student's list
        if(coursesList.size() == 0){
            System.out.println("No course available");
            return;
        }
        Course add_course = course.checkCourseInList(name, coursesList);
        if (add_course == null){
            System.out.println("Course not found");
            return;
        } 
        if (add_course.getCourseCapacity() == 0){
            System.out.println("Course is full");
            return;
        }
        Course timeConflictCourse = course.checkTimeConflict(add_course, this.getCourseList());
        if(timeConflictCourse != null){
            System.out.println("The course you selected has time conflict with " + timeConflictCourse.getCourseID() + " " + timeConflictCourse.getCourseName());
        }
        else{
            add_course.addStudent(this);
            add_course.setCourseCapacity(add_course.getCourseCapacity()-1);
            add_course.setCourseEnrollment(add_course.getCourseEnrollment()+1);
            this.addCourse(add_course);
            System.out.println("Course added successfully");
        }
    
    }

    public void viewGrades(){
        // View enrolled courses
        if(this.takenCourseList.size() == 0){
            System.out.println("No course enrolled");
            return;
        }
        for (Course course: this.takenCourseList){
            System.out.println("Grade of "+ course.getCourseID() + " " + course.getCourseName() + " : " + course.getGrade());
        }
    }

    public void dropCourse(String name){
        // Drop course in the student's list
        if(this.takenCourseList.size() == 0){
            System.out.println("No course enrolled");
            return;
        }
        Course drop_course = course.checkCourseInList(name, this.getCourseList());
        if (drop_course == null){
            System.out.println("Course not found");
            return;
        } 
        drop_course.removeStudent(this);
        drop_course.setCourseCapacity(drop_course.getCourseCapacity()+1);
        drop_course.setCourseEnrollment(drop_course.getCourseEnrollment()-1);
        this.removeCourse(drop_course);
        System.out.println("Course dropped successfully!");
    }

    public void viewEnrolledCourses(){
        // View enrolled courses
        if(this.getCourseList().size() == 0){
            System.out.println("No course enrolled");
            return;
        }
        for (Course course: this.getCourseList()){
            System.out.println(course.printCourseInfo());
        }
    }

    public Student studentLogin(String username, String password, ArrayList<Student> studentList){
        // Student Login
        for (Student student: studentList){
            if (student.getUsername().equals(username) && student.checkPassword(password)){
                return student;
            }
        }
        return null;
    }

   

   

}
