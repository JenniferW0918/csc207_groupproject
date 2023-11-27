package use_case.signup;

import entity.User;
import entity.UserFactory;

public class SignUpInteractor implements SignUpInputBoundary {
    final SignUpDataAccessInterface userDataAccessObject;
    final SignUpOutputBoundary userPresenter;
    final UserFactory userFactory;

    public SignUpInteractor(SignUpDataAccessInterface signupDataAccessInterface,
                            SignUpOutputBoundary signupOutputBoundary,
                            UserFactory userFactory) {
        this.userDataAccessObject = signupDataAccessInterface;
        this.userPresenter = signupOutputBoundary;
        this.userFactory = userFactory;
    }

    @Override
    public void execute(SignUpInputData signupInputData) {
        if (signupInputData.getAccountType() == "User") {
            userPresenter.prepareFailView("User already exists.");
        } else {
            SignUpOutputData signupOutputData = new SignUpOutputData(user.getName(), false);
            userPresenter.prepareSuccessView(signupOutputData);
        }
    }
}