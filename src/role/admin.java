package role;
import java.util.ArrayList;

import Course.*;


/**
 * admin
 * @author Ze Li and Chenwei Tang
 */
public class Admin extends AbstractUser{
    public Admin(){
        super();
    }
    public Admin(int UID, String name, String username, String password, String role){
        super(UID, name, username, password, role);
    }

    public void menu(){
        // Print Menu
        System.out.println("--------------------");
        System.out.println("Welcome, "+ this.getName());
        System.out.println("--------------------");
        System.out.println("1 -- View all courses");
        System.out.println("2 -- Add New courses");
        System.out.println("3 -- Delete courses");
        System.out.println("4 -- Add new Professors");
        System.out.println("5 -- Delete Professors");
        System.out.println("6 -- Add new Students");
        System.out.println("7 -- Delete Students");
        System.out.println("8 -- Return to main menu");

    }

    public void viewAllCourses(ArrayList<Course> courses){
        for (Course course : courses){
            System.out.println(course.printCourseInfo());
        }
        
    }

    public void addNewCourse(ArrayList<Course> courses, Course newCourse){
        if (newCourse.checkCourseInList(newCourse.getCourseID(), courses) == null){
            Course testCourse = new Course();
            testCourse = newCourse.checkTimeConflict(newCourse,courses);
           if(testCourse == null){
                courses.add(newCourse);
                System.out.println("Successfully added the course: " + newCourse.printCourseInfo());
            } else {
                System.out.println("Time conflict with existing course!" + testCourse.printCourseInfo());
            }
        } else {
            System.out.println("Course already exists!");
        }
    }

    public boolean deleteCourse(ArrayList<Course> courses, String courseID){
        Course course = new Course();
        course = course.checkCourseInList(courseID, courses);
        if (course != null){
            courses.remove(course);
            return true;
        } else {
            System.out.println("Course not found!");
            return false;
        }
    }

    public boolean addNewProfessor(ArrayList<Professor> professors, Professor newProfessor){
        if (newProfessor.findProfessor(newProfessor.getUID(), professors) == null){
            professors.add(newProfessor);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteProfessor(ArrayList<Professor> professors, int UID){
        Professor professor = new Professor();
        professor = professor.findProfessor(UID, professors);
        if (professor != null){
            professors.remove(professor);
            return true;
        } else {
            System.out.println("Professor not found!");
            return false;
        }
    }

    public boolean addNewStudent(ArrayList<Student> students, Student newStudent){
        if (newStudent.findStudent(newStudent.getUID(), students) == null){
            students.add(newStudent);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteStudent(ArrayList<Student> students, int UID){
        Student student = new Student();
        student = student.findStudent(UID, students);
        if (student != null){
            students.remove(student);
            return true;
        } else {
            System.out.println("Student not found!");
            return false;
        }
    }

    public Admin adminLogin(String username, String password, ArrayList<Admin> adminList){
        for (Admin admin: adminList){
            if (admin.getUsername().equals(username) && admin.checkPassword(password)){
                return admin;
            }
        }
        return null;
    }

    public void initAdminList(String fileName, ArrayList<Admin> adminList){
        FileInfoReader reader = new FileInfoReader(fileName);
        ArrayList<String> fileContent = reader.getFileContent();
        for(String line: fileContent){
            String[] info = line.split(";");
            Admin admin = new Admin(Integer.parseInt(info[0].trim()), info[1].trim(), info[2].trim(), info[3].trim(), "admin");
            adminList.add(admin);
        }
    }

 

}
