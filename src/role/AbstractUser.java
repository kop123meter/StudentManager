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

    public AbstractUser(){
        
    }

    

}
