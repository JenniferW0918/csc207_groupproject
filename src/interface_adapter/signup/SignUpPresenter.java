package interface_adapter.signup;

import app.AddUserUseCaseFactory;
import app.SignUpUseCaseFactory;
import data_access.Accounts;
import interface_adapter.add_user.AddUserViewModel;
import interface_adapter.add_user.AddUserState;
import interface_adapter.add_business.AddBusinessAccountState;
import interface_adapter.add_business.AddBusinessAccountViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.search_name.SearchNameViewModel;
import use_case.signup.SignUpOutputBoundary;
import use_case.signup.SignUpOutputData;
import view.AddUserView;
import view.SignUpView;

import javax.swing.*;

public class SignUpPresenter implements SignUpOutputBoundary {

    private final AddUserViewModel addUserViewModel;
    private final AddBusinessAccountViewModel addBusinessAccountViewModel;
    private ViewManagerModel viewManagerModel;
    private AddUserUseCaseFactory addUserUseCaseFactory;
    private SearchNameViewModel searchNameViewModel;
    private Accounts dataAccessObject;

    public SignUpPresenter(ViewManagerModel viewManagerModel,
                           AddUserViewModel addUserViewModel,
                           AddBusinessAccountViewModel addBusinessAccountViewModel,
                           Accounts dataAccessObject) {
        this.viewManagerModel = viewManagerModel;
        this.addUserViewModel = addUserViewModel;
        this.addBusinessAccountViewModel = addBusinessAccountViewModel;
        this.dataAccessObject = dataAccessObject;
    }

    @Override
    public void prepareSuccessUserView(SignUpOutputData response) {
        // On success, switch to the create user view.
        AddUserView addUserView = addUserUseCaseFactory.createUserView(viewManagerModel, searchNameViewModel, addUserViewModel, dataAccessObject);
        viewManagerModel.setActiveView(addUserView.viewName);
        viewManagerModel.firePropertyChanged();

        JFrame frame = new JFrame("Create User");
        frame.setSize(400, 300);
    }

    @Override
    public void prepareSuccessBusinessView(SignUpOutputData response) {
        AddBusinessAccountState addBusinessAccountState = addBusinessAccountViewModel.getState();
        this.addBusinessAccountViewModel.setState(addBusinessAccountState);
        addBusinessAccountViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(addBusinessAccountViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
