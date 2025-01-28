import java.util.Scanner;

public class Handshake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int maxHandshakes = calculateHandshakes(n);
        System.out.printf("The maximum number of handshakes among %d students is %d.%n", n, maxHandshakes);
        scanner.close();
    }

    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }
}
