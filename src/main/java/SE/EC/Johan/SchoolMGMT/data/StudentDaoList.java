package SE.EC.Johan.SchoolMGMT.data;

import SE.EC.Johan.SchoolMGMT.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoList implements StudentDao {

    private static List<Student> studentList = new ArrayList<>();

    @Override
    public Student saveStudent(Student student) {
        if (!studentList.contains(student)){
            studentList.add(student);
            System.out.println(student.getName()+" was added.");
            return student;
        }
        return null;
    }

    @Override
    public Student findByEmail(String email) {
        return null;
    }

    @Override
    public List<Student> findByName(String name) {
        return null;
    }

    @Override
    public Student findById(int id) {
        for (Student student:studentList) {
            if(student.getStudentId() == id){
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public boolean deleteStudent(Student student) {
        return false;
    }
}
