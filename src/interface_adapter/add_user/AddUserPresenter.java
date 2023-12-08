package interface_adapter.add_user;

import interface_adapter.search_name.SearchNameViewModel;
import use_case.add_user.AddUserOutputBoundary;
import use_case.add_user.AddUserOutputData;
import interface_adapter.ViewManagerModel;
import interface_adapter.search_name.SearchNameState;
import interface_adapter.search_name.SearchNameViewModel;

import javax.swing.*;

/**
 * This is the presenter class for the Add User use case. It handles the output of the use case and updates the
 * relevant view models and view manager.
 *
 * This class implements the AddUserOutputBoundary interface to define methods that prepare views depending on the
 * success or failure of the add user operation. It is responsible for coordinating interactions between the Add User
 * use case, the AddUserViewModel, the SearchNameViewModel, and the ViewManagerModel.
 *
 * @author jenniferwang
 * @version 1.0
 */
public class AddUserPresenter implements AddUserOutputBoundary {

    private final AddUserViewModel addUserViewModel;
    private final SearchNameViewModel searchNameViewModel;
    private ViewManagerModel viewManagerModel;

    /**
     * Constructs an AddUserPresenter with the given instances of ViewManagerModel, AddUserViewModel and
     * SearchNameViewModel.
     *
     * @param viewManagerModel the model that manages the active view of the application
     * @param addUserViewModel the view model for the user sign up view
     * @param searchNameViewModel the view model for the search view
     */
    public AddUserPresenter(ViewManagerModel viewManagerModel,
                            AddUserViewModel addUserViewModel,
                            SearchNameViewModel searchNameViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.addUserViewModel = addUserViewModel;
        this.searchNameViewModel = searchNameViewModel;
    }

    /**
     * Prepares the view and updates the necessary components when the add user operation is successful.
     * Switches from the user sign up view to the search view and updates the view model accordingly.
     *
     * @param response the output data from the add user operation
     */
    @Override
    public void prepareSuccessView(AddUserOutputData response) {

        SearchNameState searchNameState = searchNameViewModel.getState();
        this.searchNameViewModel.setState(searchNameState);
        searchNameViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(searchNameViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares the view and updates the necessary components when the add user operation fails.
     * Displays the pop-up dialog containing the error message, updates the error message and state change in
     * the view model.
     *
     * @param error the error message containing the reason why the add user operation failed
     */
    @Override
    public void prepareFailView(String error) {
        AddUserState addUserState = addUserViewModel.getState();
        addUserState.setUsernameError(error);
        addUserViewModel.setState(addUserState);
        addUserViewModel.firePropertyChanged();
        JOptionPane.showMessageDialog(null, error);
    }
}

