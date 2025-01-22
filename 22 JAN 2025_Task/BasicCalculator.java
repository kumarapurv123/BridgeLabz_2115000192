import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int number1 = input.nextInt();
        System.out.print("Enter the second number: ");
        int number2 = input.nextInt();
        int addition = number1 + number2;
        int subtraction = number1 - number2;
        int multiplication = number1 * number2;
        int division = number1 / number2;
        System.out.println("The addition of " + number1 + " and " + number2 + " is: " + addition);
        System.out.println("The subtraction of " + number1 + " and " + number2 + " is: " + subtraction);
        System.out.println("The multiplication of " + number1 + " and " + number2 + " is: " + multiplication);
        System.out.println("The division of " + number1 + " and " + number2 + " is: " + division);
        input.close();
    }
}
