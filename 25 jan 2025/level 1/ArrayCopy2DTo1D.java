import java.util.Scanner;

public class ArrayCopy2DTo1D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];
        int[] array = new int[rows * cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
                array[index++] = matrix[i][j];
            }
        }
        System.out.println("1D Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
