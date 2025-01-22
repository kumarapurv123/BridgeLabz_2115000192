import java.util.Scanner;

public class UniversityDiscount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int fee = input.nextInt();
        double discountPercent = input.nextDouble();
        double discount = (fee * discountPercent) / 100;
        double finalFee = fee - discount;
        System.out
                .println("The discount amount is INR " + discount + " and the final discounted fee is INR " + finalFee);
        input.close();
    }
}