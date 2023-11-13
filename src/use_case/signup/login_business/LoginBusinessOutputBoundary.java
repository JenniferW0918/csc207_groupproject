package use_case.signup.login_business;

public interface LoginBusinessOutputBoundary {
    void prepareSuccessView(LoginBusinessOutputData user);

    void prepareFailView(String error);
}