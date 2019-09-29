package SE.EC.Johan.SchoolMGMT.data_access;

import SE.EC.Johan.SchoolMGMT.model.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoList implements CourseDao {

    private static List<Course> courseList = new ArrayList<>();

    //TESTAD - OK
    @Override
    public Course saveCourse(Course course) {
        if(!courseList.contains(course)){
            for (Course courses : courseList){
                if(courses.getCourseName().equals(course.getCourseName())){
                    System.out.println("Course name is allready in use.");
                    return null;
                }
            }
            courseList.add(course);
            System.out.println(course.getCourseName() + " was added.");
            return course;
        }
        return null;
    }

    @Override
    public Course findById(int id) {
        for (Course course : courseList) {
            if (course.getCourseId() == id){
                return course;
            }
        }
        return null;
    }

    @Override
    public List<Course> findByName(String name) {
        List<Course> c = new ArrayList<>();
        for (Course course : courseList){
            if (course.getCourseName().equals(name)){
                c.add(course);
            }
        }
        return c;
    }

    @Override
    public List<Course> findByDate(LocalDate date) {
        List<Course> c = new ArrayList<>();
        for (Course course : courseList){
            if (course.getStartDate().equals(date)){
                c.add(course);
            }
        }
        return c;
    }

    @Override
    public List<Course> findAll() {
        return courseList;
    }

    @Override
    public boolean removeCourse(Course course) {
        if(courseList.contains(course)){
            courseList.remove(course);
            return true;
        }
        return false;
    }
}
