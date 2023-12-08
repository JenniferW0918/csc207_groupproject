package entity;

/**
 * The BusinessAccountFactoryInterface provides an interface for creating instances of the BusinessAccount class.
 * Implementing classes are responsible for defining the method to create a new business account with specified attributes.
 *
 * @author audrey
 * @version 1.0
 */
public interface BusinessAccountFactoryInterface {

    /**
     * Creates and returns a new instance of the BusinessAccount class with the specified attributes.
     *
     * @param username The unique username associated with the business account.
     * @param name     The name of the business associated with the account.
     * @param password The password associated with the business account.
     * @param address  The address of the business associated with the account.
     * @param category The category of the business associated with the account.
     * @return A new BusinessAccount instance with the specified attributes.
     */
    BusinessAccount create(String username, String name, String password, String address, String category);
}
