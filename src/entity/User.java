package entity;

/**
 * Represents a user with a username, name and password.
 */
public class User {
    private final String name;
    private final String username;
    private final String password;

    /**
     * Constructs a new User with the given name, username and password.
     *
     * @param name the name of the user
     * @param username the username of the user
     * @param password the password of the user
     */
    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    /**
     * Retrieves the name of the user.
     *
     * @return the name of the user
     */
    public String getName() {
        return name; }

    /**
     * Retrieves the username of the user.
     *
     * @return the username of the user
     */
    public String getUsername() {
        return username; }

    /**
     * Retrieves the password of the user.
     *
     * @return the password of the user
     */
    public String getPassword() {
        return password; }
}
