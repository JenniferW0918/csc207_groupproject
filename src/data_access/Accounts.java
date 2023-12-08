package data_access;

import entity.BusinessAccount;
import entity.User;
import use_case.add_user.AddUserDataAccessInterface;
import use_case.add_business.AddBusinessAccountDataAccessInterface;
import use_case.signin.SignInUserDataAccessInterface;

import java.util.ArrayList;

/**
 * Manages User and BusinessAccount objects and defines data access methods.
 * Implements interfaces for creating user accounts, creating business accounts, and signing in both types of accounts.
 */
public class Accounts implements AddBusinessAccountDataAccessInterface, AddUserDataAccessInterface,
        SignInUserDataAccessInterface {

    private final ArrayList<User> users = new ArrayList<>();
    private final ArrayList<BusinessAccount> businesses = new ArrayList<>();

    /**
     * Default constructor for creating an instance of the Accounts class.
     */
    public Accounts() {
    }

    /**
     * Saves a User to the arraylist of User objects if an account with the given username does not already exist.
     *
     * @param user the user to be saved
     */
    @Override
    public void saveUser(User user) {
        if (!userExistsByUsername(user.getUsername()))
            users.add(user);
    }

    /**
     * Checks if a User with the given username already exists.
     *
     * @param identifier the username to check
     * @return True if a User with the given username exists, False otherwise
     */
    @Override
    public boolean userExistsByUsername(String identifier) {
        for (User user : users) {
            if (user.getUsername().equals(identifier)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Saves a BusinessAccount to the arraylist of BusinessAccount objects if an account with the given username
     * does not already exist.
     *
     * @param businessAccount the BusinessAccount to be saved
     */
    @Override
    public void saveBusiness(BusinessAccount businessAccount) {
        if (!businessExistsByUsername(businessAccount.getUsername()))
            businesses.add(businessAccount);
    }

    /**
     * Checks if a BusinessAccount with the given username already exists.
     *
     * @param identifier the username to check
     * @return True if a BusinessAccount with the given username exists, False otherwise
     */
    @Override
    public boolean businessExistsByUsername(String identifier) {
        for (BusinessAccount businessAccount : businesses) {
            if (businessAccount.getUsername().equals(identifier)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves a User with the given username.
     *
     * @param username  the username of the user to retrieve
     * @return the User with the given username, or null if not found
     */
    @Override
    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Retrieves a BusinessAccount with the given username.
     *
     * @param username the username of the BusinessAccount to retrieve
     * @return the BusinessAccount with the given username, or null if not found
     */
    @Override
    public BusinessAccount getBusinessAccount(String username) {
        for (BusinessAccount businessAccount : businesses) {
            if (businessAccount.getUsername().equals(username)) {
                return businessAccount;
            }
        }
        return null;
    }

    /**
     * Gets a copy of the list of User objects.
     *
     * @return a copy of the list of User objects
     */
    public ArrayList<User> getUsers () {
        return new ArrayList<>(users);
    }

    /**
     * Gets a copy of the list of BusinessAccount objects.
     *
     * @return a copy of the list of BusinessAccount objects
     */
    public ArrayList<BusinessAccount> getBusinessAccounts () {
        return new ArrayList<>(businesses);
    }
}
