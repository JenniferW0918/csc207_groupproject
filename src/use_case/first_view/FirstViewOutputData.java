package use_case.first_view;

public class FirstViewOutputData { // testing commits
    private final String signinOrSignup;

    public FirstViewOutputData(String signinOrSignup) {
        this.signinOrSignup = signinOrSignup;
    }

    public String getSigninOrSignup() {
        return signinOrSignup;
    }
}
