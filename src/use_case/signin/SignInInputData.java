package use_case.signin;

/**
 * The SignInInputData class represents the input data for the Sign-In use case. It encapsulates the username and password
 * provided by the user for the sign-in action.
 *
 * Instances of this class are created by the user interface or external systems and passed to the input boundary
 * (SignInInputBoundary) for initiating the execution of the Sign-In use case.
 *
 * @author audrey
 * @version 1.0
 */
public class SignInInputData {

    /**
     * The username provided by the user for the sign-in action.
     */
    final private String username;

    /**
     * The password provided by the user for the sign-in action.
     */
    final private String password;

    /**
     * Constructs a new SignInInputData with the specified username and password.
     *
     * @param username The username provided by the user for the sign-in action.
     * @param password The password provided by the user for the sign-in action.
     */
    public SignInInputData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Gets the username provided by the user for the sign-in action.
     *
     * @return The username string.
     */
    String getUsername() {
        return username;
    }

    /**
     * Gets the password provided by the user for the sign-in action.
     *
     * @return The password string.
     */
    String getPassword() {
        return password;
    }
}
