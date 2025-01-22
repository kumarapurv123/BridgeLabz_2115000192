import java.util.Scanner;

public class TotalPrice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int unitPrice = input.nextInt();
        int quantity = input.nextInt();
        int totalPrice = unitPrice * quantity;
        System.out.println("The total purchase price is INR " + totalPrice +
                " if the quantity is " + quantity + " and the unit price is INR " + unitPrice);
        input.close();
    }
}