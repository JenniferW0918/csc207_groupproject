package interface_adapter.signup;

import interface_adapter.ViewManagerModel;
import interface_adapter.add_business.AddBusinessAccountViewModel;
import interface_adapter.add_business.AddBusinessAccountState;
import interface_adapter.LoginUserViewModel;
import interface_adapter.LoginUserState;
import use_case.add_business.AddBusinessAccountOutputBoundary;
import use_case.add_business.AddBusinessAccountOutputData;

public class AddBusinessAccountPresenter implements AddBusinessAccountOutputBoundary {

    private final AddBusinessAccountViewModel addBusinessAccountViewModel;
    private final LoginUserViewModel loginUserViewModel;
    private ViewManagerModel viewManagerModel;

    public AddBusinessAccountPresenter(ViewManagerModel viewManagerModel,
                                       AddBusinessAccountViewModel addBusinessViewModel,
                                       LoginUserViewModel loginUserViewModel, LoginUserViewModel loginUserViewModel1) {
        this.viewManagerModel = viewManagerModel;
        this.addBusinessAccountViewModel = addBusinessViewModel;
        this.loginUserViewModel = loginUserViewModel1;
    }

    @Override
    public void prepareSuccessView(AddBusinessAccountOutputData response) {
        // On success, switch to the login view.
        //LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
        //response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));

        LoginUserState loginUserState = loginUserViewModel.getState();
        loginUserState.setUsername(response.getUsername());
        this.loginUserViewModel.setState(loginUserState);
        loginUserViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(loginUserViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        AddBusinessAccountState addBusinessAccountState = addBusinessAccountViewModel.getState();
        addBusinessAccountState.setUsernameError(error);
        addBusinessAccountViewModel.firePropertyChanged();
    }
}

