import java.util.Random;
import java.util.Scanner;

public class shootingatthesquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Initialize game field (5x5 grid)
        char[][] field = new char[5][5];

        // Fill the grid with '-'
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                field[i][j] = '-';
            }
        }

        // Randomly place the target
        int targetRow = random.nextInt(5);
        int targetCol = random.nextInt(5);

        System.out.println("All set. Get ready to rumble!");

        // Game loop
        while (true) {
            // Display game field
            printField(field);

            // Get user input for row and column
            int row = getValidNumber(scanner, "Enter row (1-5): ") - 1;
            int col = getValidNumber(scanner, "Enter column (1-5): ") - 1;

            // Check if target is hit
            if (row == targetRow && col == targetCol) {
                field[row][col] = 'x';
                printField(field);
                System.out.println("You have won!");
                break;
            } else {
                // Mark missed shot
                if (field[row][col] != '*') {  // Prevent overwriting previous shots
                    field[row][col] = '*';
                }
            }
        }

        scanner.close();
    }

    // Method to print the game field
    private static void printField(char[][] field) {
        System.out.println("  0 | 1 | 2 | 3 | 4 | 5 |");
        for (int i = 0; i < field.length; i++) {
            System.out.print((i + 1) + " | ");
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j] + " | ");
            }
            System.out.println();
        }
    }

    // Method to get a valid number within range (1-5)
    private static int getValidNumber(Scanner scanner, String message) {
        int num;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                if (num >= 1 && num <= 5) {
                    return num;
                }
            } else {
                scanner.next(); // Clear invalid input
            }
            System.out.println("Invalid input! Please enter a number between 1 and 5.");
        }
    }
}