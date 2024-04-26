package role;

import java.io.File;
import java.util.ArrayList;
import Course.Course;  // This is the Course class that is being imported

/**
 * Abstract class for User
 * @author Ze Li and Chenwei Tang
 */
abstract class AbstractUser {
    private String username;
    private String password;
    private String role;
    private int UID;

    private ArrayList<Course> courseList;

    public AbstractUser(String role){
        setRole(role);
    }

    public void addCourse(Course course){
        courseList.add(course);
    }

    public void removeCourse(Course course){
        courseList.remove(course);
    }

    public ArrayList<Course> getCourseList(){
        return courseList;
    }

    public String getUsername() {
        return username;
    }
    public String getRole(){
        return role;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setRole(String role){
        this.role = role;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public void setUID(int UID){
        this.UID = UID;
    }

    public boolean checkPassword(String password){
        return this.password.equals(password);
    }

    public boolean checkUsername(String username){
        return this.username.equals(username);
    }

}
