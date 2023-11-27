package interface_adapter.signup;

public class SignUpState {

    private String accountType = "";

    public SignUpState(SignUpState copy) {

        accountType = copy.accountType;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public SignUpState() {
    }

    public String getAccountType() {

        return accountType;
    }
}
