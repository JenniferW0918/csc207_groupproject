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
import java.awt.*;

/**
 * This is the presenter class for the Sign Up (sign up account type selection) use case. It handles the output of
 * selecting an account type to sign up with and updates the relevant view models and view manager.
 *
 * This class implements the SignUpOutputBoundary interface to define methods that prepare views depending on the
 * output of the account type selection.
 *
 * @author jenniferwang
 * @version 1.0
 */
public class SignUpPresenter implements SignUpOutputBoundary {

    private final AddUserViewModel addUserViewModel;
    private final AddBusinessAccountViewModel addBusinessAccountViewModel;
    private ViewManagerModel viewManagerModel;
    private SignUpViewModel signupViewModel;
    private AddUserUseCaseFactory addUserUseCaseFactory;
    private SearchNameViewModel searchNameViewModel;
    private Accounts dataAccessObject;

    /**
     * Constructor for creating an instance of SignUpPresenter.
     *
     * @param viewManagerModel the model that manages views within the application
     * @param addUserViewModel the ViewModel for managing the user sign up view
     * @param addBusinessAccountViewModel the ViewModel for managing the business sign up view
     * @param dataAccessObject the data access object containing information on existing accounts
     */
    public SignUpPresenter(ViewManagerModel viewManagerModel,
                           AddUserViewModel addUserViewModel,
                           AddBusinessAccountViewModel addBusinessAccountViewModel,
                           Accounts dataAccessObject) {
        this.viewManagerModel = viewManagerModel;
        this.addUserViewModel = addUserViewModel;
        this.addBusinessAccountViewModel = addBusinessAccountViewModel;
        this.dataAccessObject = dataAccessObject;
    }

    /**
     * Switches from sign up (account type selection) view to user sign up view upon a successful user selection
     *
     * @param response the SignUpOutputData containing information about the successful user selection
     */
    @Override
    public void prepareSuccessUserView(SignUpOutputData response) {

        AddUserState addUserState = addUserViewModel.getState();
        addUserState.setAccountType(response.getAccountType());
        addUserViewModel.setState(addUserState);
        addUserViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(addUserViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Switches from sign up (account type selection) view to business account sign up view upon a successful business
     * account selection
     *
     * @param response the SignUpOutputData containing information about the successful business account selection
     */
    @Override
    public void prepareSuccessBusinessView(SignUpOutputData response) {

        AddBusinessAccountState addBusinessAccountState = addBusinessAccountViewModel.getState();
        addBusinessAccountState.setAccountType(response.getAccountType());
        addBusinessAccountViewModel.setState(addBusinessAccountState);
        addBusinessAccountViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(addBusinessAccountViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
