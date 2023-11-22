package use_case.signup;

public class SignUpInputData {

    final private String username;
    final private String password;

    public SignUpInputData(String username, String password) {
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
