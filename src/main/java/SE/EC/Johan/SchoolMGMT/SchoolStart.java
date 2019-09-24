package SE.EC.Johan.SchoolMGMT;

import SE.EC.Johan.SchoolMGMT.data.CourseDaoList;
import SE.EC.Johan.SchoolMGMT.data.StudentDaoList;
import SE.EC.Johan.SchoolMGMT.model.Course;
import SE.EC.Johan.SchoolMGMT.model.Student;

import java.time.LocalDate;
import java.util.Scanner;

public class SchoolStart {

    private static CourseDaoList courseList = new CourseDaoList();
    private static StudentDaoList studentList = new StudentDaoList();

    public static Scanner scanner = new Scanner(System.in);

    public static void schoolStart(){
        System.out.println("                  Welcome to Folsom High!");
        boolean runMeny = true;
        while (runMeny){
            System.out.println("__________________________________________________________________\n" +
                    "|1. Create a new student.      2. Create a new course.           |\n" +
                    "|3. Add a student to a course. 4. Remove a student from a course.|\n" +
                    "|5. Find a student.            6. Find a course.                 |\n" +
                    "|7. Edit a student.            8. Edit a course.                 |\n" +
                    "|9. Exit.                                                        |\n" +
                    "‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");

            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input == 1) {
                    createStudent();
                    break;
                }
                if (input == 2) {
                    createCourse();
                    break;
                }
                if (input == 3) {
                    addToCourse();
                    break;
                }
                if (input == 4) {
                    removeFromCourse();
                    break;
                }
                if (input == 5) {
                    findStudent();
                    break;
                }
                if (input == 6) {
                    findCourse();
                    break;
                }
                if (input == 7) {
                    editStudent();
                    break;
                }
                if (input == 8) {
                    editCourse();
                    break;
                }
                if (input == 9) {
                    createStudent();
                    break;
                } else {
                    System.out.println("Invalid input, please make selection 1-9");
                }
            }catch (NumberFormatException e){
                System.out.println("Invalid input, please make selection 1-9");
            }
        }
    }

    public static void createStudent(){
        System.out.println("Enter full name:");
        String name = scanner.nextLine();
        System.out.println("Enter emailadress:");
        String email = scanner.nextLine();
        System.out.println("Enter adress:");
        String adress = scanner.nextLine();

        Student tempStudent = new Student(name,email,adress);
        studentList.saveStudent(tempStudent);

        System.out.println(tempStudent.toString());
    }
    public static void createCourse(){
        System.out.println("Enter course name: ");
        scanner.nextLine();
        String courseName = scanner.nextLine();
        System.out.println("Enter start date (YYYY-MM-DD) ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Enter number of weeks: ");
        int duration = scanner.nextInt();

        Course tempCourse = new Course(courseName,startDate,duration);
        courseList.saveCourse(tempCourse);
    }

    public static void addToCourse(){
    }
    public static void removeFromCourse(){
    }
    public static void findStudent(){
    }
    public static void findCourse(){
    }
    public static void editStudent(){
    }
    public static void editCourse(){
    }

}


