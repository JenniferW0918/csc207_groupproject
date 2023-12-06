package use_case.signin;

public class SignInOutputData {
    private final String username;
    private boolean useCaseFailed;

    public SignInOutputData(String username, boolean useCaseFailed) {
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }
}
