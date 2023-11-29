package app;

import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.AddBusinessAccountPresenter;
import interface_adapter.signup.SignUpController;
import interface_adapter.signup.SignUpPresenter;
import interface_adapter.signup.SignUpViewModel;
import entity.UserFactory;
import interface_adapter.*;
import use_case.signup.SignUpInputBoundary;
import use_case.signup.SignUpInteractor;
import use_case.signup.SignUpOutputBoundary;
import view.SignUpView;

import javax.swing.*;
import java.io.IOException;

public class SignUpUseCaseFactory {

    /** Prevent instantiation. */
    private SignUpUseCaseFactory() {}

    public static SignUpView create(
            ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, SignUpViewModel signupViewModel, SignUpDataAccessInterface userDataAccessObject) {

        try {
            SignUpController signupController = createUserSignupUseCase(viewManagerModel, signupViewModel, loginViewModel, userDataAccessObject);
            return new SignUpView(signupController, signupViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static SignUpController createUserSignupUseCase(ViewManagerModel viewManagerModel, SignUpViewModel signupViewModel, LoginViewModel loginViewModel, SignUpDataAccessInterface userDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        SignUpOutputBoundary signupOutputBoundary = new SignUpPresenter(viewManagerModel, signupViewModel, loginViewModel);

        UserFactory userFactory = new UserFactory();

        SignUpInputBoundary userSignupInteractor = new SignUpInteractor(
                userDataAccessObject, signupOutputBoundary, userFactory);

        return new SignUpController(userSignupInteractor);
    }

}