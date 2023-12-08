package entity;

/**
 * Factory class for creating instances of User by implementing UserFactoryInterface.
 */
public class UserFactory implements UserFactoryInterface {

    /**
     * Creates a new User with the specified name, username and password.
     *
     * @param name the name of the User
     * @param username the username of the User
     * @param password the password of the User
     * @return a new instance of User with the given name, username and password
     */
    @Override
    public User create(String name, String username, String password) {
        return new User(name, username, password);
    }
}

