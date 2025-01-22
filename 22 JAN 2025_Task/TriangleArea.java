import java.util.Scanner;

public class TriangleArea {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int base = input.nextInt();
        int height = input.nextInt();
        double area = 0.5 * base * height;

        double areaCm = area * 6.4516;
        System.out.println("The area of the triangle is " + areaCm + " square cm");
    }
}