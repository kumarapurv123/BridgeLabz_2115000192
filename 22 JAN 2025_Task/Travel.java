import java.util.Scanner;

public class Travel {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String name = input.nextLine();
        String fromCity = input.nextLine();
        String viaCity = input.nextLine();
        String toCity = input.nextLine();

        double fromToVia = input.nextInt();
        double viaToFinalCity = input.nextInt();

        double timeTaken = input.nextInt();

        double totalDistance = fromToVia + viaToFinalCity;
        double averageSpeed = totalDistance / timeTaken;

        System.out.println(name);
        System.out.println("Journey from " + fromCity + " via " + viaCity + " to " + toCity);
        System.out.println("Total Distance is " + totalDistance + " miles");
        System.out.println("Time Taken is" + timeTaken + " hours");
        System.out.println("Average Speed is" + averageSpeed + " miles per hour");
        input.close();

    }
}