package use_case.signup.login_business;

public class LoginBusinessInputData {

    final private String username;
    final private String password;

    public LoginBusinessInputData(String username, String password) {
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
