package SE.EC.Johan.SchoolMGMT.model;

public class Student {

    private static int studentCounter;
    private int studentId;
    private String name;
    private String email;
    private String adress;

    public Student(int studentId, String name, String email, String adress) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.adress = adress;
    }

    public Student(String name, String email, String adress) {
        this (++studentCounter, name, email, adress);
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "<StudentId: " + studentId +
                " - Name: " + name +
                " - Email: " + email  +
                " - Adress: " + adress + ">";
    }
}
