import java.util.Scanner;

public class FriendsComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[3];
        int[] heights = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age for friend " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
            System.out.print("Enter height for friend " + (i + 1) + ": ");
            heights[i] = sc.nextInt();
        }
        int youngestAge = ages[0];
        int tallestHeight = heights[0];
        for (int i = 1; i < 3; i++) {
            if (ages[i] < youngestAge) {
                youngestAge = ages[i];
            }
            if (heights[i] > tallestHeight) {
                tallestHeight = heights[i];
            }
        }
        System.out.println("Youngest age: " + youngestAge);
        System.out.println("Tallest height: " + tallestHeight);
    }
}