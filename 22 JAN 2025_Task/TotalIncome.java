import java.util.Scanner;

public class TotalIncome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double salary = input.nextInt();
        double bonus = input.nextInt();
        double totalIncome = salary + bonus;
        System.out.println("The salary is INR " + salary + " and bonus is INR " + bonus + ". Hence Total Income is INR "
                + totalIncome + ".");
        input.close();
    }
}