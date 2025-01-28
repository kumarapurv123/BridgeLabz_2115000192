import java.util.Scanner;

public class NumberAnalysis {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] numbers = new int[5];

    for (int i = 0; i < 5; i++) {
      numbers[i] = sc.nextInt();
    }

    for (int i = 0; i < 5; i++) {
      if (isPositive(numbers[i])) {
        System.out.print("Number " + numbers[i] + " is Positive and ");
        if (isEven(numbers[i])) {
          System.out.println("Even.");
        } else {
          System.out.println("Odd.");
        }
      } else {
        System.out.println("Number " + numbers[i] + " is Negative.");
      }
    }

    int comparison = compare(numbers[0], numbers[4]);
    if (comparison > 0) {
      System.out.println("The first number is greater than the last number.");
    } else if (comparison == 0) {
      System.out.println("The first and last numbers are equal.");
    } else {
      System.out.println("The first number is less than the last number.");
    }
  }

  public static boolean isPositive(int number) {
    return number > 0;
  }

  public static boolean isEven(int number) {
    return number % 2 == 0;
  }

  public static int compare(int number1, int number2) {
    if (number1 > number2) {
      return 1;
    } else if (number1 == number2) {
      return 0;
    } else {
      return -1;
    }
  }
}