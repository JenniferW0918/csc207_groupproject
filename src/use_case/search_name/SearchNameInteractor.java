package use_case.search_name;
import entity.SearchNameResult;
import org.json.JSONException;
import org.json.JSONObject;


import data_access.SearchNameDataAccessObject;

import java.io.IOException;

public class SearchNameInteractor implements SearchNameInputBoundary {
    final SearchNameDataAccessInterface searchNameDataAccessObject;
    final SearchNameOutputBoundary searchNamePresenter;


    public SearchNameInteractor(SearchNameDataAccessInterface dataAccessInterface, SearchNameOutputBoundary outputBoundary) {
        this.searchNameDataAccessObject = dataAccessInterface;
        this.searchNamePresenter = outputBoundary;
    }

    @Override
    public void execute(SearchNameInputData searchNameInputData) {

        SearchNameResult searchNameResult = searchNameDataAccessObject.getSearchName(searchNameInputData);

        if(searchNameResult == null){
            searchNamePresenter.prepareFailView("No results found :(");
        }
        else {
            SearchNameOutputData searchNameOutputData = new SearchNameOutputData(searchNameResult, false);
            searchNamePresenter.prepareSuccessView(searchNameOutputData);
        }
    }
}