import java.util.Scanner;

public class QuotientAndRemainder {
    public static int[] findRemainderAndQuotient(int num, int divisor) {
        int quotient = num / divisor;
        int rem = num % divisor;
        return new int[] { quotient, rem };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int divisor = scanner.nextInt();
        int[] res = findRemainderAndQuotient(number, divisor);
        System.out.println("The quotient is: " + res[0]);
        System.out.println("The remainder is: " + res[1]);
        scanner.close();
    }
}
