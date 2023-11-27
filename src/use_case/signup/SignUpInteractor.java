package use_case.signup;

import entity.User;
import entity.UserFactory;
import interface_adapter.add_user.AddUserController;
import interface_adapter.add_user.AddUserPresenter;
import use_case.add_user.AddUserInteractor;
import view.AddUserView;

import java.time.LocalDateTime;

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
        if (signupInputData.getAccountType() == "user") {
            AddUserPresenter addUserPresenter = new AddUserPresenter(viewManagerModel, addUserViewModel, loginViewModel);
            AddUserInteractor addUserInteractor = new AddUserInteractor(userAddUserUseCaseInteractor);
            AddUserController addUserController = new AddUserController(userAddUserUseCaseInteractor);

            AddUserView addUserView = new AddUserView(addUserController, addUserViewModel);
            views.add(addUserView, addUserView.viewName);

        } else {
            userPresenter.prepareSuccessView(signupOutputData);
        }
    }
}