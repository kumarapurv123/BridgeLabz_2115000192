import java.util.Scanner;

public class LeapYearChecker {
    public static boolean isLeapYear(int year) {
        if (year < 1582) {
            return false;
        }
        if (year % 4 == 0) {
            if (year % 100 != 0 || year % 400 == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        if (isLeapYear(year)) {
            System.out.println(year + " is a Leap Year.");
        } else {
            System.out.println(year + " is not a Leap Year.");
        }
        scanner.close();
    }
}
