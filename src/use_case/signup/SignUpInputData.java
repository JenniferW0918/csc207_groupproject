package use_case.signup;

public class SignUpInputData {

    final private String accountType;

    public SignUpInputData(String accountType) {

        this.accountType = accountType;
    }

    String getAccountType() {

        return accountType;
    }
}
