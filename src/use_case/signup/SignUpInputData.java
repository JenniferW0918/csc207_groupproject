package use_case.signup;

/**
 * The SignUpInputData class stores the input data for the Sign Up (account type selection) use case.
 * It encapsulates the accountType parameter needed to decide with view to move to.
 *
 * @author jenniferwang
 * @version 1.0
 */
public class SignUpInputData {

    final private String accountType;

    /**
     * Constructor for creating an instance of SignUpInputData with the given accountType.
     *
     * @param accountType the account type that was selected
     */
    public SignUpInputData(String accountType) {

        this.accountType = accountType;
    }

    /**
     * Retrieves the account type that was selected during the sign up account type selection use case.
     *
     * @return the account type that was selected during the sign up account type selection use case.
     */
    String getAccountType() {

        return accountType;
    }
}
