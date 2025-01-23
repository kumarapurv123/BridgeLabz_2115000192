import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        if (number >= 0) {
            int ans = 1;
            int cnt = 1;

            while (cnt <= number) {
                ans *= cnt;
                cnt++;
            }

            System.out.println(ans);
        } else {
            System.out.println("Not a natural number");
        }
        sc.close();
    }
}