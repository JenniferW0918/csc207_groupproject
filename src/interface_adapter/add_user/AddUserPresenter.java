package interface_adapter.add_user;

import interface_adapter.add_user.LoginUserState;
import interface_adapter.add_user.LoginUserViewModel;
import use_case.add_user.AddUserOutputBoundary;
import use_case.add_user.AddUserOutputData;
import interface_adapter.ViewManagerModel;

public class AddUserPresenter implements AddUserOutputBoundary {

    private final AddUserViewModel addUserViewModel;
    private final LoginUserViewModel loginUserViewModel;
    private ViewManagerModel viewManagerModel;

    public AddUserPresenter(ViewManagerModel viewManagerModel,
                            AddUserViewModel addUserViewModel,
                            LoginUserViewModel loginUserViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.addUserViewModel = addUserViewModel;
        this.loginUserViewModel = loginUserViewModel;
    }

    @Override
    public void prepareSuccessView(AddUserOutputData response) {
        // On success, switch to the login view.

        LoginUserState loginUserState = loginUserViewModel.getState();
        loginUserState.setUsername(response.getUsername());
        this.loginUserViewModel.setState(loginUserState);
        loginUserViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(loginUserViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        AddUserState addUserState = addUserViewModel.getState();
        addUserState.setUsernameError(error);
        addUserViewModel.firePropertyChanged();
    }
}

