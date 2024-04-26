package role;
import java.util.ArrayList;

import Course.*;
/**
 * student
 * @author Ze Li and Chenwei Tang
 */
public class Student extends AbstractUser{
    


    public Student(int UID,String name,String username, String password){
        super(UID, name,username, password, "student");
    }

    /**
     * Initialize Course List
     * @param path the path of the file
     * @return void
     */
    public void initStudentList(String path,ArrayList<Student> studentList){
        // Initialize Course List
        FileInfoReader studentInfo = new FileInfoReader(path);
        // Get basic Information of the student
        for (int i = 0; i < studentInfo.getFileLength(); i++){
            String[] studentInfoArray = studentInfo.getFileContent().get(i).split(";");
            for(int j = 0; j < studentInfoArray.length; j++){
                studentInfoArray[j] = studentInfoArray[j].trim();
            }
            Student student = new Student(Integer.parseInt(studentInfoArray[0]), studentInfoArray[1], studentInfoArray[2], studentInfoArray[3]);
            
           
            studentList.add(student);
        }
    }

    public void enrollCourse(){
        // Enroll Course

    }

    public void menu(){
        // Print Menu
        System.out.println('-' * 20);
        System.out.println("Welcome, "+ this.getName());
        System.out.println('-' * 20);
        System.out.println("1 -- View all courses");
        System.out.println("2 -- Add course to your list");
        System.out.println("3 -- View enrolled courses");
        System.out.println("4 -- Drop course in your list");
        System.out.println("5 -- View grades");
        System.out.println("6 -- Return to the main menu");

    }
   

}
