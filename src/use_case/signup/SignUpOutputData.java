package use_case.signup;

/**
 * The SignUpOutputData class represents the output data produced by the Sign Up (account type selection) use case.
 *
 * Instances of this class are passed to the output boundary (SignUpOutputBoundary) for presentation purposes.
 *
 * @author jenniferwang
 * @version 1.0
 */
public class SignUpOutputData {

    private final String accountType;

    /**
     * Constructor for creating an instance of SignUpOutputData with the given account type to sign up with.
     *
     * @param accountType the selected account type to sign up with
     */
    public SignUpOutputData(String accountType) {


        this.accountType = accountType;
    }

    /**
     * Retrieves the selected account type to sign up with.
     *
     * @return the selected account type to sign up with
     */
    public String getAccountType() {


        return accountType;
    }
}
