package use_case.signup;

import entity.User;
import entity.UserFactory;
import interface_adapter.add_user.AddUserController;
import interface_adapter.add_user.AddUserPresenter;
import use_case.add_user.AddUserInteractor;
import view.AddUserView;

/**
 * The SignUpInteractor class implements the logic for the Sign Up (account type selection) use case.
 * It implements SignUpInputBoundary to act as the input boundary for the use case and interact with the presentation
 * layer differently depending on the account type that is selected (user or business).
 *
 * @author jenniferwang
 * @version 1.0
 */
public class SignUpInteractor implements SignUpInputBoundary {
    final SignUpOutputBoundary userPresenter;

    /**
     * Constructor for creating an instance of SignUpInteractor with the given output boundary.
     *
     * @param signupOutputBoundary the output boundary needed for sending the result to the presenter
     */
    public SignUpInteractor(SignUpOutputBoundary signupOutputBoundary) {

        this.userPresenter = signupOutputBoundary;
    }

    /**
     * Executes the sign up account type selection use case based on the given input data.
     *
     * @param signupInputData the input data containing information needed to move views based on the selected account
     *                        type
     */
    @Override
    public void execute(SignUpInputData signupInputData) {
        if (signupInputData.getAccountType() == "user") {
            userPresenter.prepareSuccessUserView(new SignUpOutputData("user"));
        } else {
            userPresenter.prepareSuccessBusinessView(new SignUpOutputData("business"));
        }
    }
}