import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    private static String title = "src/main/title.txt";
    
    public static void main(String[] args) {
         // Path to your title.txt file
        Scanner scanner = new Scanner(System.in);

        // Initialize PlayerStats and TimeManager
        PlayerStats playerStats = new PlayerStats(50, 20, 10, 0, true, 100, 10, "Dynamike");
        TimeManager timeManager = new TimeManager(7, true);
        

        // Display the game title from title.txt file
        displayTitle(title);

        System.out.println("");
        System.out.println("Begin Boom Boom Adventure? T for tutorial (y/n/t) ");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("y")) {
                startGame(scanner, playerStats, timeManager); // Pass timeManager to startGame
                break;
            }
            if (input.equalsIgnoreCase("n")) {
                scanner.close();
                System.exit(0);
            }
            if (input.equalsIgnoreCase("t")) {
                showTutorial(scanner);
            }
        }
    }

    private static void displayTitle(String titleFilePath) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(titleFilePath));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void startGame(Scanner scanner, PlayerStats playerStats, TimeManager timeManager) {
        System.out.println("Exploding the loading bar...");

        try {
            Thread.sleep(500);
            System.out.println("Lighting the fuse...");
            Thread.sleep(1000);
            System.out.println("Preparing the TNT...");
            Thread.sleep(250);
            System.out.println("You're In! Good luck and have fun!");
            System.out.println("Press E to see your inventory, Q to view your stats, R to clear console, and F to see available actions.");

            // Start game loop with timer
            gameLoop(scanner, playerStats, timeManager);
        } catch (InterruptedException e) {
            System.err.println("Sleep interrupted: " + e.getMessage());
        }
    }

    private static void showTutorial(Scanner scanner) {
        System.out.println("Loading Tutorial...");
        System.out.println("What is Boom Boom Adventure? This is a console-based game...");

        System.out.println("Begin Boom Boom Adventure? (y/n)");
        while (true) {
            String reinput = scanner.nextLine();
            if (reinput.equalsIgnoreCase("y")) {
                startGame(scanner, new PlayerStats(50, 20, 10, 0, true, 100, 14, "John"), new TimeManager(7, true)); // Pass new PlayerStats and TimeManager
                break;
            }
            if (reinput.equalsIgnoreCase("n")) {
                System.exit(0);
            }
        }
    }

    private static void gameLoop(Scanner scanner, PlayerStats playerStats, TimeManager timeManager) {
        Actions actions = new Actions(false);
        // Set up a timer to increment time every 10 seconds
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeManager.incrementTime();
                timeManager.displayTime(); // Display the updated time
            }
        }, 0, 10000); // Delay 0, repeat every 10,000ms (10 seconds)

        // Main game input loop
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("E")) {
                System.out.println("Inventory");
            } else if (input.equalsIgnoreCase("Q")) {
                System.out.println("Stats:");
                System.out.println("Name: " + playerStats.getPlayerName());
                System.out.println("Health: " + playerStats.getPlayerHealth());
                System.out.println("Happiness: " + playerStats.getHappiness());
                System.out.println("Stress: " + playerStats.getStress());
                System.out.println("Tiredness: " + playerStats.getTiredness());
                System.out.println("Toxicity: " + playerStats.getToxicity());
                System.out.println("Attack Strength: " + playerStats.getAttack());
            } else if (input.equalsIgnoreCase("F")) {
                System.out.println("Actions");
            
                actions.displayActions(scanner, playerStats);
            } else if (input.equalsIgnoreCase("R")) {
                clearConsole();
                displayTitle(title);
                System.out.println("Press E to see your inventory, Q to view your stats, R to clear console, and F to see available actions.");
            }
        }
    }

    private static void clearConsole() {
        // ANSI escape code to clear the console
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
