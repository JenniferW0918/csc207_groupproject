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


    private final SignInViewModel signInViewModel;
    private final SearchNameViewModel searchNameViewModel;
    private ViewManagerModel viewManagerModel;


    public SignInPresenter(SignInViewModel signInViewModel, SearchNameViewModel searchNameViewModel,
                           ViewManagerModel viewManagerModel) {
        this.signInViewModel = signInViewModel;
        this.searchNameViewModel = searchNameViewModel;
        this.viewManagerModel = viewManagerModel;
    }


    @Override
    public void prepareSuccessView(SignInOutputData response) {
        SearchNameState searchNameState = searchNameViewModel.getState();
        this.searchNameViewModel.setState(searchNameState);
        this.searchNameViewModel.firePropertyChanged();


        this.viewManagerModel.setActiveView(searchNameViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();


    }


    @Override
    public void prepareFailView(String error) {
        SignInState signInState = signInViewModel.getState();
        signInState.setUsernameError(error);
        signInViewModel.firePropertyChanged();

        JOptionPane.showMessageDialog(null, error);
    }


}

