package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.search_name.*;
import use_case.search_name.*;
import data_access.SearchNameDataAccessObject;
import view.SearchNameView;


public class SearchNameUseCaseFactory {
    private SearchNameUseCaseFactory() {
    }
    public static SearchNameView createSearchNameView(ViewManagerModel viewManagerModel,
                                           SearchNameViewModel searchNameViewModel,
                                           SearchNameDataAccessObject searchNameDataAccessObject) {

        try {
            SearchNamePresenter searchNamePresenter = new SearchNamePresenter(searchNameViewModel, viewManagerModel);
            SearchNameInputBoundary searchNameInteractor = new SearchNameInteractor(searchNameDataAccessObject, searchNamePresenter);
            SearchNameController searchNameController = new SearchNameController(searchNameInteractor);
            return new SearchNameView(searchNameController, searchNameViewModel, viewManagerModel);

        } catch (Exception e) {
            System.out.println("Error creating search name use case: " + e.getMessage());
            return null;
        }
    }
}

