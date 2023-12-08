package app;

import data_access.Accounts;
import interface_adapter.ViewManagerModel;
import interface_adapter.search_name.SearchNameViewModel;
import interface_adapter.signin.SignInController;
import interface_adapter.signin.SignInPresenter;
import interface_adapter.signin.SignInViewModel;
import use_case.signin.SignInInputBoundary;
import use_case.signin.SignInInteractor;
import use_case.signin.SignInOutputBoundary;
import view.SignInView;

import javax.swing.*;
import java.io.IOException;

/**
 * The {@code SignInUseCaseFactory} class is responsible for creating instances related to the "Sign In" use case.
 * It provides a factory method to create the {@code SignInView} along with its associated controller and presenter.
 *
 * @author audrey
 * @version 1.0
 */
public class SignInUseCaseFactory {

    private SignInUseCaseFactory() {}

    /**
     * Creates an instance of the {@code SignInView} along with its associated controller and presenter.
     *
     * @param viewManagerModel The model responsible for managing the active view.
     * @param signInViewModel The view model associated with the "Sign In" use case.
     * @param searchNameViewModel The view model associated with the search name functionality.
     * @param dataAccessObject The data access object providing access to user accounts.
     * @return The created {@code SignInView}.
     */
    public static SignInView createSignInView(
            ViewManagerModel viewManagerModel,
            SignInViewModel signInViewModel,
            SearchNameViewModel searchNameViewModel,
            Accounts dataAccessObject) {

        try {
            SignInController signInController = createSignInUseCase(viewManagerModel, signInViewModel,
                    searchNameViewModel, dataAccessObject);
            return new SignInView(signInViewModel, signInController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file");
        }
        return null;
    }

    /**
     * Creates an instance of the {@code SignInController} to handle the "Sign In" use case.
     *
     * @param viewManagerModel The model responsible for managing the active view.
     * @param signInViewModel The view model associated with the "Sign In" use case.
     * @param searchNameViewModel The view model associated with the search name functionality.
     * @param dataAccessObject The data access object providing access to user accounts.
     * @return The created {@code SignInController}.
     * @throws IOException If there is an issue reading user data.
     */
    private static SignInController createSignInUseCase(
            ViewManagerModel viewManagerModel,
            SignInViewModel signInViewModel,
            SearchNameViewModel searchNameViewModel,
            Accounts dataAccessObject) throws IOException {
        SignInOutputBoundary signInOutputBoundary = new SignInPresenter(signInViewModel, searchNameViewModel,
                viewManagerModel);

        SignInInputBoundary signInInteractor = new SignInInteractor(dataAccessObject, signInOutputBoundary);

        return new SignInController(signInInteractor);
    }


}
