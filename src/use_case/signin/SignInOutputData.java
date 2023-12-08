package use_case.signin;

/**
 * The SignInOutputData class represents the output data of a Sign-In use case. It encapsulates information about
 * the result of a Sign-In attempt, including the username and whether the use case failed.
 *
 * Instances of this class are created and returned by the Sign-In business logic to communicate the results of
 * Sign-In attempts to the output boundary (SignInOutputBoundary).
 *
 * @author audrey
 * @version 1.0
 */
public class SignInOutputData {

    /**
     * The username associated with the Sign-In attempt.
     */
    private final String username;

    /**
     * A flag indicating whether the Sign-In use case failed.
     */
    private boolean useCaseFailed;

    /**
     * Constructs a new SignInOutputData with the specified username and failure status.
     *
     * @param username The username associated with the Sign-In attempt.
     * @param useCaseFailed A boolean flag indicating whether the Sign-In use case failed.
     */
    public SignInOutputData(String username, boolean useCaseFailed) {
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

    /**
     * Gets the username associated with the Sign-In attempt.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }
}
