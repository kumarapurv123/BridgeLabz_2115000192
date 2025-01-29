import java.util.Scanner;
import java.util.Random;

public class NumberGuessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int low = 1, high = 100;
        boolean guessedCorrectly = false;

        System.out.println("Think of a number between 1 and 100, and I'll try to guess it!");

        while (!guessedCorrectly) {
            int guess = generateGuess(low, high, random);
            System.out.println("Is your number " + guess + "? (Enter 'h' if too high, 'l' if too low, 'c' if correct)");
            char feedback = sc.next().charAt(0);

            guessedCorrectly = Feedback(feedback, guess);

            if (!guessedCorrectly) {
                if (feedback == 'h') {
                    high = guess - 1;
                } else if (feedback == 'l') {
                    low = guess + 1;
                }
            }
        }

        System.out.println("Hooray! I guessed your number!");
        sc.close();
    }

    public static int generateGuess(int low, int high, Random random) {
        return random.nextInt(high - low + 1) + low;
    }

    public static boolean Feedback(char feedback, int guess) {
        return feedback == 'c';
    }
}
