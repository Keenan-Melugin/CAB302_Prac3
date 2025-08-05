import java.util.ArrayList;

public class AuthenticationService implements IAuthenticationService {
    private ArrayList<User> users;

    /**
     * Constructor to initialize the authentication service with an existing user list.
     */
    public AuthenticationService(ArrayList<User> users) {
        this.users = users;
    }

    /**
     * Signs up a new user if the username is not already taken.
     * @param username The desired username.
     * @param password The desired password.
     * @return The created user, or null if the username is already taken.
     */
    @Override
    public User signUp(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return null;
            }
        }
        User newUser = new User(username, password);
        users.add(newUser);
        return newUser;
    }

    /**
     * Logs in an existing user if the credentials match.
     * @param username The entered username.
     * @param password The entered password.
     * @return The matching user, or null if login fails.
     */
    @Override
    public User logIn(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
