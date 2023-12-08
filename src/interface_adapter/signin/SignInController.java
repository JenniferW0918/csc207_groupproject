package interface_adapter.signin;

import use_case.signin.SignInInputBoundary;
import use_case.signin.SignInInputData;

/**
 * The SignInController class serves as a controller for handling user interactions on the signin view.
 * It is responsible for initiating the use case of the signin view based the user input of a username and password.
 * The controller creates the necessary input data and delegates the execution to the SignInInteractor.
 *
 * @author audrey
 * @version 1.0
 */
public class SignInController {


    /**
     * The SignInInputBoundary responsible for handling the sign-in use case.
     */
    final SignInInputBoundary signInUseCaseInteractor;

    /**
     * Constructs a SignInController with the specified SignInInputBoundary.
     *
     * @param signInUseCaseInteractor The SignInInputBoundary responsible for handling the sign-in use case.
     */
    public SignInController(SignInInputBoundary signInUseCaseInteractor) {
        this.signInUseCaseInteractor = signInUseCaseInteractor;
    }


    /**
     * Executes the sign-in use case by providing the specified username and password.
     *
     * @param username The username associated with the user account.
     * @param password The password associated with the user account.
     */
    public void execute (String username, String password) {
        SignInInputData signInInputData = new SignInInputData(username, password);


        signInUseCaseInteractor.execute(signInInputData);
    }


}

