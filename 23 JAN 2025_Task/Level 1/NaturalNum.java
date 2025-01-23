import java.util.Scanner;

public class NaturalNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if (n >= 0) {
            int formulaSum = n * (n + 1) / 2;
            int whileSum = 0;
            int counter = 1;

            while (counter <= n) {
                whileSum += counter;
                counter++;
            }

            if (formulaSum == whileSum) {
                System.out.println(formulaSum + " is equal to " + whileSum);
            } else {
                System.out.println("Not equal");
            }
        } else {
            System.out.println("The number " + n + " is not a natural number");
        }
        sc.close();
    }
}