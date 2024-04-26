package Course;

public class Course {

    private String courseName;
    private String courseID;
    private String courseDay;
    private String courseStartTime;
    private String courseEndTime;
    private int courseCapacity;
    private int currentEnrollment;
    private String courseInstructor;

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
        return "Course ID: " + courseID + "|Course Name: " + courseName + ","+ courseStartTime + "-" +courseEndTime + " on " + courseDay + ", with course capacity: " + courseCapacity + ", students: " + currentEnrollment + ", lecturer: " + courseInstructor;
    }

    public int getEnrollment(){
        return this.currentEnrollment;
    }

    public void setEnrollment(int enrollment){
        this.currentEnrollment = enrollment;
    } 


}
