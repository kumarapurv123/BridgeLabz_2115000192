public class UnitConverter2 {

    public static double YardsToFeet(double yards) {
        double yards2feet = 3;
        return yards * yards2feet;
    }

    public static double FeetToYards(double feet) {
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }

    public static double MetersToInches(double meters) {
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }

    public static double InchesToMeters(double inches) {
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }

    public static double InchesToCentimeters(double inches) {
        double inches2cm = 2.54;
        return inches * inches2cm;
    }

    public static void main(String[] args) {
        double yards = 5.0;
        double feetFromYards = YardsToFeet(yards);
        System.out.println(yards + " yards = " + feetFromYards + " feet");

        double feet = 15.0;
        double yardsFromFeet = FeetToYards(feet);
        System.out.println(feet + " feet = " + yardsFromFeet + " yards");

        double meters = 3.0;
        double inchesFromMeters = MetersToInches(meters);
        System.out.println(meters + " meters = " + inchesFromMeters + " inches");

        double inches = 50.0;
        double metersFromInches = InchesToMeters(inches);
        System.out.println(inches + " inches = " + metersFromInches + " meters");

        double inchesToCm = InchesToCentimeters(inches);
        System.out.println(inches + " inches = " + inchesToCm + " centimeters");
    }
}
