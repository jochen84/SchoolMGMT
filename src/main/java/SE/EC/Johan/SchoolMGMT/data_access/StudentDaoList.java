package SE.EC.Johan.SchoolMGMT.data_access;

import SE.EC.Johan.SchoolMGMT.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoList implements StudentDao {

    private static List<Student> studentList = new ArrayList<>();

    @Override
    public Student saveStudent(Student student) {
        if (!studentList.contains(student)){
            for (Student students : studentList){
                if(students.getEmail().equals(student.getEmail())){
                    System.out.println("Email is allready in use.");
                    return null;
                }
            }
            studentList.add(student);
            System.out.println(student.getName() + " was added.");
            return student;
        }
        return null;
    }

    @Override
    public Student findByEmail(String email) {
        for(Student student : studentList){
            if(student.getEmail().equals(email)){
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> c = new ArrayList<>();
        for (Student student : studentList){
            if(student.getName().equals(name)){
                c.add(student);
            }
        }
        return c;
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
        if(studentList.contains(student)){
            studentList.remove(student);
            return true;
        }
        return false;
    }
}
