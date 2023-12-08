package interface_adapter.search_name;

import interface_adapter.ViewManagerModel;
import interface_adapter.seached_name.SearchedNameState;
import interface_adapter.seached_name.SearchedNameViewModel;
import use_case.search_name.SearchNameOutputBoundary;
import use_case.search_name.SearchNameOutputData;
import javax.swing.*;

/** The SearchNamePresenter implements the SearchNameOutputBoundary interface.
 * SearchNamePresenter updates the view model for the SearchNameView.
 * */
public class SearchNamePresenter implements SearchNameOutputBoundary {
    private final SearchNameViewModel searchNameViewModel;
    private final ViewManagerModel viewManagerModel;
    private final SearchedNameViewModel searchedNameViewModel;

    /** This constructor creates a new SearchNamePresenter object.
     * @param searchNameViewModel The view model for the SearchNameView.
     * @param viewManagerModel The view manager model.
     * @param searchedNameViewModel The view model for the SearchedNameView.
     * */
    public SearchNamePresenter(SearchNameViewModel searchNameViewModel, ViewManagerModel viewManagerModel,
                               SearchedNameViewModel searchedNameViewModel){
        this.searchNameViewModel = searchNameViewModel;
        this.viewManagerModel = viewManagerModel;
        this.searchedNameViewModel = searchedNameViewModel;
    }

    /** This method prepares the success view on revieving the searchNameOutputData
     * @param searchNameOutputData the output data from the search name use case
     *                            containing the search results
     * */
    @Override
    public void prepareSuccessView(SearchNameOutputData searchNameOutputData) {

        /// switches to SearchedNameView and sets its state
        SearchedNameState searchedNameState = searchedNameViewModel.getState();
        searchedNameState.setTerm(searchNameOutputData.getSearchNameResult().getTerm());
        searchedNameState.setLocation(searchNameOutputData.getSearchNameResult().getLocation());
        // make set search results be a turned to a String[]
        searchedNameState.setSearchResultsInteractive(searchNameOutputData.getSearchNameResult());


        searchedNameViewModel.setState(searchedNameState);

        searchedNameViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(searchedNameViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }

    /**  The method prepares the fail view on receiving the error message
     * @param error the error message
     * */
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