package use_case.search_name;
import entity.SearchNameResult;
import org.json.JSONObject;


import data_access.SearchNameDataAccessObject;

public class SearchNameInteractor implements SearchNameInputBoundary {
    final SearchNameDataAccessInterface dataAccessInterface;
    final SearchNameOutputBoundary outputBoundary;


    public SearchNameInteractor(SearchNameDataAccessInterface dataAccessInterface, SearchNameOutputBoundary outputBoundary, BusinessFactory businessFactory) {
        this.dataAccessInterface = dataAccessInterface;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void execute(SearchNameInputData searchNameInputData){


    SearchNameResult searchNameResult = dataAccessInterface.getSearchName(searchNameInputData);

    if(searchNameResult == null){  // is it null if no results found?
        outputBoundary.prepareFailView("No results found");
    }

    SearchNameOutputData searchNameOutputData = new SearchNameOutputData(searchNameResult, false);
    outputBoundary.prepareSuccessView(searchNameOutputData);

    }
}