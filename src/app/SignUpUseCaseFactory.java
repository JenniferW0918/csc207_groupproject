package app;

import interface_adapter.add_business.AddBusinessAccountViewModel;
import interface_adapter.add_user.AddUserViewModel;
import interface_adapter.search_name.SearchNameViewModel;
import interface_adapter.signup.SignUpController;
import interface_adapter.signup.SignUpPresenter;
import interface_adapter.signup.SignUpViewModel;
import entity.UserFactory;
import interface_adapter.*;
import use_case.add_business.AddBusinessAccountDataAccessInterface;
import use_case.signup.SignUpInputBoundary;
import use_case.signup.SignUpInteractor;
import use_case.signup.SignUpOutputBoundary;
import view.SignUpView;

import javax.swing.*;
import java.io.IOException;

public class SignUpUseCaseFactory {

    /** Prevent instantiation. */
    private SignUpUseCaseFactory() {}

    public static SignUpView createSignUpView(
            ViewManagerModel viewManagerModel,
            SignUpViewModel signUpViewModel,
            AddUserViewModel addUserViewModel,
            AddBusinessAccountViewModel addBusinessAccountViewModel) {

            SignUpController signUpController = createUserSignupUseCase(viewManagerModel, addUserViewModel, addBusinessAccountViewModel);
            return new SignUpView(signUpController, signUpViewModel);
    }

    private static SignUpController createUserSignupUseCase(ViewManagerModel viewManagerModel,
                                                            AddUserViewModel addUserViewModel,
                                                            AddBusinessAccountViewModel addBusinessAccountViewModel) {

        // Notice how we pass this method's parameters to the Presenter.
        SignUpOutputBoundary signupOutputBoundary = new SignUpPresenter(viewManagerModel, addUserViewModel, addBusinessAccountViewModel);

        SignUpInputBoundary userSignupInteractor = new SignUpInteractor(
                signupOutputBoundary);

        return new SignUpController(userSignupInteractor);
    }

}