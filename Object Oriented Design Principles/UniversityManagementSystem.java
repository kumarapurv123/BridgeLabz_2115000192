import java.util.ArrayList;
import java.util.List;

class Course {
    private String courseName;
    private Professor professor;
    private List<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void enrollStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }
}

class Professor {
    private String name;

    public Professor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void assignToCourse(Course course) {
        course.assignProfessor(this);
    }

    public void teachCourse(Course course) {
        System.out.println("Professor " + name + " teaching : " + course.getCourseName());
    }
}

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void enrollInCourse(Course course) {
        course.enrollStudent(this);
        System.out.println("Student " + name + " has enrolled in the course: " + course.getCourseName());
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        Professor professor1 = new Professor("Faculty1");
        Professor professor2 = new Professor("Faculty2");

        Student student1 = new Student("Student1");
        Student student2 = new Student("Student2");

        Course course1 = new Course("Computer Science 101");
        Course course2 = new Course("Data Structures");

        professor1.assignToCourse(course1);
        professor2.assignToCourse(course2);

        student1.enrollInCourse(course1);
        student2.enrollInCourse(course2);

        System.out.println("Students enrolled in " + course1.getCourseName() + ":");
        for (Student student : course1.getStudents()) {
            System.out.println(student.getName());
        }

        System.out.println("Students enrolled in " + course2.getCourseName() + ":");
        for (Student student : course2.getStudents()) {
            System.out.println(student.getName());
        }

        professor1.teachCourse(course1);
        professor2.teachCourse(course2);
    }
}
