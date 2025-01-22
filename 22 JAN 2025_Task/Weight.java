import java.util.Scanner;

public class Weight {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int weightInPounds = input.nextInt();
        double weightInKg = weightInPounds * 2.2;

        System.out.println("The weight of the person in pounds is " + weightInPounds + " and in kg is " + weightInKg);
    }
}