import java.util.Scanner;

public class GCD_LCM {

    public static int getInput(Scanner sc, String prompt) {
        return sc.nextInt();
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = getInput(sc, "Enter first number: ");
        int n2 = getInput(sc, "Enter second number: ");

        int gcdResult = gcd(n1, n2);
        int lcmResult = lcm(n1, n2);

        System.out.println("GCD of " + n1 + " and " + n2 + " is: " + gcdResult);
        System.out.println("LCM of " + n1 + " and " + n2 + " is: " + lcmResult);

        sc.close();
    }
}
