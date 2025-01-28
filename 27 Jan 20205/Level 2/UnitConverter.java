public class UnitConverter {

    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }

    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }

    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }

    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }

    public static void main(String[] args) {
        double km = 5.0;
        double miles = convertKmToMiles(km);
        System.out.println(km + " km = " + miles + " miles");

        double meters = 10.0;
        double feet = convertMetersToFeet(meters);
        System.out.println(meters + " meters = " + feet + " feet");

        double milesToConvert = 3.0;
        double kmConverted = convertMilesToKm(milesToConvert);
        System.out.println(milesToConvert + " miles = " + kmConverted + " km");

        double feetToConvert = 20.0;
        double metersConverted = convertFeetToMeters(feetToConvert);
        System.out.println(feetToConvert + " feet = " + metersConverted + " meters");
    }
}
