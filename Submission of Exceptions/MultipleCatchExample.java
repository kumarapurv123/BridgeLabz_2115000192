import java.util.Scanner;

public class MultipleCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = { 10, 20, 30, 40, 50 };

        try {
            int index = scanner.nextInt();

            System.out.println(index + numbers[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } catch (Exception e) {
            System.out.println("An unexpected error" + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
