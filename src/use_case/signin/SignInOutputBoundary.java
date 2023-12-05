package use_case.signin;

public interface SignInOutputBoundary {
    void prepareSuccessView(SignInOutputData user);

    void prepareFailView(String error);
}
