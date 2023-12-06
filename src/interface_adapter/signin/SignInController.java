package interface_adapter.signin;

import use_case.signin.SignInInputBoundary;
import use_case.signin.SignInInputData;


public class SignInController { // attempting push


    final SignInInputBoundary signInUseCaseInteractor;


    public SignInController(SignInInputBoundary signInUseCaseInteractor) {
        this.signInUseCaseInteractor = signInUseCaseInteractor;
    }


    public void execute (String username, String password) {
        SignInInputData signInInputData = new SignInInputData(username, password);


        signInUseCaseInteractor.execute(signInInputData);
    }


}

