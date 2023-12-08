package use_case.first_view;


/**
 * The FirstViewInputData class represents the input data for the First View use case.
 * It encapsulates information about whether the user intends to sign in or sign up.
 *
 * Instances of this class are created by the user interface or external systems and passed to the input boundary
 * (FirstViewInputBoundary) for initiating actions related to the First View.
 *
 * @author audrey
 * @version 1.0
 */
public class FirstViewInputData {

    /**
     * The indication of whether the user intends to sign in or sign up.
     */
    final private String signinOrSignup;

    /**
     * Constructs a new FirstViewInputData with the specified indication of sign-in or sign-up.
     *
     * @param signinOrSignup The string indicating the user's intention to sign in or sign up.
     */
    public FirstViewInputData(String signinOrSignup) {

        this.signinOrSignup = signinOrSignup;
    }

    /**
     * Gets the indication of whether the user intends to sign in or sign up.
     *
     * @return The string representing the sign-in or sign-up intention.
     */
    String getSigninOrSignup() {

        return signinOrSignup;
    }
}
