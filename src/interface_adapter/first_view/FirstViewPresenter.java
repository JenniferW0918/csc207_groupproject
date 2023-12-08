package interface_adapter.first_view;

import interface_adapter.ViewManagerModel;
import interface_adapter.signin.SignInState;
import interface_adapter.signin.SignInViewModel;
import interface_adapter.signup.SignUpState;
import interface_adapter.signup.SignUpViewModel;
import use_case.first_view.FirstViewOutputBoundary;
import use_case.first_view.FirstViewOutputData;

/**
 * The FirstViewPresenter class implements the FirstViewOutputBoundary for presenting the result of the first view use case.
 * It updates the associated view models and view manager based on the success or failure of the first view operation.
 * This presenter is responsible for preparing the success view by navigating to either the signin or signup view upon success.
 *
 * @author audrey
 * @version 1.0
 */
public class FirstViewPresenter implements FirstViewOutputBoundary {

    /**
     * The SignInViewModel instance associated with the sign-in feature.
     */
    private final SignInViewModel signInViewModel;

    /**
     * The SignUpViewModel instance associated with the sign-up feature.
     */
    private final SignUpViewModel signUpViewModel;

    /**
     * The ViewManagerModel instance responsible for managing views in the application.
     */
    private ViewManagerModel viewManagerModel;

    /**
     * Constructs a FirstViewPresenter with the provided ViewManagerModel, SignInViewModel, and SignUpViewModel.
     *
     * @param viewManagerModel The view manager responsible for managing views in the application.
     * @param signInViewModel  The view model for the sign-in feature.
     * @param signUpViewModel  The view model for the sign-up feature.
     */
    public FirstViewPresenter(ViewManagerModel viewManagerModel,
                               SignInViewModel signInViewModel,
                               SignUpViewModel signUpViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.signInViewModel = signInViewModel;
        this.signUpViewModel = signUpViewModel;
    }

    /**
     * Handles the presentation logic after a successful sign-in action. It updates the SignInViewModel
     * and notifies the view manager to switch to the sign-in view.
     *
     * @param response The output data from the FirstView use case for sign-in.
     */
    @Override
    public void prepareSuccessSignInView(FirstViewOutputData response) {
            // On success, switch to the create user view.
        SignInState signInState = signInViewModel.getState();
        signInViewModel.setState(signInState);
        signInViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(signInViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Handles the presentation logic after a successful sign-up action. It updates the SignUpViewModel
     * and notifies the view manager to switch to the sign-up view.
     *
     * @param response The output data from the FirstView use case for sign-up.
     */
    @Override
    public void prepareSuccessSignUpView(FirstViewOutputData response) {
        // on success, switch to add business account view
        SignUpState signUpState = signUpViewModel.getState();
        signUpViewModel.setState(signUpState);
        signUpViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(signUpViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
