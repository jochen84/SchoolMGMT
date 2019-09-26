package SE.EC.Johan.SchoolMGMT.data_access;

import SE.EC.Johan.SchoolMGMT.model.Student;

import java.util.List;

public interface StudentDao {

    Student saveStudent(Student student);
    Student findByEmail(String email);
    List<Student> findByName(String name);
    Student findById(int id);
    List<Student>findAll();
    boolean deleteStudent(Student student);

}
