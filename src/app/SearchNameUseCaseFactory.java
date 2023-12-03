package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.search_name.*;
import use_case.search_name.*;
import interface_adapter.seached_name.SearchedNameViewModel;
import data_access.SearchNameDataAccessObject;
import view.SearchNameView;


public class SearchNameUseCaseFactory {
    private SearchNameUseCaseFactory() {
    }
    public static SearchNameView createSearchNameView(ViewManagerModel viewManagerModel,
                                           SearchNameViewModel searchNameViewModel,
                                           SearchNameDataAccessObject searchNameDataAccessObject,
                                                      SearchedNameViewModel searchedNameViewModel) {

            SearchNamePresenter searchNamePresenter = new SearchNamePresenter(searchNameViewModel, viewManagerModel, searchedNameViewModel);
            SearchNameInputBoundary searchNameInteractor = new SearchNameInteractor(searchNameDataAccessObject, searchNamePresenter);
            SearchNameController searchNameController = new SearchNameController(searchNameInteractor);
            return new SearchNameView(searchNameController, searchNameViewModel);
    }
}

