package interface_adapter.search_name;

import interface_adapter.ViewManagerModel;
import interface_adapter.seached_name.SearchedNameState;
import interface_adapter.seached_name.SearchedNameViewModel;
import use_case.search_name.SearchNameOutputBoundary;
import use_case.search_name.SearchNameOutputData;

import javax.swing.*;


public class SearchNamePresenter implements SearchNameOutputBoundary {
    private final SearchNameViewModel searchNameViewModel;
    private final ViewManagerModel viewManagerModel;
    private final SearchedNameViewModel searchedNameViewModel;

    public SearchNamePresenter(SearchNameViewModel searchNameViewModel, ViewManagerModel viewManagerModel,
                               SearchedNameViewModel searchedNameViewModel){
        this.searchNameViewModel = searchNameViewModel;
        this.viewManagerModel = viewManagerModel;
        this.searchedNameViewModel = searchedNameViewModel;
    }


    @Override
    public void prepareSuccessView(SearchNameOutputData searchNameOutputData) {

        /// switches to SearchedNameView and sets its state
        SearchedNameState searchedNameState = searchedNameViewModel.getState();
        searchedNameState.setTerm(searchNameOutputData.getSearchNameResult().getTerm());
        searchedNameState.setLocation(searchNameOutputData.getSearchNameResult().getLocation());
        searchedNameState.setSearchResults(searchNameOutputData.getSearchNameResult().toString());
        // make set search results be a turned to a String[]
        searchedNameState.setSearchResultsInteractive(searchNameOutputData.getSearchNameResult());


        searchedNameViewModel.setState(searchedNameState);

        searchedNameViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(searchedNameViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(String error) {
        SearchNameState searchNameState = searchNameViewModel.getState();
        searchNameState.setLocationError(error);
        searchNameState.setTermError(error);
        searchNameViewModel.setState(searchNameState);

        searchNameViewModel.firePropertyChanged();


        JOptionPane.showMessageDialog(null, error);

    }
}