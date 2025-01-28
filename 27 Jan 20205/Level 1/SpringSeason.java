public class SpringSeason {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Enter valid month and day.");
            return;
        }
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        if (isSpringSeason(month, day)) {
            System.out.println("Spring Season.");
        } else {
            System.out.println("Not a Spring Season.");
        }
    }

    public static boolean isSpringSeason(int month, int day) {
        if (month == 3 && day >= 20 && day <= 31) {
            return true;
        } else if (month == 4 && day >= 1 && day <= 30) {
            return true;
        } else if (month == 5 && day >= 1 && day <= 31) {
            return true;
        } else
            return month == 6 && day >= 1 && day <= 20;
    }
}