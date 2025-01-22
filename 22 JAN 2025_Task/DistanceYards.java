import java.util.Scanner;

public class DistanceYards {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double distanceInFeet = input.nextDouble();
        int feetToYards = 3;
        int yardsToMiles = 1760;
        double distanceYards = distanceInFeet / feetToYards;
        double distanceMiles = distanceYards / yardsToMiles;
        System.out.println("The distance in yards is " + distanceYards + " yards");
        System.out.println("The distance in miles is " + distanceMiles + " miles");
        input.close();
    }
}