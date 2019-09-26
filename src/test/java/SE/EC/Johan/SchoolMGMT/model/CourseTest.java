package SE.EC.Johan.SchoolMGMT.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseTest {
    List<Student> students;
    Student student1, student2;
    Course course;

    @Before
    public void setup(){
        student1 = new Student("Cheng Tao", "cheng.tao86@gmail.com", "Skomakaregatan 13");
        student2 = new Student("Emilie Johansson", "ej@gmail.com", "Arklimastaregatan 14A");
        students = new ArrayList<Student>(Arrays.asList(student1, student2));
        course = new Course(1, "Programmering i Java", LocalDate.parse("2019-08-20"), 6);

    }

    @Test
    public void register_student_test(){
        Student s1 = new Student("John Johansson", "jj@gmail.com", "Gyllenstjansvagen 7");
        course.addStudent(s1);
        int expectedValue = 1;
        Assert.assertEquals(expectedValue, course.getStudentList().size());
    }

    @Test
    public void unregister_student_test(){
        course.removeStudent(student2);
        int expectedValue = 0;
        Assert.assertEquals(expectedValue, course.getStudentList().size());
    }

}