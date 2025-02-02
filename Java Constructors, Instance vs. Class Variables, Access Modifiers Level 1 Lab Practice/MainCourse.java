import java.util.Scanner;

class Course {
    private String courseName;
    private int duration;
    private double fee;
    private static String instituteName = "Tech Institute";

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: " + fee);
        System.out.println("Institute Name: " + instituteName);
    }

    public static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }
}

public class MainCourse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(" Course Name:");
        String courseName1 = sc.nextLine();
        System.out.println("Duration (in weeks):");
        int duration1 = sc.nextInt();
        System.out.println(" Fee:");
        double fee1 = sc.nextDouble();
        sc.nextLine();

        System.out.println("Enter the Course Name:");
        String courseName2 = sc.nextLine();
        System.out.println("Enter the Duration (in weeks):");
        int duration2 = sc.nextInt();
        System.out.println("Enter the Fee:");
        double fee2 = sc.nextDouble();
        sc.nextLine();
        Course course1 = new Course(courseName1, duration1, fee1);
        Course course2 = new Course(courseName2, duration2, fee2);

        course1.displayCourseDetails();
        course2.displayCourseDetails();

        String newInstituteName = sc.nextLine();
        Course.updateInstituteName(newInstituteName);

        course1.displayCourseDetails();
        course2.displayCourseDetails();
    }
}