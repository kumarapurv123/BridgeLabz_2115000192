import java.util.Scanner;

public class TriangularPark {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double side1 = sc.nextDouble();
        double side2 = sc.nextDouble();
        double side3 = sc.nextDouble();
        double perimeter = perimeter(side1, side2, side3);
        int rounds = rounds(perimeter, 5000);
        System.out.println(rounds);
    }

    public static double perimeter(double side1, double side2, double side3) {
        return side1 + side2 + side3;
    }

    public static int rounds(double perimeter, double distance) {
        return (int) Math.ceil(distance / perimeter);
    }
}