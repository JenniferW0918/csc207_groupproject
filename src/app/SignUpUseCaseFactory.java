package app;

import data_access.Accounts;
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

/**
 * Factory class for creating components for the Sign Up use case.
 */
public class SignUpUseCaseFactory {

    private SignUpUseCaseFactory() {}

    /**
     * Creates an instance of SignUpView with the necessary dependencies.
     *
     * @param viewManagerModel the model that manages the views in the application
     * @param signUpViewModel the view model for the Sign Up use case
     * @param addUserViewModel the view model for the Add User use case
     * @param addBusinessAccountViewModel the view model for the Add Business use case
     * @param dataAccessObject the data access object for created accounts
     * @return an instance of SignUpView
     */
    public static SignUpView createSignUpView(
            ViewManagerModel viewManagerModel,
            SignUpViewModel signUpViewModel,
            AddUserViewModel addUserViewModel,
            AddBusinessAccountViewModel addBusinessAccountViewModel,
            Accounts dataAccessObject) {

            SignUpController signUpController = createSignUpUseCase(viewManagerModel, addUserViewModel,
                    addBusinessAccountViewModel, dataAccessObject);
            return new SignUpView(signUpController, signUpViewModel, viewManagerModel);
    }

    private static SignUpController createSignUpUseCase(ViewManagerModel viewManagerModel,
                                                            AddUserViewModel addUserViewModel,
                                                            AddBusinessAccountViewModel addBusinessAccountViewModel,
                                                            Accounts dataAccessObject) {

        SignUpOutputBoundary signupOutputBoundary = new SignUpPresenter(viewManagerModel, addUserViewModel,
                addBusinessAccountViewModel, dataAccessObject);

        SignUpInputBoundary userSignupInteractor = new SignUpInteractor(
                signupOutputBoundary);

        return new SignUpController(userSignupInteractor);
    }

}