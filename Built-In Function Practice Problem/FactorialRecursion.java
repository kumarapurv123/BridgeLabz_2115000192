import java.util.Scanner;

public class FactorialRecursion {

    public static int getInput(Scanner scanner) {
        return scanner.nextInt();
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = getInput(sc);
        int result = factorial(num);

        System.out.println("The factorial of " + num + " is: " + result);

        sc.close();
    }
}