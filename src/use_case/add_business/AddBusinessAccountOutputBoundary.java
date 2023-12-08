package use_case.add_business;

/**
 * The AddBusinessAccountOutputBoundary interface defines the boundary for the output of the Add Business Account use case.
 * Classes implementing this interface are responsible for preparing and presenting the success or failure views
 * related to adding a new business account.
 *
 * This interface declares two methods: prepareSuccessView and prepareFailView. Implementing classes are expected
 * to define the behavior for presenting the success view and handling failures, respectively.
 *
 * Implementing classes serve as intermediaries between the business logic (interactor) and the user interface or
 * external systems for displaying results and errors related to adding business accounts.
 *
 * @author audrey
 * @version 1.0
 */
public interface AddBusinessAccountOutputBoundary {

    /**
     * Prepares and presents the success view based on the provided AddBusinessAccountOutputData.
     *
     * @param user The output data representing the added business account.
     */
    void prepareSuccessView(AddBusinessAccountOutputData user);

    /**
     * Prepares and handles the failure view based on the provided error message.
     *
     * @param error The error message describing the reason for the failure.
     */
    void prepareFailView(String error);
}
