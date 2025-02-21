import java.util.Scanner;

public class NestedTryCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = { 10, 20, 30, 40, 50 };

        try {
            int index = scanner.nextInt();

            try {
                int value = numbers[index];

                try {
                    int divisor = scanner.nextInt();

                    int result = value / divisor;
                    System.out.println("Result" + result);
                } catch (ArithmeticException e) {
                    System.out.println("Cannot divide by zero!");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }
        } catch (Exception e) {
            System.out.println("Invalid input Please enter a valid number.");
        } finally {
            scanner.close();
        }
    }
}
