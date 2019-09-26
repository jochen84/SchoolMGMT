package SE.EC.Johan.SchoolMGMT.data_access;

import SE.EC.Johan.SchoolMGMT.model.Course;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoListTest {

    CourseDaoList testCourseDaoListObject;
    Course testCourse1;
    Course testCourse2;

    @Before
    public void setUp(){
        testCourseDaoListObject = new CourseDaoList();
        testCourse1 = new Course(1,"Vetenskap", LocalDate.of(2010, 01, 01), 1);
        testCourse2 = new Course(2,"Matematik",LocalDate.of(2020, 10, 10), 2);
    }

    @Test
    public void test_courselist_not_null_after_added_course(){
        Course expectedCourse = testCourse1;
        Course actualCourse = testCourseDaoListObject.saveCourse(testCourse1);
        Assert.assertEquals(expectedCourse,actualCourse);
    }

    @Test
    public void test_Course_findById(){
        testCourseDaoListObject.saveCourse(testCourse1);
        System.out.println(testCourseDaoListObject.findAll().toString());
        Course expectedCourse = testCourse1;
        Course actualCourse = testCourseDaoListObject.findById(testCourse1.getCourseId());
        Assert.assertEquals(expectedCourse, actualCourse);
    }

    @Test
    public void test_Course_findById_test_fail(){
        testCourseDaoListObject.saveCourse(testCourse1);
        Course expectedCourse = null;
        Course actualCourse = testCourseDaoListObject.findById(3);
        Assert.assertEquals(expectedCourse, actualCourse);
    }

    @Test
    public void save_course_test_successfully(){
        Course expectedCourse = testCourse1;
        Course actualCourse = testCourseDaoListObject.saveCourse(testCourse1);
        System.out.println("Actual: " + actualCourse);
        Assert.assertEquals(expectedCourse, actualCourse);
    }

    @Test
    public void test_Course_findByName() {
        testCourseDaoListObject.saveCourse(testCourse1);
        Course course2 = new Course("HTML", LocalDate.parse("2019-10-01"), 5);
        testCourseDaoListObject.saveCourse(course2);

        List<Course> expectedCourses = testCourseDaoListObject.findByName("HTML");
        List<Course> actualCourses = new ArrayList<>();
        actualCourses.add(course2);
        Assert.assertEquals(expectedCourses, actualCourses);
    }
    @Test
    public void find_by_date_test() {
        testCourseDaoListObject.saveCourse(testCourse1);
        Course course2 = new Course("HTML", LocalDate.parse("2019-10-01"), 5);
        testCourseDaoListObject.saveCourse(course2);

        List<Course> expectedCourses = testCourseDaoListObject.findByDate(LocalDate.parse("2019-10-01"));
        List<Course> actualCourses = new ArrayList<>();
        actualCourses.add(course2);
        Assert.assertEquals(expectedCourses, actualCourses);
    }
    @Test
    public void find_all_test() {
        testCourseDaoListObject.saveCourse(testCourse1);
        testCourseDaoListObject.saveCourse(testCourse2);

        List<Course> expectedCourses = testCourseDaoListObject.findAll();
        List<Course> actualCourses = new ArrayList<>();
        actualCourses.add(testCourse1);
        actualCourses.add(testCourse2);
        Assert.assertEquals(expectedCourses, actualCourses);
    }
    @Test
    public void remove_course_test_successfully(){
        testCourseDaoListObject.saveCourse(testCourse1);
        testCourseDaoListObject.removeCourse(testCourse1);
        int expectedValue = 0;
        int actualValue = testCourseDaoListObject.findAll().size();
        Assert.assertEquals(expectedValue, actualValue);
    }
    @Test
    public void remove_course_test_failed(){
        testCourseDaoListObject.saveCourse(testCourse1);
        boolean actual = testCourseDaoListObject.removeCourse(testCourse2);
        Assert.assertFalse(actual);
    }

    @After
    public void clear(){
        testCourseDaoListObject.findAll().clear();
    }
}
