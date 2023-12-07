package use_case.add_business;


public interface AddBusinessAccountOutputBoundary {
    void prepareSuccessView(AddBusinessAccountOutputData user);

    void prepareFailView(String error);
}
