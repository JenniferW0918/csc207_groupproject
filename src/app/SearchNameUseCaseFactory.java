package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.search_name.*;
import use_case.search_name.*;
import interface_adapter.seached_name.SearchedNameViewModel;
import data_access.SearchNameDataAccessObject;
import view.SearchNameView;

/**
 * The SearchNameUseCaseFactory class is responsible for creating the search name use case.
 */
public class SearchNameUseCaseFactory {
    private SearchNameUseCaseFactory() {
    }
    /**
 * This method creates and returns a SearchNameView object.
 * @param viewManagerModel The ViewManagerModel object that manages the views.
 * @param searchNameViewModel The SearchNameViewModel object that updates the SearchNameView.
 * @param searchNameDataAccessObject The SearchNameDataAccessObject object that interacts with the Yelp API.
 * @param searchedNameViewModel The SearchedNameViewModel object that holds the data for the SearchedNameView.
 * @return A new SearchNameView.
 */
    public static SearchNameView createSearchNameView(ViewManagerModel viewManagerModel,
                                           SearchNameViewModel searchNameViewModel,
                                           SearchNameDataAccessObject searchNameDataAccessObject,
                                                      SearchedNameViewModel searchedNameViewModel) {

            SearchNamePresenter searchNamePresenter = new SearchNamePresenter(searchNameViewModel, viewManagerModel, searchedNameViewModel);
            SearchNameInputBoundary searchNameInteractor = new SearchNameInteractor(searchNameDataAccessObject, searchNamePresenter);
            SearchNameController searchNameController = new SearchNameController(searchNameInteractor);
            return new SearchNameView(searchNameController, searchNameViewModel, viewManagerModel);
    }
}

