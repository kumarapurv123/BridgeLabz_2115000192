import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int originalNumber = number;
        int sum = 0;
        while (originalNumber != 0) {
            int remainder = originalNumber % 10;
            sum += Math.pow(remainder, 3);
            originalNumber /= 10;
        }
        if (sum == number) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }
        scanner.close();
    }
}