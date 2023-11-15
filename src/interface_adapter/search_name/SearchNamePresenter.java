package interface_adapter.search_name;

import use_case.search_name.SearchNameOutputBoundary;
import use_case.search_name.SearchNameOutputData;

public class SearchNamePresenter implements SearchNameOutputBoundary {
    @Override
    public void presentSearchName(SearchNameOutputData outputData) {
        // Convert outputData to a format suitable for the view or response
    }

    @Override
    public void prepareSuccessView(SearchNameOutputData searchNameOutputData) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}