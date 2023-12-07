package interface_adapter.first_view;

import interface_adapter.signup.SignUpState;

public class FirstViewState {
    private String signinOrSignup = "";

    public FirstViewState(FirstViewState copy) {

        signinOrSignup = copy.signinOrSignup;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public FirstViewState() {
    }

    public String getSigninOrSignup() {

        return signinOrSignup;
    }
}
