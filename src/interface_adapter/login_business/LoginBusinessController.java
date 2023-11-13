package interface_adapter.login_business;

import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;
import use_case.signup.login_business.LoginBusinessInputBoundary;
import use_case.signup.login_business.LoginBusinessInputData;

public class LoginBusinessController {

    final LoginBusinessInputBoundary loginBusinessUseCaseInteractor;
    public LoginBusinessController(LoginBusinessInputBoundary loginBusinessUseCaseInteractor) {
        this.loginBusinessUseCaseInteractor = loginBusinessUseCaseInteractor;
    }


    public void execute(String username, String password) {
        LoginBusinessInputData loginInputData = new LoginBusinessInputData(
                username, password);

        loginBusinessUseCaseInteractor.execute(loginInputData);
    }
}
