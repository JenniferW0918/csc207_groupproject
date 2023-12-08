package interface_adapter.add_user;

/**
 * The AddUserState class represents the state of the view during the add user operation.
 * It encapsulates the data related to username, name, password, account type.
 * This class includes a copy constructor for creating a new instance based on an existing AddUserState object.
 * The default constructor is made explicit due to the presence of the copy constructor.
 *
 * @author jenniferwang
 * @version 1.0
 */
public class AddUserState {
    private String username = "";
    private String usernameError = null;
    private String name = "";
    private String nameError = null;
    private String password = "";
    private String passwordError = null;
    private String accountType = "";
    private String accountTypeError = null;

    /**
     * Copy constructor for creating a new AddUserState instance based on an existing one.
     *
     * @param copy the AddUserState object to copy
     */
    public AddUserState(AddUserState copy) {
        username = copy.username;
        usernameError = copy.usernameError;
        name = copy.name;
        nameError = copy.nameError;
        password = copy.password;
        passwordError = copy.passwordError;
        accountType = copy.accountType;
        accountTypeError = copy.accountTypeError;
    }

    /**
     * Default constructor for creating an empty AddUserState instance.
     */
    public AddUserState() {}

    /**
     * Retrieves the username.
     *
     * @return the username inputted for the new user
     */
    public String getUsername() {

        return username;
    }

    /**
     * Retrieves the username error message.
     *
     * @return the error message for failing username validation
     */
    public String getUsernameError() {

        return usernameError;
    }

    /**
     * Retrieves the name.
     *
     * @return the name inputted for the new user
     */
    public String getName() {

        return name;
    }

    /**
     * Retrieves the name error message.
     *
     * @return the error message for failing name validation
     */
    public String getNameError() {

        return nameError;
    }

    /**
     * Retrieves the password.
     *
     * @return the password inputted for the new user
     */
    public String getPassword() {

        return password;
    }

    /**
     * Retrieves the password error message.
     *
     * @return the error message for failing password validation
     */
    public String getPasswordError() {

        return passwordError;
    }

    /**
     * Updates the username.
     *
     * @param username the new username to set to
     */
    public void setUsername(String username) {

        this.username = username;
    }

    /**
     * Updates the username error message.
     *
     * @param usernameError the new username error message to set to
     */
    public void setUsernameError(String usernameError) {

        this.usernameError = usernameError;
    }

    /**
     * Updates the name.
     *
     * @param name the new name to set to
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * Updates the password.
     *
     * @param password the new password to set to
     */
    public void setPassword(String password) {

        this.password = password;
    }

    /**
     * Updates the account type.
     *
     * @param accountType the new account type to set to
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
