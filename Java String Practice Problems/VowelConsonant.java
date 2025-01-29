import java.util.Scanner;

public class VowelConsonant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.toLowerCase();
        int vowelCount = 0, consonantCount = 0;
        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                if (isVowel(ch)) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
        }
        System.out.println(vowelCount);
        System.out.println(consonantCount);
        sc.close();

    }

    public static boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) != -1;
    }

}