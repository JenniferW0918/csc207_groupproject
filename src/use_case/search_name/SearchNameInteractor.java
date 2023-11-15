package use_case.search_name;


import entity.User;
import entity.UserFactory;

import java.time.LocalDateTime;

public class SearchNameInteractor implements SearchNameInputBoundary {
    final SearchNameDataAccessInterface dataAccessInterface;
    final SearchNameOutputBoundary outputBoundary;
    final BusinessFactory businessFactory;


    public SearchNameInteractor(SearchNameDataAccessInterface dataAccessInterface, SearchNameOutputBoundary outputBoundary) {
        this.dataAccessInterface = dataAccessInterface;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void execute(SearchNameInputData searchNameInputData) {
        // Perform the search using inputData
        // use api to make a request
        // Then create SearchNameOutputData and pass it to the output boundary
    }
}