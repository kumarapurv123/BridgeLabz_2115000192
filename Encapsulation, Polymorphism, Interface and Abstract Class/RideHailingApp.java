interface GPS {
    String getCurrentLocation();

    void updateLocation(String newLocation);
}

abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    public Vehicle(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = currentLocation;
    }

    public abstract double calculateFare(double distance);

    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate per Km: " + ratePerKm;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }
}

class Car extends Vehicle implements GPS {
    public Car(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() {
        return "Car's current location is being tracked.";
    }

    @Override
    public void updateLocation(String newLocation) {
        System.out.println("Car location updated to: " + newLocation);
    }
}

class Bike extends Vehicle implements GPS {
    public Bike(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() {
        return "Bike's current location is being tracked.";
    }

    @Override
    public void updateLocation(String newLocation) {
        System.out.println("Bike location updated to: " + newLocation);
    }
}

class Auto extends Vehicle implements GPS {
    public Auto(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() {
        return "Auto's current location is being tracked.";
    }

    @Override
    public void updateLocation(String newLocation) {
        System.out.println("Auto location updated to: " + newLocation);
    }
}

public class RideHailingApp {
    public static void processRide(Vehicle vehicle, double distance) {
        System.out.println(vehicle.getVehicleDetails() + ", Fare: " + vehicle.calculateFare(distance));
    }

    public static void main(String[] args) {
        Vehicle car = new Car("C101", "Driver1", 15, "Agra");
        Vehicle bike = new Bike("B202", "Rider", 8, "Delhi");
        Vehicle auto = new Auto("A303", "Driver2", 10, "Mathura");

        processRide(car, 10);
        processRide(bike, 5);
        processRide(auto, 7);

        ((GPS) car).updateLocation("Agra");
        System.out.println(((GPS) bike).getCurrentLocation());
    }
}
