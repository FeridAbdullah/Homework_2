import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Let the game begin!");

        // Get player's name
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Generate a random number in range [0-100]
        int randomNumber = random.nextInt(101);

        int[] guesses = new int[100]; // Array to store guesses (arbitrary large size)
        int count = 0; // Counter for the number of guesses

        while (true) {
            System.out.print("Enter your guess: ");
            int userGuess = getValidNumber(scanner); // Ensures valid number input

            // Store the guess
            if (count < guesses.length) {
                guesses[count++] = userGuess;
            }

            if (userGuess < randomNumber) {
                System.out.println("Your number is too small. Please, try again.");
            } else if (userGuess > randomNumber) {
                System.out.println("Your number is too big. Please, try again.");
            } else {
                System.out.println("Congratulations, " + name + "!");
                break;
            }
        }

        // Sort and display entered numbers in descending order
        int[] userNumbers = Arrays.copyOf(guesses, count);
        Arrays.sort(userNumbers);

        System.out.print("Your numbers: ");
        for (int i = userNumbers.length - 1; i >= 0; i--) {
            System.out.print(userNumbers[i] + " ");
        }

        scanner.close();
    }

    // Method to ensure user inputs a valid number
    private static int getValidNumber(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }
}