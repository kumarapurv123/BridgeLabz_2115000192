import java.util.Scanner;

class Circle {
    private double radius;

    public Circle() {
        this(1.0);
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    public void displayDetails() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calculateArea());
        System.out.println("Circumference: " + calculateCircumference());
    }
}

public class MainCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("radius of the Circle");
        double radius = sc.nextDouble();

        Circle defaultCircle = new Circle();
        Circle parameterizedCircle = new Circle(radius);

        defaultCircle.displayDetails();
        parameterizedCircle.displayDetails();
    }
}