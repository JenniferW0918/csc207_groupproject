package use_case.add_business;

/**
 * The AddBusinessAccountOutputData class represents the output data produced by the Add Business Account use case.
 * It encapsulates information about the added business account, including the username, and whether the use case
 * execution failed.
 *
 * Instances of this class are created by the AddBusinessAccountInteractor and passed to the output boundary
 * (AddBusinessAccountOutputBoundary) for presentation purposes.
 *
 * @author audrey
 * @version 1.0
 */
public class AddBusinessAccountOutputData {

    /**
     * The username of the added business account.
     */
    private final String username;

    /**
     * A boolean flag indicating whether the execution of the Add Business Account use case failed.
     */
    private boolean useCaseFailed;

    /**
     * Constructs a new AddBusinessAccountOutputData with the specified username and use case failure status.
     *
     * @param username The username of the added business account.
     * @param useCaseFailed True if the use case execution failed; otherwise, false.
     */
    public AddBusinessAccountOutputData(String username, boolean useCaseFailed) {
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

    /**
     * Gets the username of the added business account.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }


}


