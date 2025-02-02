import java.util.Scanner;

class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double dailyRate;

    public CarRental() {
        this.customerName = "";
        this.carModel = "";
        this.rentalDays = 0;
        this.dailyRate = 0.0;
    }

    public CarRental(String customerName, String carModel, int rentalDays, double dailyRate) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.dailyRate = dailyRate;
    }

    public void displayDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: " + calculateTotalCost());
    }

    public double calculateTotalCost() {
        return rentalDays * dailyRate;
    }
}

public class MainCarRental {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Customer Name");
        String customerName = sc.nextLine();
        System.out.println("Enter the Car Model");
        String carModel = sc.nextLine();
        System.out.println("Enter the Number of Rental Days");
        int rentalDays = sc.nextInt();
        System.out.println("Enter the Daily Rate");
        double dailyRate = sc.nextDouble();
        CarRental defaultRental = new CarRental();
        CarRental parameterizedRental = new CarRental(customerName, carModel, rentalDays, dailyRate);
        defaultRental.displayDetails();
        parameterizedRental.displayDetails();
    }
}