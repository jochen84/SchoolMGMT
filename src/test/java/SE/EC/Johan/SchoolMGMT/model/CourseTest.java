package SE.EC.Johan.SchoolMGMT.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class CourseTest {
    //List<Student> students;
    Student student1, student2;
    Course course;

    @Before
    public void setup(){
        student1 = new Student("Cheng Tao", "cheng.tao86@gmail.com", "Skomakaregatan 13");
        student2 = new Student("Emilie Johansson", "ej@gmail.com", "Arklimastaregatan 14A");
        //students = new ArrayList<Student>(Arrays.asList(student1, student2));
        course = new Course(1, "Programmering i Java", LocalDate.parse("2019-08-20"), 6);
        //Adds student to course to test remove method
        course.addStudent(student2);
    }

    @Test
    public void add_student_test(){
        //Adds student1 to course Programming in Java then tests if Studentlist = 2
        course.addStudent(student1);
        //Size should be 2 cause we add student2 in the @Before
        int expectedValue = 2;
        Assert.assertEquals(expectedValue, course.getStudentList().size());
    }

    //Failed, why?
    @Test
    public void add_duoblet_student_test(){
        //Adds student1 twice to course Programming in Java then tests if Studentlist = 2.
        course.addStudent(student1);
        course.addStudent(student1);
        //Size should be 2 cause we add student2 in the @Before
        int expectedValue = 2;
        Assert.assertEquals(expectedValue, course.getStudentList().size());
    }

    @Test
    public void remove_student_test(){
        course.removeStudent(student2);
        int expectedValue = 0;
        Assert.assertEquals(expectedValue, course.getStudentList().size());
    }

    @Test
    public void remove_student_thats_not_in_course_test(){
        course.removeStudent(student1);
        //Should be 1 cause student2 is added in @Before
        int expectedValue = 1;
        Assert.assertEquals(expectedValue, course.getStudentList().size());
    }

}