package SE.EC.Johan.SchoolMGMT;

import SE.EC.Johan.SchoolMGMT.model.Course;
import SE.EC.Johan.SchoolMGMT.model.Student;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        Student test = new Student("Johan", "simman@rocketmail.com", "Lingonstigen 1");
        Student test2 = new Student("Nisse","nisse@mail.com","Bollibombavägen 3");

        Course vetenskap = new Course("Vetenskap", LocalDate.of(2020,10,10), 8);
        Course matte = new Course("Matematik", LocalDate.of(2019, 10,20), 10);

        SchoolStart.schoolStart();
        /*
        vetenskap.addStudent(test);
        vetenskap.addStudent(test2);

        System.out.println(vetenskap.toString());
        System.out.println(matte.toString());

        matte.addStudent(test);

        System.out.println(matte.toString());

        vetenskap.removeStudent(test2);
        vetenskap.removeStudent(test2);

        vetenskap.addStudent(test);

        System.out.println(vetenskap.getStudentList().size());
        System.out.println(matte.getStudentList().size());
        vetenskap.addStudent(test2);
        vetenskap.addStudent(test);
        System.out.println(vetenskap.getStudentList().size());

         */
    }
}
