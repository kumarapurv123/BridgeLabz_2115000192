import java.util.Scanner;

public class FinallyBlock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter num ");
            int numerator = scanner.nextInt();

            System.out.print("Enter den ");
            int denominator = scanner.nextInt();

            int result = numerator / denominator;
            System.out.println("Result" + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        } catch (Exception e) {
            System.out.println("Please enter numeric values.");
        } finally {
            System.out.println("Operation completed.");
            scanner.close();
        }
    }
}
