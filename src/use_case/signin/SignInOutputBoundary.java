package use_case.signin;

/**
 * The SignInOutputBoundary interface defines the contract for presenting the results and errors related to the Sign-In use case.
 * Implementing classes are responsible for preparing views based on successful or failed Sign-In attempts.
 *
 * Instances of classes implementing this interface are utilized by the business logic (SignInInteractor) to communicate outcomes
 * to the user interface or external systems.
 *
 * @author audrey
 * @version 1.0
 */
public interface SignInOutputBoundary {

    /**
     * Prepares the view for a successful Sign-In attempt, providing the necessary data.
     *
     * @param user The output data representing the result of a successful Sign-In attempt.
     */
    void prepareSuccessView(SignInOutputData user);

    /**
     * Prepares the view for a failed Sign-In attempt, providing an error message.
     *
     * @param error The error message indicating the reason for the Sign-In failure.
     */
    void prepareFailView(String error);
}

