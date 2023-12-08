package interface_adapter.add_business;

import interface_adapter.ViewManagerModel;
import interface_adapter.search_name.SearchNameState;
import interface_adapter.search_name.SearchNameViewModel;
import use_case.add_business.AddBusinessAccountOutputBoundary;
import use_case.add_business.AddBusinessAccountOutputData;

import javax.swing.*;

/**
 * The AddBusinessAccountPresenter class implements the AddBusinessAccountOutputBoundary for presenting the result of the add business use case.
 * It updates the associated view models and view manager based on the success or failure of the add business account operation.
 * This presenter is responsible for preparing the success view by navigating to the search name view upon success,
 * and preparing the fail view by updating the add business account view with specific error messages and displaying a message dialog.
 *
 * @author audrey
 * @version 1.0
 */
public class AddBusinessAccountPresenter implements AddBusinessAccountOutputBoundary {

    /**
     * The view model for the AddBusinessAccount feature, containing the state and data to be presented in the user interface.
     */
    private final AddBusinessAccountViewModel addBusinessAccountViewModel;

    /**
     * The view model for the search name feature, which may be affected by the outcome of the AddBusinessAccount operation.
     */
    private final SearchNameViewModel searchNameViewModel;

    /**
     * The model representing the state of the view manager, which controls the active view in the application.
     */
    private ViewManagerModel viewManagerModel;

    /**
     * Constructs an AddBusinessAccountPresenter with the specified view manager model and view models for AddBusinessAccount
     * and search name features.
     *
     * @param viewManagerModel The model representing the state of the view manager.
     * @param addBusinessViewModel The view model for the AddBusinessAccount feature.
     * @param searchNameViewModel The view model for the search name feature.
     */
    public AddBusinessAccountPresenter(ViewManagerModel viewManagerModel,
                                       AddBusinessAccountViewModel addBusinessViewModel,
                                       SearchNameViewModel searchNameViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.addBusinessAccountViewModel = addBusinessViewModel;
        this.searchNameViewModel = searchNameViewModel;
    }

    /**
     * Handles the preparation of the success view after a successful AddBusinessAccount operation. This may involve updating
     * the state of related view models and triggering a view change.
     *
     * @param response The output data containing relevant information from the AddBusinessAccount operation.
     */
    @Override
    public void prepareSuccessView(AddBusinessAccountOutputData response) {
        SearchNameState searchNameState = searchNameViewModel.getState();
        this.searchNameViewModel.setState(searchNameState);
        searchNameViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(searchNameViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Handles the preparation of the fail view after a failed AddBusinessAccount operation. This involves extracting specific
     * error messages for each missing field, updating the state of the AddBusinessAccount view model, and displaying an error
     * message to the user through a JOptionPane.
     *
     * @param error The error message describing the cause of the failure.
     */
    @Override
    public void prepareFailView(String error) {
        AddBusinessAccountState addBusinessAccountState = addBusinessAccountViewModel.getState();

        // Extract specific error messages for each missing field
        String usernameError = extractErrorMessage(error, "username");
        String nameError = extractErrorMessage(error, "name");
        String passwordError = extractErrorMessage(error, "password");
        String addressError = extractErrorMessage(error, "address");
        String categoryError = extractErrorMessage(error, "category");

        addBusinessAccountState.setUsernameError(usernameError);
        addBusinessAccountState.setNameError(nameError);
        addBusinessAccountState.setPasswordError(passwordError);
        addBusinessAccountState.setAddressError(addressError);
        addBusinessAccountState.setCategoryError(categoryError);

        addBusinessAccountViewModel.setState(addBusinessAccountState);
        addBusinessAccountViewModel.firePropertyChanged();

        JOptionPane.showMessageDialog(null, error);
    }

    /**
     * Helper method to extract specific error messages for each missing field based on a given prefix.
     *
     * @param error The error message containing specific field-related information.
     * @param fieldName The name of the field for which the error message is extracted.
     * @return The specific error message related to the specified field, or null if not found.
     */
    private String extractErrorMessage(String error, String fieldName) {
        String prefix = "Please enter a ";
        if (error.startsWith(prefix + fieldName)) {
            return error.substring(prefix.length() + fieldName.length()) + ".";
        }
        return null;
    }
}

