package use_case.add_business;

/**
 * The AddBusinessAccountInputData class gives the input data for adding a new business account.
 * It encapsulates the necessary information required to create a new business account:
 * username, name, password, address, and category.
 *
 * Instances of this class are used to pass input data to the add business account use case.
 * The class provides methods for retrieving the individual components of the input data.
 *
 * @author audrey
 * @version 1.0
 */
public class AddBusinessAccountInputData {

    /**
     * The username chosen for the new business account.
     */
    final private String username;

    /**
     * The name of the new business account.
     */
    final private String name;

    /**
     * The password chosen for the new business account.
     */
    final private String password;

    /**
     * The address associated with the new business account.
     */
    final private String address;

    /**
     * The category or type of the new business account.
     */
    final private String category;

    /**
     * Constructs a new AddBusinessAccountInputData with the specified input values.
     *
     * @param username The chosen username for the business account.
     * @param name The name of the business account.
     * @param password The chosen password for the business account.
     * @param address The address of the business account.
     * @param category The category of the business account.
     */
    public AddBusinessAccountInputData(String username, String name, String password, String address,
                                       String category) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.address = address;
        this.category = category;
    }

    /**
     * Retrieves the username associated with the input data.
     *
     * @return The chosen username for the new business account.
     */
    String getUsername() {
        return username;
    }

    /**
     * Retrieves the password associated with the input data.
     *
     * @return The chosen password for the new business account.
     */
    String getPassword() {
        return password;
    }

    /**
     * Retrieves the name associated with the input data.
     *
     * @return The name of the new business account.
     */
    String getName(){
        return name;
    }

    /**
     * Retrieves the address associated with the input data.
     *
     * @return The address associated with the new business account.
     */
    String getAddress(){
        return address;
    }

    /**
     * Retrieves the category associated with the input data.
     *
     * @return The category or type of the new business account.
     */
    String getCategory(){
        return category;
    }


}

