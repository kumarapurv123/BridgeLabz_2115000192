import java.util.Scanner;

public class FrequentCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] freq = new int[256];
        for (char ch : str.toCharArray()) {
            freq[ch]++;
        }
        char mostFrequentChar = str.charAt(0);
        int maxCount = 0;
        for (char ch : str.toCharArray()) {
            if (freq[ch] > maxCount) {
                maxCount = freq[ch];
                mostFrequentChar = ch;
            }
        }
        System.out.println(" Frequent Character: '" + mostFrequentChar + "'");
        sc.close();
    }
}