import java.util.ArrayList;
import java.util.List;

class School {
    private String name;
    private List<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        System.out.println("School: " + name);
        for (Student student : students) {
            student.viewCourses();
        }
    }
}

class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollInCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
    }

    public void viewCourses() {
        System.out.println("Student: " + name + " is enrolled in:");
        for (Course course : courses) {
            System.out.println("Course: " + course.getName());
        }
    }
}

class Course {
    private String name;
    private List<Student> students;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public String getName() {
        return name;
    }

    public void displayStudents() {
        System.out.println("Course: " + name + " has students:");
        for (Student student : students) {
            System.out.println("Student: " + student.getName());
        }
    }
}

public class SchoolDemo {
    public static void main(String[] args) {
        School school = new School("MPS");

        Student student1 = new Student("Amit");
        Student student2 = new Student("Apurv");

        Course course1 = new Course("Mathematics");
        Course course2 = new Course("Science");

        student1.enrollInCourse(course1);
        student1.enrollInCourse(course2);
        student2.enrollInCourse(course1);

        school.addStudent(student1);
        school.addStudent(student2);

        school.displayStudents();
        course1.displayStudents();
        course2.displayStudents();
    }
}
