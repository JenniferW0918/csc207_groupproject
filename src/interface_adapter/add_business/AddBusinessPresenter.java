package interface_adapter.signup;

import interface_adapter.ViewManagerModel;
import interface_adapter.add_business.AddBusinessViewModel;
import use_case.add_business.AddBusinessOutputBoundary;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddBusinessPresenter implements AddBusinessOutputBoundary {

    private final AddBusinessViewModel addBusinessViewModel;
    private final AddBusinessViewModel loginViewModel;
    private ViewManagerModel viewManagerModel;

    public AddBusinessPresenter(ViewManagerModel viewManagerModel,
                                AddBusinessViewModel addBusinessViewModel,
                           LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.addBusinessViewModel = addBusinessViewModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(AddBusinessOutputData response) {
        // On success, switch to the login view.
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));

        LoginState loginState = loginViewModel.getState();
        loginState.setUsername(response.getUsername());
        this.loginViewModel.setState(loginState);
        loginViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        AddBusinessState addBusinessState = addBusinessViewModel.getState();
        addBusinessState.setUsernameError(error);
        addBusinessViewModel.firePropertyChanged();
    }
}

