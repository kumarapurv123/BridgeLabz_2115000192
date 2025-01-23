public class SumZeroBreak {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int total = 0;
        int number;

        while (true) {
            number = sc.nextInt();
            if (number == 0) {
                break;
            }
            total += number;
        }

        System.out.println("The total sum is: " + total);
        sc.close();
    }
}