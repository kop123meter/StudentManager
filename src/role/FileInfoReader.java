package role;
/**
 * FileInfoReader
 * @author Ze Li and Chenwei Tang
 */

import java.io.File;
public class FileInfoReader {
    private String fileName;
    private String fileType;
    private String[] fileContent;
    private int fileLength;
    
    public FileInfoReader(String filePath){
        File file = new File(filePath);
        fileName = file.getName();
        fileType = fileName.substring(fileName.lastIndexOf(".")+1);
        fileLength = (int)file.length();
        fileContent = new String[fileLength];
        try {
            java.util.Scanner input = new java.util.Scanner(file);
            int i = 0;
            while (input.hasNext()) {
                fileContent[i] = input.nextLine();
                i++;
            }
            input.close();
            fileLength = i;
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public String[] getFileContent() {
        return fileContent;
    }

    public int getFileLength() {
        return fileLength;
    }
   
    
}