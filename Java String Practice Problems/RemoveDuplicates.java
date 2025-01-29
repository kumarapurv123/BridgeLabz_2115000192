import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder ans = new StringBuilder();
        boolean[] seen = new boolean[256];
        for (char ch : str.toCharArray()) {
            if (!seen[ch]) {
                seen[ch] = true;
                ans.append(ch);
            }
        }
        System.out.println("Modified string: " + ans.toString());
        sc.close();
    }
}