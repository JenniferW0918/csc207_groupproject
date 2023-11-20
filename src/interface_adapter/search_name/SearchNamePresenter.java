package interface_adapter.search_name;

import interface_adapter.ViewManagerModel;
import use_case.search_name.SearchNameOutputBoundary;
import use_case.search_name.SearchNameOutputData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SearchNamePresenter implements SearchNameOutputBoundary {
    private final SearchNameViewModel searchNameViewModel;
    private final ViewManagerModel viewManagerModel;

    public SearchNamePresenter(SearchNameViewModel searchNameViewModel, ViewManagerModel viewManagerModel) {
        this.searchNameViewModel = searchNameViewModel;
        this.viewManagerModel = viewManagerModel;
    }


    @Override
    public void prepareSuccessView(SearchNameOutputData searchNameOutputData) {
        SearchNameState searchNameState = searchNameViewModel.getState(); //returns state object
        searchNameState.setTerm(searchNameOutputData.getSearchNameResult().getTerm());

        this.searchNameViewModel.setState(searchNameState);

        searchNameViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(searchNameViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(String error) {
        SearchNameState searchNameState = searchNameViewModel.getState();
        searchNameState.setLocationError(error);
        searchNameState.setTermError(error);

        searchNameViewModel.firePropertyChanged();
    }
}