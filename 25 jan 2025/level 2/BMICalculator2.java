import java.util.Scanner;

public class BMICalculator2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];
        for (int i = 0; i < number; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            personData[i][0] = sc.nextDouble();
            while (personData[i][0] <= 0) {
                System.out.print("Invalid weight. Enter a positive value: ");
                personData[i][0] = sc.nextDouble();
            }
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            personData[i][1] = sc.nextDouble() / 100;
            while (personData[i][1] <= 0) {
                System.out.print("Invalid height. Enter a positive value: ");
                personData[i][1] = sc.nextDouble() / 100;
            }
            personData[i][2] = personData[i][0] / (personData[i][1] * personData[i][1]);
            if (personData[i][2] <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1) + ": Height = " + personData[i][1] * 100 + " cm, Weight = "
                    + personData[i][0] + " kg, BMI = " + personData[i][2] + ", Status = " + weightStatus[i]);
        }
    }
}