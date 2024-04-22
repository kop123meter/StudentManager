package role;

import java.io.File;

/**
 * Abstract class for User
 * @author Ze Li and Chenwei Tang
 */
abstract class AbstractUser {
    private String username;
    private String password;
    private String role;
    private int UID;

    public AbstractUser(String filePath){
        FileInfoReader reader = new FileInfoReader(filePath);
        String[] fileContent = reader.getFileContent();
        
    }

}
