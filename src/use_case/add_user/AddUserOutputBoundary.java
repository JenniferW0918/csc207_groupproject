package use_case.add_user;

public interface AddUserOutputBoundary {
    void prepareSuccessView(AddUserOutputData user);
    void prepareFailView(String error);
}
