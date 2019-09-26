package SE.EC.Johan.SchoolMGMT;

import SE.EC.Johan.SchoolMGMT.data_access.CourseDaoList;
import SE.EC.Johan.SchoolMGMT.data_access.StudentDaoList;
import SE.EC.Johan.SchoolMGMT.model.Course;
import SE.EC.Johan.SchoolMGMT.model.Student;

import java.time.LocalDate;
import java.util.Scanner;

public class SchoolStart {

    public static Student firstFillStudent;
    public static Student secondFillStudent;
    public static Course firstFillCourse;
    public static Course secondFillCourse;

    private static CourseDaoList courseList = new CourseDaoList();
    private static StudentDaoList studentList = new StudentDaoList();

    private static Scanner scanner = new Scanner(System.in);

    public static void fillSchoolWithStudentsAndCourses(){

        firstFillStudent = new Student("Johan Hansson", "simman@rocketmail.com", "Lingonstigen 1");
        secondFillStudent = new Student("Olle Berg","olle@gmail.com", "Bollibompavägen 3");
        firstFillCourse = new Course("Vetenskap", LocalDate.of(2020, 10, 10), 10);
        secondFillCourse = new Course("Matematik",  LocalDate.of(2019, 11, 15), 4);

        studentList.saveStudent(firstFillStudent);
        studentList.saveStudent(secondFillStudent);
        courseList.saveCourse(firstFillCourse);
        courseList.saveCourse(secondFillCourse);
    }

    public static void schoolStart(){

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
                    System.out.println("Quitting.");
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
        System.out.println("Find student by:\n1. ID\n2. Name\n3. Email\n4. Show all students");
        int input = Integer.parseInt(scanner.nextLine());
        if(input == 1) {
            System.out.println("Enter student ID: ");
            int idInput = Integer.parseInt(scanner.nextLine());
            System.out.println(studentList.findById(idInput).toString());
        }
        if(input == 2) {
            System.out.println("Enter student name: ");
            String nameInput = scanner.nextLine();
            System.out.println(studentList.findByName(nameInput).toString());
        }
        if (input == 3) {
            System.out.println("Enter student email: ");
            String emailInput = scanner.nextLine();
            System.out.println(studentList.findByEmail(emailInput));
        }
        if(input == 4) {
            System.out.println(studentList.findAll().toString());
        }
        schoolStart();
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
        System.out.println("All students:");
        for (Student student : studentList.findAll()){
            System.out.println("Student ID: "+student.getStudentId() + " - " + student.getName());
        }
        System.out.println("Enter ID of student you want to edit:");
        int studentId = Integer.parseInt(scanner.nextLine());
        System.out.println("Selected student: [" + studentList.findById(studentId).getStudentId() + " - " + studentList.findById(studentId).getName()
                            + "]" + "\n1. Change name.\n2. Change email.\n3. Change adress.\n4. Remove student.");
        int input = Integer.parseInt(scanner.nextLine());
        if (input == 1){
            System.out.println("Enter new name:");
            String newName = scanner.nextLine();
            studentList.findById(studentId).setName(newName);
            System.out.println("Name changed to: " + studentList.findById(studentId).getName());
        }
        if (input == 2){
            System.out.println("Enter new email:");
            String newEmail = scanner.nextLine();
            studentList.findById(studentId).setEmail(newEmail);
            System.out.println("Email changed to: " + studentList.findById(studentId).getEmail());
        }
        if (input == 3){
            System.out.println("Enter new adress:");
            String newAdress = scanner.nextLine();
            studentList.findById(studentId).setAdress(newAdress);
            System.out.println("Adress changed to: " + studentList.findById(studentId).getAdress());
        }
        if (input == 4){
            System.out.println("Are you sure you want to delete: [" + studentList.findById(studentId).getStudentId() + " - "
                                + studentList.findById(studentId).getName() + "]\n1. Yes\n2. No");
            int input2 = Integer.parseInt(scanner.nextLine());
            if(input2 == 1){
                System.out.println("[" + studentList.findById(studentId).getName() + "] is deleted.");
                studentList.deleteStudent(studentList.findById(studentId));
            }
            if(input2 == 2){
                System.out.println("Returning to main menu.");
            }
        }
        schoolStart();
    }

    public static void editCourse(){
        System.out.println("All courses:");
        for (Course course : courseList.findAll()){
            System.out.println("Course ID: "+course.getCourseId() + " - " + course.getCourseName());
        }
        System.out.println("Enter ID of course you want to edit:");
        int courseId = Integer.parseInt(scanner.nextLine());
        System.out.println("Selected course: [" + courseList.findById(courseId).getCourseId() + " - " + courseList.findById(courseId).getCourseName()
                + "]" + "\n1. Change name.\n2. Change start date.\n3. Change duration.\n4. Remove course.");
        int input = Integer.parseInt(scanner.nextLine());
        if (input == 1){
            System.out.println("Enter new name:");
            String newName = scanner.nextLine();
            courseList.findById(courseId).setCourseName(newName);
            System.out.println("Name changed to: " + courseList.findById(courseId).getCourseName());
        }
        if (input == 2){
            System.out.println("Enter new start date: (YYYY-MM-DD)");
            LocalDate newStartDate = LocalDate.parse(scanner.nextLine());
            courseList.findById(courseId).setStartDate(newStartDate);
            System.out.println("Start date changed to: " + courseList.findById(courseId).getStartDate());
        }
        if (input == 3){
            System.out.println("Enter new duration:");
            int newDuration = Integer.parseInt(scanner.nextLine());
            courseList.findById(courseId).setWeekDuration(newDuration);
            System.out.println("Duration changed to: " + courseList.findById(courseId).getWeekDuration());
        }
        if (input == 4){
            System.out.println("Are you sure you want to delete: [" + courseList.findById(courseId).getCourseId() + " - "
                    + courseList.findById(courseId).getCourseName() + "]\n1. Yes\n2. No");
            int input2 = Integer.parseInt(scanner.nextLine());
            if(input2 == 1){
                System.out.println("[" + courseList.findById(courseId).getCourseName() + "] is deleted.");
                courseList.removeCourse(courseList.findById(courseId));
            }
            if(input2 == 2){
                System.out.println("Returning to main menu.");
            }
        }
        schoolStart();
    }
}


