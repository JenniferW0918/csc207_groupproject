package interface_adapter.signup;

/**
 * The SignUprState class represents the state of the view during the sign up (account type selection) operation.
 * It encapsulates the account type data.
 * This class includes a copy constructor for creating a new instance based on an existing SignUpState object.
 * The default constructor is made explicit due to the presence of the copy constructor.
 *
 * @author jenniferwang
 * @version 1.0
 */
public class SignUpState {

    private String accountType = "";

    /**
     * Copy constructor for creating a new SignUpState instance based on an existing one.
     *
     * @param copy the SignUpState object to copy
     */
    public SignUpState(SignUpState copy) {

        accountType = copy.accountType;
    }

    /**
     * Default constructor for creating an empty SignUpState instance.
     */
    public SignUpState() {

    }

    /**
     * Retrieves the account type.
     *
     * @return the account type selected
     */
    public String getAccountType() {

        return accountType;
    }
}
