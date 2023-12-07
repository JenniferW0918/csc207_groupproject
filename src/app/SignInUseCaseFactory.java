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

public class SignInUseCaseFactory {

    private SignInUseCaseFactory() {}

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
