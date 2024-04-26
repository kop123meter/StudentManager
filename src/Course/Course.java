package Course;
import java.util.ArrayList;

import role.*;

public class Course {

    private String courseName;
    private String courseID;
    private String courseDay;
    private String courseStartTime;
    private String courseEndTime;
    private int courseCapacity;
    private int currentEnrollment;
    private String courseInstructor;
    private String grade; 

    public Course(){
        this.courseName = null;
        this.courseID = null;
        this.courseDay = null;
        this.courseStartTime = null;
        this.courseEndTime = null;
        this.courseCapacity = 0;
        this.currentEnrollment = 0;
        this.courseInstructor = null;
    }

    public Course(String courseID, String courseName, String courseInstructor, String courseDay, String courseStartTime, String courseEndTime, int courseCapacity){
        this.courseName = courseName;
        this.courseID = courseID;
        this.courseDay = courseDay;
        this.courseStartTime = courseStartTime;
        this.courseEndTime = courseEndTime;
        this.courseCapacity = courseCapacity;
        this.courseInstructor = courseInstructor;
        this.currentEnrollment = 0;
    }

    public String printCourseInfo(){
        return courseID + "|Course Name: " + courseName + ","+ courseStartTime + "-" +courseEndTime + " on " + courseDay + ", with course capacity: " + courseCapacity + ", students: " + currentEnrollment + ", lecturer: " + courseInstructor;
    }

    public int getEnrollment(){
        return this.currentEnrollment;
    }

    public void setEnrollment(int enrollment){
        this.currentEnrollment = enrollment;
    } 

    public void setCourseName(String courseName){
        this.courseName = courseName;
    }

    public String getCourseName(){
        return this.courseName;
    }

    public void setCourseID(String courseID){
        this.courseID = courseID;
    }

    public String getCourseID(){
        return this.courseID;
    }

    public void setCourseDay(String courseDay){
        this.courseDay = courseDay;
    }

    public String getCourseDay(){
        return this.courseDay;
    }

    public void setCourseStartTime(String courseStartTime){
        this.courseStartTime = courseStartTime;
    }

    public String getCourseStartTime(){
        return this.courseStartTime;
    }

    public void setCourseEndTime(String courseEndTime){
        this.courseEndTime = courseEndTime;
    }

    public String getCourseEndTime(){
        return this.courseEndTime;
    }

    public void setCourseCapacity(int courseCapacity){
        this.courseCapacity = courseCapacity;
    }

    public int getCourseCapacity(){
        return this.courseCapacity;
    }

    public void setCourseInstructor(String courseInstructor){
        this.courseInstructor = courseInstructor;
    }

    public String getCourseInstructor(){
        return this.courseInstructor;
    }

    public void setGrade(String grade){
        this.grade = grade;
    }

    public String getGrade(){
        return this.grade;
    }

    public void initCourseList(String path, ArrayList<Course> coursesList){
        // Initialize Course List
        FileInfoReader courseInfo = new FileInfoReader(path);
        for (int i = 0; i < courseInfo.getFileLength(); i++){
            String[] courseInfoArray = courseInfo.getFileContent().get(i).split(";");
            if(courseInfoArray.length != 7){
                System.out.println("Course" + courseInfoArray[0] +" information is missing");
                continue;
            }
            for(int j = 0; j < courseInfoArray.length; j++){
                courseInfoArray[j] = courseInfoArray[j].trim();
            }
            Course course = new Course(courseInfoArray[0], courseInfoArray[1], courseInfoArray[2], courseInfoArray[3], courseInfoArray[4], courseInfoArray[5], Integer.parseInt(courseInfoArray[6]));
            coursesList.add(course);
        }
    }

    public String getCourseInfo(String courseID, ArrayList<Course> coursesList){
        for (Course course : coursesList){
            if (course.getCourseID().equals(courseID)){
                return course.printCourseInfo();
            }
        }
        return null;  
    }
}
