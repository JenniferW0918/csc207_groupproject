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
public class FirstViewPresenter implements FirstViewOutputBoundary { // testing commits
        private final SignInViewModel signInViewModel;
        private final SignUpViewModel signUpViewModel;
        private ViewManagerModel viewManagerModel;

        public FirstViewPresenter(ViewManagerModel viewManagerModel,
                               SignInViewModel signInViewModel,
                               SignUpViewModel signUpViewModel) {
            this.viewManagerModel = viewManagerModel;
            this.signInViewModel = signInViewModel;
            this.signUpViewModel = signUpViewModel;
        }

        @Override
        public void prepareSuccessSignInView(FirstViewOutputData response) {
            // On success, switch to the create user view.
            SignInState signInState = signInViewModel.getState();
            signInViewModel.setState(signInState);
            signInViewModel.firePropertyChanged();

            viewManagerModel.setActiveView(signInViewModel.getViewName());
            viewManagerModel.firePropertyChanged();
        }

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
