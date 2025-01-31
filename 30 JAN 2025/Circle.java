public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        System.out.println("Radius of circle is:" + radius);
        return this.radius;
    }

    public void setRadius(double newRadius) {
        this.radius = newRadius;
    }

    public double area() {
        System.out.println("Area of circle with radius " + this.radius + " is : " + Math.PI * radius * radius);
        return Math.PI * radius * radius;
    }

    public double circumference() {
        System.out.println("Circumference of circle with radius " + this.radius + " is : " + 2 * Math.PI * radius);
        return 2 * Math.PI * radius;
    }
}