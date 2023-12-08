package use_case.add_business;

import entity.BusinessAccount;

/**
 * The AddBusinessAccountDataAccessInterface defines the operations related to adding and managing business accounts.
 * Classes implementing this interface are responsible for storing and retrieving business account information from a data source.
 *
 * This interface enforces methods to check the existence of a business account by username and to save
 * a new business account.
 *
 * Implementing classes should handle the storage and retrieval of business account data based on the
 * defined methods in this interface.
 *
 * @author audrey
 * @version 1.0
 */
public interface AddBusinessAccountDataAccessInterface {
    /**
     * Checks whether a business account with the given username already exists.
     *
     * @param identifier the username being checked for existence.
     * @return True if a business account with the specified username already exists; otherwise, false.
     */
    boolean businessExistsByUsername(String identifier);

    /**
     * Saves the new business account to Accounts.
     *
     * @param businessAccount The business account being saved.
     */
    void saveBusiness(BusinessAccount businessAccount);
}

