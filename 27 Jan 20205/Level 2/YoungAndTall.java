import java.util.Scanner;

public class YoungAndTall {

    public static int findYoung(int[] ages) {
        int youngestIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }
        return youngestIndex;
    }

    public static int findTall(double[] heights) {
        int tallestIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        return tallestIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = { "Amar", "Akbar", "Anthony" };
        int[] ages = new int[3];
        double[] heights = new double[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            ages[i] = scanner.nextInt();
            System.out.print("Enter height of " + names[i] + ": ");
            heights[i] = scanner.nextDouble();
        }
        int youngestIndex = findYoung(ages);
        int tallestIndex = findTall(heights);
        System.out.println(names[youngestIndex] + " is the youngest with age " + ages[youngestIndex]);
        System.out.println(names[tallestIndex] + " is the tallest with height " + heights[tallestIndex] + " meters");
        scanner.close();
    }
}
