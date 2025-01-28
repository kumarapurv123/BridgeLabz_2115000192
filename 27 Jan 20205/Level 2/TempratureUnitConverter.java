public class TempratureUnitConverter {

    public static double FahrenheitToCelsius(double fahrenheit) {
        double fahrenheit2celsius = (fahrenheit - 32) * 5 / 9;
        return fahrenheit2celsius;
    }

    public static double CelsiusToFahrenheit(double celsius) {
        double celsius2fahrenheit = (celsius * 9 / 5) + 32;
        return celsius2fahrenheit;
    }

    public static double PoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }

    public static double KilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }

    public static double GallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }

    public static double LitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }

    public static void main(String[] args) {
        double fahrenheit = 98.6;
        double celsiusFromFahrenheit = FahrenheitToCelsius(fahrenheit);
        System.out.println(fahrenheit + "°F = " + celsiusFromFahrenheit + "°C");

        double celsius = 37.0;
        double fahrenheitFromCelsius = CelsiusToFahrenheit(celsius);
        System.out.println(celsius + "°C = " + fahrenheitFromCelsius + "°F");

        double pounds = 150.0;
        double kgFromPounds = PoundsToKilograms(pounds);
        System.out.println(pounds + " lbs = " + kgFromPounds + " kg");

        double kilograms = 68.0;
        double poundsFromKg = KilogramsToPounds(kilograms);
        System.out.println(kilograms + " kg = " + poundsFromKg + " lbs");

        double gallons = 10.0;
        double litersFromGallons = GallonsToLiters(gallons);
        System.out.println(gallons + " gallons = " + litersFromGallons + " liters");

        double liters = 5.0;
        double gallonsFromLiters = LitersToGallons(liters);
        System.out.println(liters + " liters = " + gallonsFromLiters + " gallons");
    }
}
