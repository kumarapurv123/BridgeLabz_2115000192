import java.util.Scanner;

public class SumZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0;
        int number;
        while ((number = sc.nextInt()) != 0) {
            total += number;
        }
        System.out.println("The total sum is: " + total);
        sc.close();
    }
}