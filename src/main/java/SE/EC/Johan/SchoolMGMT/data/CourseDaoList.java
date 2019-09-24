package SE.EC.Johan.SchoolMGMT.data;

import SE.EC.Johan.SchoolMGMT.model.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoList implements CourseDao {

    private static List<Course> courseList = new ArrayList<>();

    @Override
    public Course saveCourse(Course course) {
        if(!courseList.contains(course)){
            courseList.add(course);
            System.out.println(course.getCourseName() + " was added.");
        }
        return null;
    }

    @Override
    public Course findById(int id) {
        for (Course course:courseList) {
            if (course.getCourseId() == id){
                return course;
            }
        }
        return null;
    }

    @Override
    public List<Course> findByName(String name) {
        return null;
    }

    @Override
    public List<Course> findByDate(LocalDate date) {
        return null;
    }

    @Override
    public List<Course> findAll() {
        return courseList;
    }

    @Override
    public boolean removeCourse(Course course) {
        return false;
    }
}
