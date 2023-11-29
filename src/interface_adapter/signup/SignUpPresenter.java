package interface_adapter.signup;

import interface_adapter.add_user.AddUserViewModel;
import interface_adapter.add_user.AddUserState;
import interface_adapter.add_business.AddBusinessAccountState;
import interface_adapter.add_business.AddBusinessAccountViewModel;
import interface_adapter.ViewManagerModel;
import use_case.signup.SignUpOutputBoundary;
import use_case.signup.SignUpOutputData;

public class SignUpPresenter implements SignUpOutputBoundary {

    private final AddUserViewModel addUserViewModel;
    private final AddBusinessAccountViewModel addBusinessAccountViewModel;
    private ViewManagerModel viewManagerModel;

    public SignUpPresenter(ViewManagerModel viewManagerModel,
                           AddUserViewModel addUserViewModel,
                           AddBusinessAccountViewModel addBusinessAccountViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.addUserViewModel = addUserViewModel;
        this.addBusinessAccountViewModel = addBusinessAccountViewModel;
    }

    @Override
    public void prepareSuccessUserView(SignUpOutputData response) {
        // On success, switch to the create user view.
        AddUserState addUserState = addUserViewModel.getState();
        this.addUserViewModel.setState(addUserState);
        addUserViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(addUserViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
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
