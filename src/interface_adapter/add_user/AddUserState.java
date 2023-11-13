package interface_adapter.add_user;

public class AddUserState {
    private String username = "";
    private String usernameError = null;
    private String password = "";
    private String passwordError = null;

    public AddUserState(AddUserState copy) {
        username = copy.username;
        usernameError = copy.usernameError;
        password = copy.password;
        passwordError = copy.passwordError;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public AddUserState() {}

    public String getUsername() {

        return username;
    }

    public String getUsernameError() {
        return
                usernameError;
    }

    public String getPassword() {
        return
                password;
    }

    public String getPasswordError() {
        return
                passwordError;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public void setUsernameError(String usernameError) {

        this.usernameError = usernameError;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public void setPasswordError(String passwordError) {

        this.passwordError = passwordError;
    }
}
