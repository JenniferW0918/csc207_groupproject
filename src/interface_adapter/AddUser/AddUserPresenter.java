package interface_adapter.AddUser;

import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import use_case.signup.AddUserOutputBoundary;
import use_case.signup.AddUserOutputData;

public class AddUserPresenter implements AddUserOutputBoundary {

    private final AddUserViewModel addUserViewModel;
    private final LoginViewModel loginViewModel;
    private ViewManagerModel viewManagerModel;

    public AddUserPresenter(ViewManagerModel viewManagerModel,
                                AddUserViewModel addUserViewModel,
                                LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.addUserViewModel = addUserViewModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(AddUserOutputData response) {
        // On success, switch to the login view.

        LoginState loginState = loginViewModel.getState();
        loginState.setUsername(response.getUsername());
        this.loginViewModel.setState(loginState);
        loginViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        AddUserState addUserState = addUserViewModel.getState();
        addUserState.setUsernameError(error);
        addUserViewModel.firePropertyChanged();
    }
}
