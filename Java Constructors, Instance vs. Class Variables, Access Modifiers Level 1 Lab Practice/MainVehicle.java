import java.util.Scanner;

class Vehicle {
    private String ownerName;
    private String vehicleType;
    private static double registrationFee = 500.00;

    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
}

public class MainVehicle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Owner Name:");
        String ownerName1 = sc.nextLine();
        System.out.println("Enter the Vehicle Type:");
        String vehicleType1 = sc.nextLine();

        System.out.println("Enter the Owner Name:");
        String ownerName2 = sc.nextLine();
        System.out.println("Enter the Vehicle Type:");
        String vehicleType2 = sc.nextLine();

        Vehicle vehicle1 = new Vehicle(ownerName1, vehicleType1);
        Vehicle vehicle2 = new Vehicle(ownerName2, vehicleType2);

        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();

        System.out.println("Enter the new Registration Fee:");
        double newFee = sc.nextDouble();
        Vehicle.updateRegistrationFee(newFee);

        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();
    }
}