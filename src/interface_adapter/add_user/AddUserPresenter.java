package interface_adapter.add_user;

import interface_adapter.LoginState;
import interface_adapter.LoginViewModel;
import use_case.add_user.AddUserOutputBoundary;
import use_case.add_user.AddUserOutputData;
import interface_adapter.ViewManagerModel;

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

