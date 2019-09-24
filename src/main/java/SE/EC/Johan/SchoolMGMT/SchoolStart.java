package SE.EC.Johan.SchoolMGMT;

import SE.EC.Johan.SchoolMGMT.data.CourseDaoList;
import SE.EC.Johan.SchoolMGMT.data.StudentDaoList;
import SE.EC.Johan.SchoolMGMT.model.Course;
import SE.EC.Johan.SchoolMGMT.model.Student;

import java.time.LocalDate;
import java.util.Scanner;

public class SchoolStart {

    public static Student temp1;
    public static Student temp2;
    public static Course temp3;
    public static Course temp4;

    private static CourseDaoList courseList = new CourseDaoList();
    private static StudentDaoList studentList = new StudentDaoList();

    public static Scanner scanner = new Scanner(System.in);

    public static void schoolStart(){

        temp1 = new Student("Johan Hansson", "simman@rocketmail.com", "Lingonstigen 1");
        temp2 = new Student("Olle Berg","olle@gmail.com", "Bollibompavägen 3");
        temp3 = new Course("Vetenskap", LocalDate.of(2020, 10, 10), 10);
        temp4 = new Course("Matematik",  LocalDate.of(2019, 11, 15), 4);

        studentList.saveStudent(temp1);
        studentList.saveStudent(temp2);
        courseList.saveCourse(temp3);
        courseList.saveCourse(temp4);

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
                    System.out.println();
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

        schoolStart();
    }

    public static void createCourse(){
        System.out.println("Enter course name: ");
        String courseName = scanner.nextLine();
        System.out.println("Enter start date (YYYY-MM-DD) ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Enter number of weeks: ");
        int duration = Integer.parseInt(scanner.nextLine());

        Course tempCourse = new Course(courseName,startDate,duration);
        courseList.saveCourse(tempCourse);

        schoolStart();
    }

    public static void addToCourse(){
        System.out.println("Available courses:");
        for (Course course:courseList.findAll()){
            System.out.println("Course ID: "+course.getCourseId() + " - " + course.getCourseName());
        }
        System.out.println("Enter the ID number of the desired course: ");
        int courseInput = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the ID of the student: ");
        int studentInput = Integer.parseInt(scanner.nextLine());
        courseList.findById(courseInput).addStudent(studentList.findById(studentInput));

        schoolStart();
    }
    public static void removeFromCourse(){
        System.out.println("Available courses:");
        for (Course course:courseList.findAll()){
            System.out.println("Course ID: "+course.getCourseId() + " - " + course.getCourseName());
        }
        System.out.println("Enter the ID number of the desired course: ");
        int courseInput = Integer.parseInt(scanner.nextLine());
        System.out.println("Students in " + courseList.findById(courseInput).getCourseName() + courseList.findById(courseInput).getStudentList().toString());
        System.out.println("Enter the ID of the student to remove: ");
        int studentInput = Integer.parseInt(scanner.nextLine());
        courseList.findById(courseInput).removeStudent(studentList.findById(studentInput));

        schoolStart();

    }
    public static void findStudent(){
    }
    public static void findCourse(){
        System.out.println("Find course by:\n1. ID\n2. Name\n3. Startdate\n4. Show all courses");
        int input = Integer.parseInt(scanner.nextLine());

        if(input == 1) {
            System.out.println("Enter course ID: ");
            int idInput = Integer.parseInt(scanner.nextLine());
            System.out.println(courseList.findById(idInput).toString());
        }

        if(input == 2) {
            System.out.println("Enter course name: ");
            String nameInput = scanner.nextLine();
            System.out.println(courseList.findByName(nameInput).toString());
        }
        if (input == 3) {
            System.out.println("Enter course startdate: (YYYY-MM-DD)");
            LocalDate dateInput = LocalDate.parse(scanner.nextLine());
            System.out.println(courseList.findByDate(dateInput));
        }
        if(input == 4) {
            System.out.println(courseList.findAll().toString());
        }
        schoolStart();
    }
    public static void editStudent(){
    }
    public static void editCourse(){
    }

}


