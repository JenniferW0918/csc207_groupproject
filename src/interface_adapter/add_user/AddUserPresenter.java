package interface_adapter.add_user;

import interface_adapter.search_name.SearchNameViewModel;
import use_case.add_user.AddUserOutputBoundary;
import use_case.add_user.AddUserOutputData;
import interface_adapter.ViewManagerModel;
import interface_adapter.search_name.SearchNameState;
import interface_adapter.search_name.SearchNameViewModel;

public class AddUserPresenter implements AddUserOutputBoundary {

    private final AddUserViewModel addUserViewModel;
    private final SearchNameViewModel searchNameViewModel;
    private ViewManagerModel viewManagerModel;

    public AddUserPresenter(ViewManagerModel viewManagerModel,
                            AddUserViewModel addUserViewModel,
                            SearchNameViewModel searchNameViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.addUserViewModel = addUserViewModel;
        this.searchNameViewModel = searchNameViewModel;
    }

    @Override
    public void prepareSuccessView(AddUserOutputData response) {
        // On success, switch to the search view.

        SearchNameState searchNameState = searchNameViewModel.getState();
        this.searchNameViewModel.setState(searchNameState);
        searchNameViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(searchNameViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        AddUserState addUserState = addUserViewModel.getState();
        addUserState.setUsernameError(error);
        addUserViewModel.firePropertyChanged();
    }
}

