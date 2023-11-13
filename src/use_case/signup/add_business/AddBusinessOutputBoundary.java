package use_case.signup.add_business;

public interface AddBusinessOutputBoundary {
    void prepareSuccessView(AddBusinessOutputData user);

    void prepareFailView(String error);
}