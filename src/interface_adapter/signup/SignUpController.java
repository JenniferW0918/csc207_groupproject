package interface_adapter.signup;

import use_case.signup.SignUpInputBoundary;
import use_case.signup.SignUpInputData;

public class SignUpController {

    final SignUpInputBoundary signUpUseCaseInteractor;
    public SignUpController(SignUpInputBoundary signUpUseCaseInteractor) {
        this.signUpUseCaseInteractor = signUpUseCaseInteractor;
    }

    public void execute(String accountType) {
        SignUpInputData signupInputData = new SignUpInputData(accountType);

        signUpUseCaseInteractor.execute(signupInputData);
    }
}

