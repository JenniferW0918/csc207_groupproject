package entity;

/**
 * The BusinessAccountFactory class implements the BusinessAccountFactoryInterface and provides a method to create
 * instances of the BusinessAccount class. This factory simplifies the process of creating new business accounts
 * by encapsulating the instantiation details.
 *
 * @author audrey
 * @version 1.0
 */
public class BusinessAccountFactory implements BusinessAccountFactoryInterface{

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
    @Override
    public BusinessAccount create(String username, String name, String password, String address, String category) {

        return new BusinessAccount(username, name, password, address, category);
    }
}
