class Student {
    private static String universityName = "University";
    private static int totalStudents = 0;
    private final int rollNumber;
    private String name;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    public void displayDetails() {
        if (this instanceof Student) {
            System.out.println("University Name: " + universityName);
            System.out.println("Name: " + name);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Grade: " + grade);
        }
    }
}

public class MainStudent {
    public static void main(String[] args) {
        Student student1 = new Student("Alice", 101, "A");
        Student student2 = new Student("Bob", 102, "B");
        student1.displayDetails();
        student2.displayDetails();
        Student.displayTotalStudents();
    }
}
