import java.util.Scanner;

public class Actions {
    private boolean mirageAvailable;

    public Actions(boolean mirageAvailable) {
        this.mirageAvailable = mirageAvailable;
    }

    public void displayActions(Scanner scanner, PlayerStats playerStats) {
        System.out.println("Choose an action:");
        System.out.println("1. Explore");
        System.out.println("2. Rest");
        System.out.println("3. Track Animal");
        if (mirageAvailable) {
            System.out.println("4. Examine Mirage");
        }

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.println("You explore the surroundings.");
                playerStats.setTiredness(playerStats.getTiredness() + 10);
                
              break;
            case 2:
                System.out.println("You take a rest.");
                playerStats.setTiredness(playerStats.getTiredness() - 10); // Decrease tiredness as an example
                break;
            case 3:
                System.out.println("You track an animal.");
                playerStats.setTiredness(playerStats.getTiredness() + 5);
                break;
            case 4:
                if (mirageAvailable) {
                    System.out.println("You examine the mirage.");
                } else {
                    System.out.println("This action is not available.");
                }
                break;
            default:
                System.out.println("Invalid choice. Please select a valid action.");
        }
    }
}
 