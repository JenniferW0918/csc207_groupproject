package use_case.add_user;

/**
 * The AddUserInputData class stores the input data for the Add User use case.
 * It encapsulates the name, username and password input parameters needed to create a new User.
 *
 * @author jenniferwang
 * @version 1.0
 */
public class AddUserInputData {

    final private String name;
    final private String username;
    final private String password;

    /**
     * Constructor for creating an instance of AddUserInputData with the given name, username and password.
     *
     * @param name the name of the new user
     * @param username the username of the new user
     * @param password the password of the new user
     */
    public AddUserInputData(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    /**
     * Retrieves the username of the new user.
     *
     * @return the username of the new user
     */
    String getUsername() {
        return username; }

    /**
     * Retrieves the password of the new user.
     *
     * @return the password of the new user
     */
    String getPassword() {
        return password;
    }

    /**
     * Retrieves the name of the new user.
     *
     * @return the name of the new user
     */
    String getName() {
        return name;
    }
}