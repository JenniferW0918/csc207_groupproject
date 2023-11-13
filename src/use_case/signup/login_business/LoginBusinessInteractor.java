package use_case.signup.login_business;

import entity.User;

public class LoginBusinessInteractor implements LoginBusinessInputBoundary {
    final LoginBusinessUserDataAccessInterface userBusinessDataAccessObject;
    final LoginBusinessOutputBoundary loginBusinessPresenter;

    public LoginBusinessInteractor(LoginBusinessUserDataAccessInterface userBusinessDataAccessInterface,
                           LoginBusinessOutputBoundary loginBusinessOutputBoundary) {
        this.userBusinessDataAccessObject = userBusinessDataAccessInterface;
        this.loginBusinessPresenter = loginBusinessOutputBoundary;
    }

    @Override
    public void execute(LoginBusinessInputData loginBusinessInputData) {
        String username = loginBusinessInputData.getUsername();
        String password = loginBusinessInputData.getPassword();
        if (!userBusinessDataAccessObject.existsByName(username)) {
            loginBusinessPresenter.prepareFailView(username + ": Account does not exist.");
        } else {
            String pwd = userBusinessDataAccessObject.get(username).getPassword();
            if (!password.equals(pwd)) {
                loginBusinessPresenter.prepareFailView("Incorrect password for " + username + ".");
            } else {

                User user = userBusinessDataAccessObject.get(loginBusinessInputData.getUsername());

                LoginBusinessOutputData loginBusinessOutputData = new LoginBusinessOutputData(user.getName(), false);
                loginBusinessPresenter.prepareSuccessView(loginBusinessOutputData);
            }
        }
    }
}