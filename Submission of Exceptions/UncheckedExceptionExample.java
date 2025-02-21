import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedExceptionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int numerator = scanner.nextInt();

            int denominator = scanner.nextInt();

            int result = numerator / denominator;
            System.out.println(result);

        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input! Please enter numeric values");
        } finally {
            scanner.close();
        }
    }
}
