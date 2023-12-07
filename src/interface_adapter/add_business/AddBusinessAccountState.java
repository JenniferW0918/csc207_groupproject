package interface_adapter.add_business;


/**
 * The AddBusinessAccountState class represents the state of the add business account view.
 * It encapsulates the information related to user input and validation errors for creating a new business account.
 * The state includes the fields username, name, password, address, category, and their respective error messages.
 * Additionally, the accountType field is used to specify the type of the account being created.
 * This class provides methods to access and modify each field within the state.
 *
 * @author audrey
 * @version 1.0
 */
public class AddBusinessAccountState {
    private String username = "";
    private String usernameError = null;
    private String name = "";
    private String nameError = null;
    private String password = "";
    private String passwordError = null;
    private String address = "";
    private String addressError = null;
    private String category = "";
    private String categoryError = null;

    private String accountType = "";


    public AddBusinessAccountState(AddBusinessAccountState copy) {
        username = copy.username;
        usernameError = copy.usernameError;
        name = copy.name;
        nameError = copy.nameError;
        password = copy.password;
        passwordError = copy.passwordError;
        address = copy.address;
        addressError = copy.addressError;
        category = copy.category;
        categoryError = copy.categoryError;
        accountType = copy.accountType;
    }

    public AddBusinessAccountState() {
    }

    public String getUsername() {
        return username;
    }

    public String getUsernameError() {
        return usernameError;
    }

    public String getName() {
        return name;
    }

    public String getNameError() {
        return nameError;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public String getAddress() {
        return address;
    }

    public String getAddressError() {
        return addressError;
    }

    public String getCategory() {
        return category;
    }

    public String getCategoryError() {
        return categoryError;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setNameError(String nameError) {
        this.nameError = nameError;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAddressError(String addressError) {
        this.addressError = addressError;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCategoryError(String categoryError) {
        this.categoryError = categoryError;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }


    @Override
    public String toString() {
        return "AddBusinessAccountState{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}