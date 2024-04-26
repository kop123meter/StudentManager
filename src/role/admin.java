package role;
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
        System.out.println('-' * 20);
        System.out.println("Welcome, "+ this.getName());
        System.out.println('-' * 20);
        System.out.println("1 -- View all courses");
        System.out.println("2 -- Add course to the course list");
        System.out.println("3 -- Edit course list");
        System.out.println("4 -- Return to the main menu");

    }
    // Edit Course List

}
