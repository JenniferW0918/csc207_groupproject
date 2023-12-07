package interface_adapter.signin;

/**
 * The SignInState class represents the state of the signin view.
 * It encapsulates the information related to user input and validation errors for signing in.
 * The state includes the fields username and password, and their respective error messages.
 * This class provides methods to access and modify each field within the state.
 *
 * @author audrey
 * @version 1.0
 */
public class SignInState {
    private String username = "";
    private String usernameError = null;
    private String password = "";
    private String passwordError = null;


    public SignInState(SignInState copy) {
        username = copy.username;
        usernameError = copy.usernameError;
        password = copy.password;
        passwordError = copy.passwordError;
    }


    public SignInState() {
    }


    public String getUsername() {
        return username;
    }


    public String getUsernameError() {
        return usernameError;
    }


    public String getPassword() {
        return password;
    }


    public String getPasswordError() {
        return passwordError;
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
