import java.util.Scanner;

public class MaxOfThree {

    public static int getInput(Scanner scanner) {
        return scanner.nextInt();
    }

    public static int findMaximum(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = getInput(scanner);
        int b = getInput(scanner);
        int c = getInput(scanner);

        int maxValue = findMaximum(a, b, c);
        System.out.println("The maximum number is: " + maxValue);

        scanner.close();
    }
}
