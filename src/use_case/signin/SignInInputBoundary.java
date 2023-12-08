package use_case.signin;


/**
 * The SignInInputBoundary interface defines the boundary for executing the Sign-In use case.
 * Implementing classes are responsible for handling the input data related to the Sign-In action.
 *
 * This interface declares a single method: execute. Implementing classes are expected to define the behavior
 * for processing the input data and triggering the actions associated with the Sign-In use case.
 *
 * Implementing classes serve as intermediaries between the user interface or external systems and the business logic (interactor)
 * for initiating the execution of the Sign-In use case based on the provided input data.
 *
 * @author audrey
 * @version 1.0
 */
public interface SignInInputBoundary {

    /**
     * Executes the Sign-In use case based on the provided SignInInputData.
     * Implementing classes define the specific behavior for processing the input data and triggering the Sign-In action.
     *
     * @param signInInputData The input data for the Sign-In use case.
     */
    void execute(SignInInputData signInInputData);
}
