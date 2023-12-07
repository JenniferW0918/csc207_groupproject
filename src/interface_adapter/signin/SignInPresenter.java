package interface_adapter.signin;

import interface_adapter.ViewManagerModel;
import interface_adapter.search_name.SearchNameViewModel;
import use_case.signin.SignInOutputBoundary;
import use_case.signin.SignInOutputData;
import interface_adapter.search_name.SearchNameState;

import javax.swing.*;


public class SignInPresenter implements SignInOutputBoundary { // attempting push


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

