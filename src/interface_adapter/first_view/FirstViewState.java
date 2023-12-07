package interface_adapter.first_view;

/**
 * The FirstViewState class represents the state of the First View.
 * It encapsulates the information related to the user's choice between signing in or signing up.
 * The state includes a field indicating whether the user intends to sign in or sign up.
 * This class provides methods to access and modify the state.
 *
 * @author audrey
 * @version 1.0
 */
public class FirstViewState {
    private String signinOrSignup = "";

    public FirstViewState(FirstViewState copy) {

        signinOrSignup = copy.signinOrSignup;
    }

    public FirstViewState() {
    }

    public String getSigninOrSignup() {

        return signinOrSignup;
    }
}
