package use_case.add_user;

import entity.User;

/**
 * This DataAccessInterface defines the operations related to adding a managing user accounts.
 * Classes implementing this interface are responsible for getting and setting user information from a data object.
 *
 * Implementing classes should handle the storage and retrieval of user account data based on the methods in
 * this interface.
 *
 * @author jenniferwang
 * @version 1.0
 */
public interface AddUserDataAccessInterface {

    /**
     * Checks if a user with the given username already exists in the system.
     *
     * @param identifier the username to check for the existence of a user
     * @return True if a user with the given username already exists, false otherwise
     */
    boolean userExistsByUsername(String identifier);

    /**
     * Saves new User object to Accounts.
     *
     * @param user the User object to be saved
     */
    void saveUser(User user);
}

