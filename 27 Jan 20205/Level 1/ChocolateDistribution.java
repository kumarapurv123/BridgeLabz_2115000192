import java.util.Scanner;

public class ChocolateDistribution {

    public static int[] ChocolatesPerChildAndRemaining(int numOfChocolates, int numOfChildren) {
        int chocolatesPerChild = numOfChocolates / numOfChildren;
        int remainingChocolates = numOfChocolates % numOfChildren;
        return new int[] { chocolatesPerChild, remainingChocolates };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfChocolates = sc.nextInt();
        int numberOfChildren = sc.nextInt();
        int[] result = ChocolatesPerChildAndRemaining(numberOfChocolates, numberOfChildren);
        System.out.println("Each child will get: " + result[0] + " chocolates.");
        System.out.println("Remaining chocolates: " + result[1]);
        sc.close();
    }
}
