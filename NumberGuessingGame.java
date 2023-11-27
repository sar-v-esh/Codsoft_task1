import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int maxAttempts = 10;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the number between " + lowerBound + " and " + upperBound);

        boolean playAgain = true;

        while (playAgain) {
            int attempts = 0;

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + '\n' +"Enter your guess:");
                int userGuess = scanner.nextInt();

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score += maxAttempts - attempts;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println('\n'+"Low! Try again."+'\n');
                } else {
                    System.out.println('\n'+"High! Try again."+'\n');
                }

                attempts++;
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry! You've run out of attempts. The correct number was: " + targetNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");

            if (playAgain) {
                targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
                System.out.println("New round! Try to guess the number between " + lowerBound + " and " + upperBound);
            }
        }

        System.out.println("Your final score is: " + score);

        scanner.close();
    }
}
