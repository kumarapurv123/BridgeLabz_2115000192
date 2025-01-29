import java.util.Scanner;

public class Lexicographical {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        int minLength = Math.min(str1.length(), str2.length());
        int result = 0;

        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                result = str1.charAt(i) - str2.charAt(i);
                break;
            }
        }

        if (result == 0) {
            result = str1.length() - str2.length();
        }

        if (result < 0) {
            System.out.println("String 1 comes before String 2.");
        } else if (result > 0) {
            System.out.println("String 1 comes after String 2.");
        } else {
            System.out.println("Both strings are equal.");
        }

        sc.close();
    }
}