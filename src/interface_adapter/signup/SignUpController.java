package interface_adapter.signup;

import use_case.signup.SignUpInputBoundary;
import use_case.signup.SignUpInputData;

/**
 * This is the controller class for initiating the Sign Up (sign up account selection) use case.
 * It takes an accountType, uses it to create the input data, and then passes on the execution of the use case
 * to the interactor (SignUpInteractor).
 *
 * @author jenniferwang
 * @version 1.0
 */
public class SignUpController {

    final SignUpInputBoundary signUpUseCaseInteractor;

    /**
     * Constructor for creating an instance of SignUpController.
     *
     * @param signUpUseCaseInteractor the SignUpInputBoundary that will help execute the use case
     */
    public SignUpController(SignUpInputBoundary signUpUseCaseInteractor) {

        this.signUpUseCaseInteractor = signUpUseCaseInteractor;
    }

    /**
     * Executes the account type selection use case depending on the given account type
     *
     * @param accountType the type of account for the use case
     */
    public void execute(String accountType) {

        SignUpInputData signupInputData = new SignUpInputData(accountType);
        signUpUseCaseInteractor.execute(signupInputData);
    }
}

