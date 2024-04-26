package role;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import Course.Course;  // This is the Course class that is being imported

/**
 * Abstract class for User
 * @author Ze Li and Chenwei Tang
 */
abstract class AbstractUser {
    private String username;
    private String password;
    private String role;
    private String name;
    private int UID;

    private ArrayList<Course> usercourseList = new ArrayList<Course>();

    public AbstractUser(){
        this.username = null;
        this.password = null;
        this.UID = 0;
        this.name = null;
        this.role = null;
    }
    public AbstractUser(int UID, String name, String username,String password, String role){
        setRole(role);
        this.username = username;
        this.password = password;
        this.UID = UID;
        this.name = name;
    }

    public void addCourse(Course course){
        usercourseList.add(course);
    }

    public void removeCourse(Course course){
        usercourseList.remove(course);
    }

    public ArrayList<Course> getCourseList(){
        return usercourseList;
    }
    
    public int getUID(){
        return UID;
    }

    public String getName(){
        return name;
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

    public String getPassword(){
        return password;
    }

    public abstract void menu();


}
