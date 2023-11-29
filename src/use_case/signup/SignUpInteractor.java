package use_case.signup;

import entity.User;
import entity.UserFactory;
import interface_adapter.add_user.AddUserController;
import interface_adapter.add_user.AddUserPresenter;
import use_case.add_user.AddUserInteractor;
import view.AddUserView;

public class SignUpInteractor implements SignUpInputBoundary {
    final SignUpOutputBoundary userPresenter;

    public SignUpInteractor(SignUpOutputBoundary signupOutputBoundary) {
        this.userPresenter = signupOutputBoundary;
    }

    @Override
    public void execute(SignUpInputData signupInputData) {
        /*if (signupInputData.getAccountType() == "user") {
            userPresenter.prepareSuccessUserView(new SignUpOutputData("user"));
        } else {
            userPresenter.prepareSuccessBusinessView(new SignUpOutputData("business"));
        }*/
        userPresenter.prepareSuccessView(new SignUpOutputData(signupInputData.getAccountType()));
    }
}