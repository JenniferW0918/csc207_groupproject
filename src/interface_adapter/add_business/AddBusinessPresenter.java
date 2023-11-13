package interface_adapter.signup;

import interface_adapter.ViewManagerModel;
import use_case.signup.add_business.AddBusinessOutputBoundary;
import use_case.signup.add_business.AddBusinessOutputData;
import interface_adapter.add_business.AddBusinessViewModel;

public class AddBusinessPresenter implements AddBusinessOutputBoundary {

    private final AddBusinessViewModel addBusinessViewModel;
    private ViewManagerModel viewManagerModel;

    public AddBusinessPresenter(ViewManagerModel viewManagerModel,
                                AddBusinessViewModel addBusinessViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.addBusinessViewModel = addBusinessViewModel;
    }

    @Override
    public void prepareSuccessView(AddBusinessOutputData response) {
        // this is if I decide to implement a login state/login view model
        // what do I want to show up when the user adds a business?

        // LoginState loginState = loginViewModel.getState();
        // loginState.setUsername(response.getUsername());
        // this.loginViewModel.setState(loginState);
        //loginViewModel.firePropertyChanged();

        // viewManagerModel.setActiveView(loginViewModel.getViewName());
        // viewManagerModel.firePropertyChanged();

        // for now:
        System.out.println("success! you have added a business.");
    }

    @Override
    public void prepareFailView(String error) {
        // same issue- havent implemented an add business state
        // AddBusinessState addBusinessState = addBusinessViewModel.getState();
        // addBusinessState.setUsernameError(error);
        // addBusinessViewModel.firePropertyChanged();
        System.out.println("wuh wuh... you have not added a business :(");
    }
}