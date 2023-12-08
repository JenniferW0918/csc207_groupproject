package use_case.add_user;

/**
 * This InputBoundary interface defines the input boundary for the Add User use case.
 * Classes implementing this interface are responsible for handling input data and executing the logic related
 * to the use case.
 *
 * It declares a method (execute) for executing the Add User use case with the provided input data (AddUserInputData).
 *
 * Classes that implement this interface facilitate between the user interface and the business logic for adding
 * user accounts.
 *
 * @author jenniferwang
 * @version 1.0
 */
public interface AddUserInputBoundary {

    /**
     * Executes the Add User use case with the provided input data.
     *
     * @param addUserInputData the input data object containing information for adding a new User
     */
    void execute(AddUserInputData addUserInputData);
}

