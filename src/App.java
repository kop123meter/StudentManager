import java.util.ArrayList;

import role.FileInfoReader;
import role.admin;
import role.professor;

/**
 * App
 *@author Ze Li and Chenwei Tang
 */
public class App {

    ArrayList<admin> adminList = new ArrayList<admin>();
    ArrayList<professor> userList = new ArrayList<professor>();



    public void setUp(){
        
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        FileInfoReader t = new FileInfoReader("src/profInfo.txt");
        for (int i = 0 ; i < t.getFileLength(); i++){
            System.out.println(t.getFileContent().get(i));
            
        }
        
        
    }
}
