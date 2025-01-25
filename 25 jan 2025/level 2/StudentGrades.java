import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numStudents = sc.nextInt();
        int[][] marks = new int[numStudents][3];
        double[] percentages = new double[numStudents];
        String[] grades = new String[numStudents];
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter marks for student " + (i + 1) + ":");
            System.out.print("Physics: ");
            marks[i][0] = sc.nextInt();
            while (marks[i][0] < 0) {
                System.out.print("Invalid marks. Enter positive value: ");
                marks[i][0] = sc.nextInt();
            }
            System.out.print("Chemistry: ");
            marks[i][1] = sc.nextInt();
            while (marks[i][1] < 0) {
                System.out.print("Invalid marks. Enter positive value: ");
                marks[i][1] = sc.nextInt();
            }
            System.out.print("Maths: ");
            marks[i][2] = sc.nextInt();
            while (marks[i][2] < 0) {
                System.out.print("Invalid marks. Enter positive value: ");
                marks[i][2] = sc.nextInt();
            }
            int totalMarks = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = totalMarks / 3.0;

            if (percentages[i] >= 80) {
                grades[i] = "A";
            } else if (percentages[i] >= 70) {
                grades[i] = "B";
            } else if (percentages[i] >= 60) {
                grades[i] = "C";
            } else if (percentages[i] >= 50) {
                grades[i] = "D";
            } else if (percentages[i] >= 40) {
                grades[i] = "E";
            } else {
                grades[i] = "R";
            }
        }
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Student " + (i + 1) + ": Physics = " + marks[i][0] + ", Chemistry = " + marks[i][1]
                    + ", Maths = " + marks[i][2] + ", Percentage = " + percentages[i] + ", Grade = " + grades[i]);
        }
    }
}