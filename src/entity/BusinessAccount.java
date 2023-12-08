package entity;

/**
 * The BusinessAccount class represents a business user account with attributes such as username, name, password,
 * address, and category. Instances of this class are immutable once initialized. It provides methods to access these
 * attributes.
 *
 * @author audrey
 * @version 1.0
 */
public class BusinessAccount {
    /**
     * The unique username associated with the business account.
     */
    private final String username;

    /**
     * The name of the business associated with the account.
     */
    private final String name;

    /**
     * The password associated with the business account.
     */
    private final String password;

    /**
     * The address of the business associated with the account.
     */
    private final String address;

    /**
     * The category of the business associated with the account.
     */
    private final String category;

    /**
     * Constructs a BusinessAccount object with the specified attributes.
     *
     * @param username The unique username associated with the business account.
     * @param name     The name of the business associated with the account.
     * @param password The password associated with the business account.
     * @param address  The address of the business associated with the account.
     * @param category The category of the business associated with the account.
     */
    public BusinessAccount(String username, String name, String password, String address,
                           String category) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.address = address;
        this.category = category;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getCategory(){
        return category;}
}
