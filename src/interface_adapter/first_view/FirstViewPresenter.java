package interface_adapter.first_view;

import app.AddUserUseCaseFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.signin.SignInState;
import interface_adapter.signin.SignInViewModel;
import interface_adapter.signup.SignUpState;
import interface_adapter.signup.SignUpViewModel;
import use_case.first_view.FirstViewOutputBoundary;
import use_case.first_view.FirstViewOutputData;


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
