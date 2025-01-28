import java.util.Scanner;

public class NaturalNumberSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Enter a natural number.");
        } else {
            int sum = calculateSum(n);
            System.out.println(sum);
        }
    }

    public static int calculateSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}