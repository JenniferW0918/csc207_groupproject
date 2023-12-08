package use_case.add_business;

/**
 * The AddBusinessAccountInputBoundary interface defines the input boundary of the add business account use case.
 * Classes implementing this interface are responsible for handling input data and executing thr logic related to the use case.
 *
 * This interface declares a single method, execute, which takes an instance of AddBusinessAccountInputData
 * and triggers the execution of the use case.
 *
 * Implementing classes serve as intermediaries between the user interface (or external system) and the
 * business logic for adding business accounts.
 *
 * @author audrey
 * @version 1.0
 */
public interface AddBusinessAccountInputBoundary {

    /**
     * Executes the use case based on the provided input data.
     *
     * @param addBusinessInputData The input data for adding a new business account.
     */
    void execute(AddBusinessAccountInputData addBusinessInputData);
}
