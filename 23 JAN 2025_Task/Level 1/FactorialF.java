import java.util.Scanner;

public class FactorialF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if (number >= 0) {
            int ans = 1;
            int cnt = 1;
            for (int i = 1; i <= number; i++) {
                ans *= i;
            }
            System.out.println(ans);
        } else {
            System.out.println("Not a natural number");
        }
        sc.close();
    }
}