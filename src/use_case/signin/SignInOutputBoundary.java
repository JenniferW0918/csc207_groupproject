package use_case.signin;

public interface SignInOutputBoundary { // attempting push
    void prepareSuccessView(SignInOutputData user);


    void prepareFailView(String error);
}

