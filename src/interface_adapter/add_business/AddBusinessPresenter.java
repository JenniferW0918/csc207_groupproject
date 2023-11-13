public class LoginBusinessPresenter implements LoginBusinessOutputBoundary {

    private final LoginBusinessViewModel loginViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private ViewManagerModel viewManagerModel;

    public LoginBusinessPresenter(ViewManagerModel viewManagerModel,
                                  LoggedInViewModel loggedInViewModel,
                                  LoginBusinessViewModel loginBusinessViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel = loggedInViewModel;
        this.loginBusinessViewModel = loginBusinessViewModel;
    }

    @Override
    public void prepareSuccessView(LoginBusinessOutputData response) {
        // On success, switch to the logged in view.

        LoggedInState loggedInState = loggedInViewModel.getState();
        loggedInState.setUsername(response.getUsername());
        this.loggedInViewModel.setState(loggedInState);
        this.loggedInViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(loggedInViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        LoginState loginState = loginBusinessViewModel.getState();
        loginState.setUsernameError(error);
        loginBusinessViewModel.firePropertyChanged();
    }
}

