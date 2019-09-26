package SE.EC.Johan.SchoolMGMT.data_access;

import SE.EC.Johan.SchoolMGMT.model.Course;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

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

    }
}
