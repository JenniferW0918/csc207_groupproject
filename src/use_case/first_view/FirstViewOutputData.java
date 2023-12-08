package use_case.first_view;

/**
 * The FirstViewOutputData class represents the output data for the First View use case, specifically for success scenarios.
 * It encapsulates information about whether the user successfully signed in or signed up.
 *
 * Instances of this class are created by the business logic (interactor) and passed to the output boundary
 * (FirstViewOutputBoundary) for presenting success views to the user interface or external systems.
 *
 * @author audrey
 * @version 1.0
 */
public class FirstViewOutputData {

    /**
     * The indication of whether the user successfully signed in or signed up.
     */
    private final String signinOrSignup;

    /**
     * Constructs a new FirstViewOutputData with the specified indication of sign-in or sign-up success.
     *
     * @param signinOrSignup The string indicating the success of the sign-in or sign-up action.
     */
    public FirstViewOutputData(String signinOrSignup) {
        this.signinOrSignup = signinOrSignup;
    }

    /**
     * Gets the indication of whether the user successfully signed in or signed up.
     *
     * @return The string representing the success of the sign-in or sign-up action.
     */
    public String getSigninOrSignup() {
        return signinOrSignup;
    }
}
