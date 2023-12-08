package use_case.signup;

/**
 * The SignUpInputBoundary interface defines the input boundary for the Sign Up (account type selection) use case.
 * Classes implementing this interface are responsible for handling input data and executing the logic related
 * to the use case.
 *
 * It declares a method (execute) for executing the sign up account type selection use case with the provided input data
 * (SignUpInputData).
 *
 * @author jenniferwang
 * @version 1.0
 */
public interface SignUpInputBoundary {

    /**
     * Executes the sign up account type selection use case with the provided input data.
     *
     * @param signupInputData the input data object containing information for selecting an account type when signing up
     */
    void execute(SignUpInputData signupInputData);
}
