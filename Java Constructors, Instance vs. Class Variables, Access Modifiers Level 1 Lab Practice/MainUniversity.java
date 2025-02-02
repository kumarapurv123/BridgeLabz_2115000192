class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    public void displayDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

class PostgraduateStudent extends Student {
    public PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }

    public void displayPostgraduateDetails() {
        System.out.println("Postgraduate Student Name: " + name);
    }
}

public class MainUniversity {
    public static void main(String[] args) {
        Student student = new Student(101, "Alice", 9.0);
        student.displayDetails();
        student.setCGPA(9.5);
        System.out.println("Updated CGPA: " + student.getCGPA());

        PostgraduateStudent pgStudent = new PostgraduateStudent(102, "Bob", 8.5);
        pgStudent.displayPostgraduateDetails();
    }
}