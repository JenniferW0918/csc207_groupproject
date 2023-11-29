package use_case.signup;

public class SignUpOutputData {

    private final String accountType;

    public SignUpOutputData(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() {
        return accountType;
    }
}
