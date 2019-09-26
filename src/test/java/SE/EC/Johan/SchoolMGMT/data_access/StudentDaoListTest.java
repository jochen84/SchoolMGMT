package SE.EC.Johan.SchoolMGMT.data_access;

import SE.EC.Johan.SchoolMGMT.model.Student;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class StudentDaoListTest {
    Student student1;
    StudentDaoList testObject;

    @Before
    public void setup(){
        student1 = new Student("Cheng Tao", "cheng.tao86@gmail.com", "Skomakaregatan 13");
        testObject = new StudentDaoList();
    }

    @Test
    public void save_student_test_successfully(){
        Student expectedStudent = student1;
        Student actualStudent = testObject.saveStudent(student1);
        Assert.assertEquals(expectedStudent, actualStudent);
    }

    @Test
    public void save_student_test_failed(){
        Student temp = student1;
        Student temp1 = testObject.saveStudent(student1);
        Student actual = testObject.saveStudent(student1);
        Assert.assertNull(actual);
    }

    @Test
    public void find_by_email_test_successfully(){
        testObject.saveStudent(student1);
        Student expectedStudent = student1;
        Student actualStudent =testObject.findByEmail("cheng.tao86@gmail.com");
        Assert.assertEquals(expectedStudent, actualStudent);
    }

    @Test
    public void find_by_email_test_failed(){
        testObject.saveStudent(student1);
        Student actualStudent = testObject.findByEmail("ct@gmail.com");
        Assert.assertNull(actualStudent);
    }

    @Test
    public void find_by_name_test(){
        Student student2 =new Student("Cheng Tao", "ct@gmail.com", "Kungsgatan 11");
        testObject.saveStudent(student1);
        testObject.saveStudent(student2);
        List<Student> expectedStudents = testObject.findByName("Cheng Tao");
        List<Student> actualStudents = new ArrayList<>();
        actualStudents.add(student1);
        actualStudents.add(student2);
        Assert.assertEquals(expectedStudents, actualStudents);
    }

    @Test
    public void find_by_id_test_successfully(){
        testObject.saveStudent(student1);
        System.out.println(testObject.findAll().toString());
        Student expectedStudent = student1;
        //Student actualStudent = testObject.findById(1);
        Student actualStudent = testObject.findById(student1.getStudentId());
        Assert.assertEquals(expectedStudent, actualStudent);
    }

    @Test
    public void find_by_id_test_fail(){
        testObject.saveStudent(student1);
        Student expectedStudent = null;
        Student actualStudent = testObject.findById(3);
        Assert.assertEquals(expectedStudent, actualStudent);
    }

    @Test
    public void find_all_test(){
        Student student2 =new Student("Cheng Tao", "ct@gmail.com", "Kungsgatan 11");
        testObject.saveStudent(student1);
        testObject.saveStudent(student2);
        List<Student> expectedStudents = testObject.findAll();
        List<Student> actualStudents = new ArrayList<>();
        actualStudents.add(student1);
        actualStudents.add(student2);
        Assert.assertEquals(expectedStudents, actualStudents);
    }

    @Test
    public void delete_student_test_successfully(){
        testObject.saveStudent(student1);
        testObject.deleteStudent(student1);
        int expectedValue = 0;
        int actualValue = testObject.findAll().size();
        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void delete_student_test_fail(){
        Student student2 =new Student("Cheng Tao", "ct@gmail.com", "Kungsgatan 11");
        boolean actual = testObject.deleteStudent(student2);
        Assert.assertFalse(actual);
    }

    @After
    public void clear(){
        testObject.findAll().clear();
    }
}
