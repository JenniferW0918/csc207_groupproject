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

    /**
     * The string representing the user's intention to sign in or sign up.
     */
    private String signinOrSignup = "";

    /**
     * Constructs a FirstViewState by copying the 'signinOrSignup' value from the provided instance.
     *
     * @param copy The FirstViewState instance to copy.
     */
    public FirstViewState(FirstViewState copy) {

        signinOrSignup = copy.signinOrSignup;
    }

    /**
     * Constructs a default FirstViewState with an empty 'signinOrSignup' value.
     */
    public FirstViewState() {
    }

    /**
     * Gets the current value of 'signinOrSignup'.
     *
     * @return The string representing the user's intention to sign in or sign up.
     */
    public String getSigninOrSignup() {

        return signinOrSignup;
    }
}
