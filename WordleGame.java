import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordleGame {
    private static final int MAX_ATTEMPTS = 6;
    private static final String CORRECT_WORD = "CRANE"; // Change this to your desired word

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Guess the %d-letter word. You have %d attempts!%n",
                CORRECT_WORD.length(), MAX_ATTEMPTS);
        System.out.println("Here Y means correct letter but in wrong position,");
        System.out.println("G means that the letter is in correct position,");
        System.out.println("- means the letter is wrong.");

        boolean won = false;

        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            System.out.print("Attempt " + attempt + ": ");
            String guess = scanner.nextLine().toUpperCase();

            if (guess.length() != CORRECT_WORD.length()) {
                System.out.printf("Please enter a %d-letter word.%n", CORRECT_WORD.length());
                attempt--;
                continue;
            }

            if (guess.equals(CORRECT_WORD)) {
                System.out.println("Congratulations! You guessed the word!");
                won = true;
                break;
            }

            List<String> feedback = checkGuess(guess);
            System.out.println(String.join(" ", feedback));
        }

        if (!won) {
            System.out.println("Game over! The correct word was " + CORRECT_WORD);
        }
        scanner.close();
    }

    private static List<String> checkGuess(String guess) {
        List<String> feedback = new ArrayList<>();
        Character[] correctChars = new Character[CORRECT_WORD.length()];
        Character[] guessChars = new Character[guess.length()];

        // Initialize arrays
        for (int i = 0; i < CORRECT_WORD.length(); i++) {
            correctChars[i] = CORRECT_WORD.charAt(i);
            guessChars[i] = guess.charAt(i);
        }

        // First pass: Check for correct positions (G)
        for (int i = 0; i < guessChars.length; i++) {
            if (guessChars[i].equals(correctChars[i])) {
                feedback.add("G");
                correctChars[i] = null;
                guessChars[i] = null;
            } else {
                feedback.add("-");
            }
        }

        // Second pass: Check for correct letters in wrong positions (Y)
        for (int i = 0; i < guessChars.length; i++) {
            if (guessChars[i] != null) {
                for (int j = 0; j < correctChars.length; j++) {
                    if (correctChars[j] != null && correctChars[j].equals(guessChars[i])) {
                        feedback.set(i, "Y");
                        correctChars[j] = null;
                        break;
                    }
                }
            }
        }

        return feedback;
    }
}
