package use_case.add_user;

/**
 * The AddUserOutputData class represents the output data produced by the Add User use case.
 * It encapsulates information about the added user and whether the use case execution failed.
 *
 * Instances of this class are passed to the output boundary (AddUserOutputBoundary) for presentation purposes.
 *
 * @author jenniferwang
 * @version 1.0
 */
public class AddUserOutputData {

    private final String username;
    private boolean useCaseFailed;

    /**
     * Constructor for creating an instance of AddUserOutputData with the given username and use case failure flag.
     *
     * @param username the username of the added user
     * @param useCaseFailed a boolean flag indicating whether the Add User use case failed
     */
    public AddUserOutputData(String username, boolean useCaseFailed) {

        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

    /**
     * Retrieves the username of the added user.
     *
     * @return the username of the added user
     */
    public String getUsername() {

        return username;
    }
}
