package app;


import interface_adapter.ViewManagerModel;
import interface_adapter.first_view.FirstViewController;
import interface_adapter.first_view.FirstViewPresenter;
import interface_adapter.first_view.FirstViewViewModel;
import interface_adapter.signin.SignInViewModel;
import interface_adapter.signup.SignUpViewModel;
import use_case.first_view.FirstViewInputBoundary;
import use_case.first_view.FirstViewInteractor;
import use_case.first_view.FirstViewOutputBoundary;
import view.FirstViewView;

public class FirstViewUseCaseFactory {
    private FirstViewUseCaseFactory() {}

    public static FirstViewView createFirstView(
            ViewManagerModel viewManagerModel,
            FirstViewViewModel firstViewViewModel,
            SignInViewModel signInViewModel,
            SignUpViewModel signUpViewModel) {

        FirstViewController firstViewController = createFirstViewUseCase(viewManagerModel, signInViewModel, signUpViewModel);
        return new FirstViewView(firstViewController, firstViewViewModel, viewManagerModel);
    }

    private static FirstViewController createFirstViewUseCase(ViewManagerModel viewManagerModel,
                                                        SignInViewModel signInViewModel,
                                                        SignUpViewModel signUpViewModel) {

        // Notice how we pass this method's parameters to the Presenter.
        FirstViewOutputBoundary firstViewOutputBoundary = new FirstViewPresenter(viewManagerModel, signInViewModel, signUpViewModel);

        FirstViewInputBoundary firstViewInteractor = new FirstViewInteractor(
                firstViewOutputBoundary);

        return new FirstViewController(firstViewInteractor);
    }
}
