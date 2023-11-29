package interface_adapter.signup;

import interface_adapter.search_name.SearchNameViewModel
import interface_adapter.ViewManagerModel;
import use_case.signup.SignUpOutputBoundary;
import use_case.signup.SignUpOutputData;

public class SignUpPresenter implements SignUpOutputBoundary {

    private final SignUpViewModel signupViewModel;
    private final SearchNameViewModel searchNameViewModel;
    private ViewManagerModel viewManagerModel;

    public SignUpPresenter(ViewManagerModel viewManagerModel,
                           SignUpViewModel signupViewModel,
                           SearchNameViewModel searchNameViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.signupViewModel = signupViewModel;
        this.searchNameViewModel = searchNameViewModel;
    }

    @Override
    public void prepareSuccessUserView(SignUpOutputData response) {
        // On success, switch to the create user view.
        LoginState loginState = loginViewModel.getState();
        loginState.setUsername(response.getUsername());
        this.loginViewModel.setState(loginState);
        loginViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareSuccessBusinessView(SignUpOutputData response) {
        SignUpState signupState = signupViewModel.getState();
        signupViewModel.firePropertyChanged();
    }
}
