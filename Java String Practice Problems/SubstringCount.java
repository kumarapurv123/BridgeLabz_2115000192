import java.util.Scanner;

public class SubstringCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String mainString = sc.nextLine();
        String subString = sc.nextLine();
        int count = 0, index = 0;
        while ((index = mainString.indexOf(subString, index)) != -1) {
            count++;
            index += subString.length();
        }
        System.out.println(count);
        sc.close();
    }
}