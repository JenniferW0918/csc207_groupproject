package use_case.add_business;
import use_case.AddBusinessOutputData;


public interface AddBusinessOutputBoundary {
    void prepareSuccessView(AddBusinessOutputData user);

    void prepareFailView(String error);
}
