import java.util.Scanner;

public class calculateWindChillCalculator {

    public static double WindChill(double temp, double windSpeed) {
        return 35.74 + 0.6215 * temp + (0.4275 * temp - 35.75) * Math.pow(windSpeed, 0.16);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double temperature = scanner.nextDouble();
        double windSpeed = scanner.nextDouble();
        double windChill = WindChill(temperature, windSpeed);
        System.out.println("The wind chill temperature is: " + windChill);
        scanner.close();
    }
}
