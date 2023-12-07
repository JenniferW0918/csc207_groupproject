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
        // AddBusinessAccountState addBusinessAccountState = addBusinessAccountViewModel.getState();
        // addBusinessAccountState.setUsernameError(error);
        // addBusinessAccountViewModel.setState(addBusinessAccountState);
        // addBusinessAccountViewModel.firePropertyChanged();
        // JOptionPane.showMessageDialog(null, error);
        AddBusinessAccountState addBusinessAccountState = addBusinessAccountViewModel.getState();
        addBusinessAccountState.setUsernameError(error);
        addBusinessAccountViewModel.setState(addBusinessAccountState);
        addBusinessAccountViewModel.firePropertyChanged();
    }
}

