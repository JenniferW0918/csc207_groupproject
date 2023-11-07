package use_case.signup;

public interface AddBusinessOutputBoundary {
    void prepareSuccessView(AddBusinessOutputData user);

    void prepareFailView(String error);
}