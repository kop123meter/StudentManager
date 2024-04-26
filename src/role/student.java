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
    public void initStudentList(String path,ArrayList<student> studentList){
        // Initialize Course List
        FileInfoReader studentInfo = new FileInfoReader(path);
        for (int i = 0; i < studentInfo.getFileLength(); i++){
            String[] studentInfoArray = studentInfo.getFileContent().get(i).split(";");
            for(int j = 0; j < studentInfoArray.length; j++){
                studentInfoArray[j] = studentInfoArray[j].trim();
            }
            Student student = new Student(studentInfoArray[0],studentInfoArray[1],studentInfoArray[2],studentInfoArray[3]);
        }
    }

    public void enrollCourse(){
        // Enroll Course

    }
}
