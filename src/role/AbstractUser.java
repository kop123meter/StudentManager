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

    private ArrayList<Course> courseList = new ArrayList<Course>();

    public AbstractUser(int UID, String name, String username,String password, String role){
        setRole(role);
        this.username = username;
        this.password = password;
        this.UID = UID;
        this.name = name;
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

    public abstract void menu();

    public void login(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your username, or type 'q' to quit. ");
        String username = input.nextLine();
        if (username.equals("q")){
            return;
        }
        System.out.println("Please enter your password, or type 'q' to quit. ");
        String password = input.nextLine();
        if (password.equals("q")){
            return;
        }
        if (checkUsername(username) && checkPassword(password)){
            menu();
        } else {
            System.out.println("Invalid username or password");
        }
    }

}
