package use_case.add_user;

/**
 * The AddUserOutputBoundary class defines the output boundary for the Add User use case.
 *
 * Classes that implement this interface are expected to define the response to both a successful and a failed
 * user creation.
 *
 * @author jenniferwang
 * @version 1.0
 */
public interface AddUserOutputBoundary {

    /**
     * Prepares the view that will show upon a successful user creation.
     *
     * @param user the AddUserOutputData containing information about the successfully added user
     */
    void prepareSuccessView(AddUserOutputData user);

    /**
     * Prepares the view that will show upon a failed user creation.
     *
     * @param error an error message for when the "add user" operation fails
     */
    void prepareFailView(String error);
}
