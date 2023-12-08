package use_case.signup;

/**
 * The SignUpOutputBoundary class defines the output boundary for the Sign Up (account type selection) use case.
 *
 * Classes that implement this interface are expected to define the response for when the account type selected is user
 * for when the account type selected is business.
 *
 * @author jenniferwang
 * @version 1.0
 */
public interface SignUpOutputBoundary {

    /**
     * Prepares the view for when the selected account type is user.
     *
     * @param user the SignUpOutputData containing the selected account type
     */
    void prepareSuccessUserView(SignUpOutputData user);

    /**
     * Prepares the view for when the selected account type is business.
     *
     * @param user the SignUpOutputData containing the selected account type
     */
    void prepareSuccessBusinessView(SignUpOutputData user);}
