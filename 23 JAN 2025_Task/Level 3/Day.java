public class Day {
    public static void main(String[] args) {
        if (args.length < 3) {
            return;
        }

        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);

        int y1 = y - (14 - m) / 12;
        int x = y1 + y1 / 4 - y1 / 100 + y1 / 400;
        int m1 = m + 12 * ((14 - m) / 12) - 2;
        int d1 = (d + x + 31 * m1 / 12) % 7;

        System.out.println(d1);
    }
}