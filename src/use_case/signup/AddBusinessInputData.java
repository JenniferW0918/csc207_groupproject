package use_case.signup;

public class AddBusinessInputData {

    final private String BUSINESS_USERNAME;
    final private String password;
    final private String repeatPassword;

    public AddBusinessInputData(String username, String password, String repeatPassword) {
        this.BUSINESS_USERNAME = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    String getUsername() {
        return BUSINESS_USERNAME;
    }

    String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }
}
