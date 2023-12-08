package interface_adapter.signin;

import interface_adapter.ViewManagerModel;
import interface_adapter.search_name.SearchNameViewModel;
import use_case.signin.SignInOutputBoundary;
import use_case.signin.SignInOutputData;
import interface_adapter.search_name.SearchNameState;

import javax.swing.*;

/**
 * The SignInPresenter class implements the SignInOutputBoundary for presenting the result of the signin use case.
 * It updates the associated view models and view manager based on the success or failure of the signin operation.
 * This presenter is responsible for preparing the success view by navigating to the search name view upon success,
 * and preparing the fail view by updating the signin view with specific error messages and displaying a message dialog.
 *
 * @author audrey
 * @version 1.0
 */
public class SignInPresenter implements SignInOutputBoundary {


    /**
     * The SignInViewModel associated with the sign-in presentation.
     */
    private final SignInViewModel signInViewModel;

    /**
     * The SearchNameViewModel associated with the sign-in presentation.
     */
    private final SearchNameViewModel searchNameViewModel;

    /**
     * The ViewManagerModel responsible for managing views in the application.
     */
    private ViewManagerModel viewManagerModel;


    /**
     * Constructs a SignInPresenter with the specified SignInViewModel, SearchNameViewModel, and ViewManagerModel.
     *
     * @param signInViewModel     The SignInViewModel associated with the sign-in presentation.
     * @param searchNameViewModel The SearchNameViewModel associated with the sign-in presentation.
     * @param viewManagerModel    The ViewManagerModel responsible for managing views in the application.
     */
    public SignInPresenter(SignInViewModel signInViewModel, SearchNameViewModel searchNameViewModel,
                           ViewManagerModel viewManagerModel) {
        this.signInViewModel = signInViewModel;
        this.searchNameViewModel = searchNameViewModel;
        this.viewManagerModel = viewManagerModel;
    }


    /**
     * Presents the success outcome of the sign-in use case to the associated ViewModel and ViewManagerModel.
     *
     * @param response The SignInOutputData representing the success outcome of the sign-in use case.
     */
    @Override
    public void prepareSuccessView(SignInOutputData response) {
        SearchNameState searchNameState = searchNameViewModel.getState();
        this.searchNameViewModel.setState(searchNameState);
        this.searchNameViewModel.firePropertyChanged();


        this.viewManagerModel.setActiveView(searchNameViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();


    }

    /**
     * Presents the failure outcome of the sign-in use case to the associated ViewModel and displays an error message.
     *
     * @param error The error message associated with the sign-in failure.
     */
    @Override
    public void prepareFailView(String error) {
        SignInState signInState = signInViewModel.getState();
        signInState.setUsernameError(error);
        signInViewModel.firePropertyChanged();

        JOptionPane.showMessageDialog(null, error);
    }


}

