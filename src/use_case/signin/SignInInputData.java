package use_case.signin;

public class SignInInputData {

    final private String username;
    final private String password;

    public SignInInputData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }
}
