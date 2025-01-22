import java.util.Scanner;

public class AthleteRun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int side1 = scanner.nextInt();
        int side2 = scanner.nextInt();
        int side3 = scanner.nextInt();
        int perimeter = side1 + side2 + side3;
        int totalDistance = 5000;
        int rounds = totalDistance / perimeter;
        System.out.println("The total number of rounds the athlete will run is " + rounds + " to complete 5 km.");
        scanner.close();
    }
}
