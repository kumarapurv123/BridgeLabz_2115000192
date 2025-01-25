import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of persons: ");
        int numPersons = sc.nextInt();
        double[] weights = new double[numPersons];
        double[] heights = new double[numPersons];
        double[] bmis = new double[numPersons];
        String[] statuses = new String[numPersons];
        for (int i = 0; i < numPersons; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            weights[i] = sc.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            heights[i] = sc.nextDouble() / 100;
            bmis[i] = weights[i] / (heights[i] * heights[i]);
            if (bmis[i] <= 18.4) {
                statuses[i] = "Underweight";
            } else if (bmis[i] <= 24.9) {
                statuses[i] = "Normal";
            } else if (bmis[i] <= 39.9) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obese";
            }
        }
        for (int i = 0; i < numPersons; i++) {
            System.out.println("Person " + (i + 1) + ": Height = " + heights[i] * 100 + " cm, Weight = " + weights[i]
                    + " kg, BMI = " + bmis[i] + ", Status = " + statuses[i]);
        }
    }
}