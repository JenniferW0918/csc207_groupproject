package interface_adapter.signup;

import use_case.signup.SignUpInputBoundary;
import use_case.signup.SignUpInputData;

public class SignUpController {

    final SignUpInputBoundary userSignUpUseCaseInteractor;
    public SignUpController(SignUpInputBoundary userSignUpUseCaseInteractor) {
        this.userSignUpUseCaseInteractor = userSignUpUseCaseInteractor;
    }

    public void execute(String username, String password1, String password2) {
        SignUpInputData signupInputData = new SignUpInputData(
                username, password1);

        userSignUpUseCaseInteractor.execute(signupInputData);
    }
}

