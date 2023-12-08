package use_case.signin;

import entity.BusinessAccount;
import entity.User;

/**
 * The SignInUserDataAccessInterface interface defines methods for accessing user and business account data related to Sign-In functionality.
 * Implementing classes are responsible for providing information about the existence of users and business accounts and retrieving user
 * and business account details based on usernames.
 *
 * Instances of classes implementing this interface are used by the business logic (SignInInteractor) to interact with the data storage
 * and retrieve necessary information for the Sign-In use case.
 *
 * @author audrey
 * @version 1.0
 */
public interface SignInUserDataAccessInterface {

    /**
     * Checks whether a user with the specified username exists.
     *
     * @param identifier The username to check for existence.
     * @return true if a user with the given username exists, otherwise false.
     */
    boolean userExistsByUsername(String identifier);

    /**
     * Checks whether a business account with the specified username exists.
     *
     * @param identifier The username to check for existence.
     * @return true if a business account with the given username exists, otherwise false.
     */
    boolean businessExistsByUsername(String identifier);

    /**
     * Retrieves a User object based on the specified username.
     *
     * @param username The username associated with the User.
     * @return The User object if found, or null if not found.
     */
    User getUser(String username);

    /**
     * Retrieves a BusinessAccount object based on the specified username.
     *
     * @param username The username associated with the BusinessAccount.
     * @return The BusinessAccount object if found, or null if not found.
     */
    BusinessAccount getBusinessAccount(String username);
}

