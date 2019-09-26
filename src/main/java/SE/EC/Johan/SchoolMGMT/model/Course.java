package SE.EC.Johan.SchoolMGMT.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Course {

    private static int courseCounter;
    private int courseId;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private List<Student> studentList;

    public Course(int courseId, String courseName, LocalDate startDate, int weekDuration) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        this.studentList = new ArrayList<>();
    }

    public Course(String courseName, LocalDate startDate, int weekDuration) {
        this (++courseCounter,courseName,startDate,weekDuration);
    }

    public void addStudent(Student student){
        if(!studentList.contains(student)){
            System.out.println(student.getName() + " was added to " + getCourseName());
            studentList.add(student);
        }else{
            System.out.println(student.getName() + " is allready in " + getCourseName());
        }
    }

    public void removeStudent(Student student){
        if(studentList.contains(student)){
            System.out.println(student.getName() + " was removed from " + getCourseName());
            studentList.remove(student);
        }else{
            System.out.println(student.getName() + " is not in " + getCourseName());
        }

    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    @Override
    public String toString() {
        return "CourseId: " + courseId +
                " - " + courseName +
                "]\nStart date: " + startDate +
                "\nDuration: " + weekDuration +
                "\nStudents in course: " + studentList + "\n";
    }


}
