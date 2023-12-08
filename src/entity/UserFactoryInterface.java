package entity;

/**
 * Defines an interface for creating instances of User.
 */
public interface UserFactoryInterface {
    /**
     * Creates a new User with the specified name, username and password.
     *
     * @param name the name of the User
     * @param username the username of the User
     * @param password the password of the User
     * @return a new instance of User with the given parameters
     * @throws IllegalArgumentException if the password is not valid
     */
    User create(String name, String username, String password);
}
