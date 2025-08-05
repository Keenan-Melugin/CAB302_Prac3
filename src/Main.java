import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Static list of users, acting as a database
    private static ArrayList<User> users = new ArrayList<>();

    // Authentication service instance
    private static IAuthenticationService authService;

    private static boolean isRunning = true;

    /**
     * The entry point of the application.
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        users.add(new User("test", "test")); // Default user
        authService = new AuthenticationService(users); // Use actual implementation

        while (isRunning) {
            showMenu();
        }
    }

    /**
     * Displays the main menu to the user.
     */
    public static void showMenu() {
        System.out.println("Welcome to the To-Do List Application!");
        System.out.println("1. Log in");
        System.out.println("2. Sign up");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        handleMenu(choice);
    }

    /**
     * Handles the user's choice, mapping the menu options to the corresponding methods.
     * @param choice The user's choice.
     */
    public static void handleMenu(int choice) {
        switch (choice) {
            case 1:
                onLogIn();
                break;
            case 2:
                onSignUp();
                break;
            case 3:
                onExit();
                break;
            default:
                System.out.println("Invalid choice!");
                showMenu();
        }
    }

    /**
     * Handles the log-in process, and the post-login operations.
     */
    public static void onLogIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        User user = authService.logIn(username, password);
        if (user != null) {
            System.out.println("Welcome, " + user.getUsername() + "!");
            // TODO Later: Add the to-do list operations
        } else {
            System.out.println("Incorrect username or password.");
        }
    }

    /**
     * Handles the sign-up process.
     */
    public static void onSignUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        User user = authService.signUp(username, password);

        if (user != null) {
            System.out.println("User " + user.getUsername() + " has been created successfully!");
        } else {
            System.out.println("The username is already taken!");
        }
    }

    /**
     * Exits the application by setting the `isRunning` flag to false.
     */
    public static void onExit() {
        isRunning = false;
    }
}
