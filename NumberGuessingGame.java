import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int roundsWon = 0;
        int totalAttempts = 0;
        String playAgain;
        
        do {
            int lowerBound = 1;
            int upperBound = 100;
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            int maxAttempts = 10;
            boolean guessedCorrectly = false;
            
            System.out.println("Guess the number between " + lowerBound + " and " + upperBound + ". You have " + maxAttempts + " attempts.");
            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                
                try {
                    int guess = Integer.parseInt(scanner.nextLine());
                    attempts++;
                    
                    if (guess < lowerBound || guess > upperBound) {
                        System.out.println("Please guess a number within " + lowerBound + "-" + upperBound + ".");
                        continue;
                    }
                    
                    if (guess < numberToGuess) {
                        System.out.println("Too low! Try again.");
                    } else if (guess > numberToGuess) {
                        System.out.println("Too high! Try again.");
                    } else {
                        System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                        guessedCorrectly = true;
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Out of attempts! The correct number was " + numberToGuess + ".");
            } else {
                roundsWon++;
                totalAttempts += attempts;
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.nextLine().trim().toLowerCase();
        } while (playAgain.equals("yes"));
        
        System.out.println("Game Over! You won " + roundsWon + " rounds with a total of " + totalAttempts + " attempts.");
        scanner.close();
    }
}
