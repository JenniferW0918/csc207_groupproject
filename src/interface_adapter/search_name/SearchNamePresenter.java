package interface_adapter.search_name;

import interface_adapter.ViewManagerModel;
import use_case.search_name.SearchNameOutputBoundary;
import use_case.search_name.SearchNameOutputData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SearchNamePresenter implements SearchNameOutputBoundary {
    private final SearchNameViewModel searchNameViewModel;
    private ViewManagerModel viewManagerModel;

    public SearchNamePresenter(SearchNameViewModel searchNameViewModel, ViewManagerModel viewManagerModel) {
        this.searchNameViewModel = searchNameViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    //// Continue here
    @Override
    public void presentSearchName(SearchNameOutputData outputData) {

    }

    @Override
    public void prepareSuccessView(SearchNameOutputData searchNameOutputData) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}