package use_case.add_business;
import use_case.add_business.AddBusinessAccountOutputData;


public interface AddBusinessAccountOutputBoundary {
    void prepareSuccessView(AddBusinessAccountOutputData user);

    void prepareFailView(String error);
}
