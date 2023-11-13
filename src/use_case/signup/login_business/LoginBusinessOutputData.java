package use_case.signup.login_business;

public class LoginBusinessOutputData {

    private final String username;
    private boolean useCaseFailed;

    public LoginBusinessOutputData(String username, boolean useCaseFailed) {
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }

}
