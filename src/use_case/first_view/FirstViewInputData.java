package use_case.first_view;

public class FirstViewInputData {
    final private String signinOrSignup;

    public FirstViewInputData(String signinOrSignup) {

        this.signinOrSignup = signinOrSignup;
    }

    String getSigninOrSignup() {

        return signinOrSignup;
    }
}
