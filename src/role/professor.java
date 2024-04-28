package role;

import java.util.ArrayList;
import Course.Course;

/**
 * @auther Ze Li and Chenwei Tang
 */
public class Professor extends AbstractUser{

    public Professor(){
        super();
    }

    public Professor(String name,int UID, String username, String password){
        super(UID, name, username, password, "Professor");
    }

    public void menu(){
        System.out.println("1 -- View given courses");
        System.out.println("2 -- View Student list of the given course");
        System.out.println("3 -- Return to the main menu");
    }
    
    public void initProfessorList(String fileName, ArrayList<Professor> professorList){
        FileInfoReader reader = new FileInfoReader(fileName);
        ArrayList<String> fileContent = reader.getFileContent();
        for(String line: fileContent){
            String[] info = line.split(";");
            Professor professor = new Professor(info[0].trim(), Integer.parseInt(info[1].trim()), info[2].trim(), info[3].trim());
            professorList.add(professor);
        }
    }

    public Professor findProfessor(String username, String password, ArrayList<Professor> professorList){
        for(Professor professor: professorList){
            if(professor.getUsername().equals(username) && professor.getPassword().equals(password)){
                return professor;
            }
        }
        return null;
    }

    public void viewGivenCourses(ArrayList<Course> coursesList){
        for(Course course: coursesList){
            String professorName = course.getCourseInstructor();
            if(professorName.equals(this.getName())){
                this.addCourse(course);
            }
        }
    }

    public void viewStudentList(String courseID){
        for(Course tempCourse: this.getCourseList()){
            if(tempCourse.getCourseID().equals(courseID)){
                tempCourse.printStudentList();
                return;
            }
        }
        System.out.println("Course not found");
    }

    


}
