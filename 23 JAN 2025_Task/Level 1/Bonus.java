import java.util.Scanner;

public class Bonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int salary = sc.nextInt();
        int serviceYear = sc.nextInt();

        double bonus = 0;

        if (serviceYear > 5) {
            bonus = salary * 0.05;
        }
        System.out.println(bonus);
        sc.close();
    }
}