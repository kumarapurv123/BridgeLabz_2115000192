import java.util.Scanner;

public class Quadratic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        double[] roots = findRoots(a, b, c);

        if (roots.length == 0) {
            System.out.println("The equation has no real roots.");
        } else if (roots.length == 1) {
            System.out.println("The equation has one root: " + roots[0]);
        } else {
            System.out.println("The equation has two roots: " + roots[0] + " and " + roots[1]);
        }
    }

    public static double[] findRoots(double a, double b, double c) {
        double delta = Math.pow(b, 2) - 4 * a * c;

        if (delta < 0) {
            return new double[0];
        } else if (delta == 0) {
            double root = -b / (2 * a);
            return new double[] { root };
        } else {
            double sqrtDelta = Math.sqrt(delta);
            double root1 = (-b + sqrtDelta) / (2 * a);
            double root2 = (-b - sqrtDelta) / (2 * a);
            return new double[] { root1, root2 };
        }
    }
}