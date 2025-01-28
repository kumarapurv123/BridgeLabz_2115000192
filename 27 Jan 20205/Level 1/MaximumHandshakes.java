import java.util.Scanner;

public class MaximumHandshakes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = scanner.nextInt();
        int maxHandshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;
        System.out.println(
                "The maximum number of handshakes among " + numberOfStudents + " students is: " + maxHandshakes);
        scanner.close();
    }
}
