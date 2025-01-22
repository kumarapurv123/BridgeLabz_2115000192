import java.util.Scanner;

public class Quotient {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int n1 = input.nextInt();
        int n2 = input.nextInt();
        int quotient = n1 / n2;
        int remainder = n1 % n2;

        System.out.println("The Quotient is " + quotient + " and Remainder is " + remainder + " of two numbers " + n1
                + " and " + n2);
    }
}