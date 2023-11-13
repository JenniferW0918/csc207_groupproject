package use_case.signup;

public interface AddUserOutputBoundary {
    void prepareSuccessView(AddUserOutputData user);
    void prepareFailView(String error);
}