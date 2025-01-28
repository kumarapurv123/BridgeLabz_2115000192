import java.util.Scanner;

public class NaturalNumbers {
    public static int sumUsingRecursion(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumUsingRecursion(n - 1);
    }

    public static int sumUsingFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("Please enter a valid natural number greater than 0.");
            return;
        }
        int sumRecursion = sumUsingRecursion(n);
        int sumFormula = sumUsingFormula(n);
        System.out.println("Sum using recursion: " + sumRecursion);
        System.out.println("Sum using formula: " + sumFormula);
        if (sumRecursion == sumFormula) {
            System.out.println("The results match, both computations are correct.");
        } else {
            System.out.println("The results do not match.");
        }
        scanner.close();
    }
}
