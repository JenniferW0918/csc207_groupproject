package interface_adapter.add_business;

import interface_adapter.ViewManagerModel;
import interface_adapter.search_name.SearchNameState;
import interface_adapter.search_name.SearchNameViewModel;
import use_case.add_business.AddBusinessAccountOutputBoundary;
import use_case.add_business.AddBusinessAccountOutputData;

import javax.swing.*;

public class AddBusinessAccountPresenter implements AddBusinessAccountOutputBoundary {

    private final AddBusinessAccountViewModel addBusinessAccountViewModel;
    private final SearchNameViewModel searchNameViewModel;
    private ViewManagerModel viewManagerModel;

    public AddBusinessAccountPresenter(ViewManagerModel viewManagerModel,
                                       AddBusinessAccountViewModel addBusinessViewModel,
                                       SearchNameViewModel searchNameViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.addBusinessAccountViewModel = addBusinessViewModel;
        this.searchNameViewModel = searchNameViewModel;
    }

    @Override
    public void prepareSuccessView(AddBusinessAccountOutputData response) {
        SearchNameState searchNameState = searchNameViewModel.getState();
        this.searchNameViewModel.setState(searchNameState);
        searchNameViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(searchNameViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

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

    // Helper method to extract specific error messages for each missing field
    private String extractErrorMessage(String error, String fieldName) {
        String prefix = "Please enter a ";
        if (error.startsWith(prefix + fieldName)) {
            return error.substring(prefix.length() + fieldName.length()) + ".";
        }
        return null;
    }
}

