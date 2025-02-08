import java.util.Scanner;

public class weekplanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the schedule (7 days, 2 columns: [day, task])
        String[][] schedule = {
                {"Sunday", "do home work"},
                {"Monday", "go to courses; watch a film"},
                {"Tuesday", "meet friends"},
                {"Wednesday", "go to the gym"},
                {"Thursday", "work on project"},
                {"Friday", "attend workshop"},
                {"Saturday", "relax and read a book"}
        };

        while (true) {
            System.out.print("Please, input the day of the week: ");
            String input = scanner.nextLine().trim().toLowerCase(); // Trim spaces & lowercase

            if (input.equals("exit")) {
                System.out.println("Goodbye!");
                break; // Exit the program
            }

            boolean found = false;
            for (String[] day : schedule) {
                if (day[0].equalsIgnoreCase(input)) { // Case-insensitive check
                    System.out.println("Your tasks for " + day[0] + ": " + day[1] + ".");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Sorry, I don't understand you, please try again.");
            }
        }

        scanner.close();
    }
}
