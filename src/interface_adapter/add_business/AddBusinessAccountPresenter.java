package interface_adapter.signup;

import interface_adapter.ViewManagerModel;
import interface_adapter.add_business.AddBusinessAccountViewModel;
import interface_adapter.add_business.AddBusinessAccountState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.login.LoginState;
import use_case.add_business.AddBusinessAccountOutputBoundary;
import use_case.add_business.AddBusinessAccountOutputData;

public class AddBusinessAccountPresenter implements AddBusinessAccountOutputBoundary {

    private final AddBusinessAccountViewModel addBusinessAccountViewModel;
    private final LoginViewModel loginViewModel;
    private ViewManagerModel viewManagerModel;

    public AddBusinessAccountPresenter(ViewManagerModel viewManagerModel,
                                       AddBusinessAccountViewModel addBusinessViewModel,
                                       LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.addBusinessAccountViewModel = addBusinessViewModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(AddBusinessAccountOutputData response) {

        LoginState loginState = loginViewModel.getState();
        loginState.setUsername(response.getUsername());
        this.loginViewModel.setState(loginState);
        loginViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        AddBusinessAccountState addBusinessAccountState = addBusinessAccountViewModel.getState();
        addBusinessAccountState.setUsernameError(error);
        addBusinessAccountViewModel.firePropertyChanged();
    }
}

