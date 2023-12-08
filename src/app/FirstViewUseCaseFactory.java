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

/**
 * The {@code FirstViewUseCaseFactory} class is responsible for creating instances related to the "First View" use case.
 * It provides a factory method to create the {@code FirstViewView} along with its associated controller and presenter.
 *
 * @author audrey
 * @version 1.0
 */
public class FirstViewUseCaseFactory { // testing commits
    private FirstViewUseCaseFactory() {}

    /**
     * Creates an instance of the {@code FirstViewView} along with its associated controller and presenter.
     *
     * @param viewManagerModel The model responsible for managing the active view.
     * @param firstViewViewModel The view model associated with the "First View" use case.
     * @param signInViewModel The view model associated with the sign-in functionality.
     * @param signUpViewModel The view model associated with the sign-up functionality.
     * @return The created {@code FirstViewView}.
     */
    public static FirstViewView createFirstView(
            ViewManagerModel viewManagerModel,
            FirstViewViewModel firstViewViewModel,
            SignInViewModel signInViewModel,
            SignUpViewModel signUpViewModel) {

        FirstViewController firstViewController = createFirstViewUseCase(viewManagerModel, signInViewModel, signUpViewModel);
        return new FirstViewView(firstViewController, firstViewViewModel, viewManagerModel);
    }

    /**
     * Creates an instance of the {@code FirstViewController} to handle the "First View" use case.
     *
     * @param viewManagerModel The model responsible for managing the active view.
     * @param signInViewModel The view model associated with the sign-in functionality.
     * @param signUpViewModel The view model associated with the sign-up functionality.
     * @return The created {@code FirstViewController}.
     */
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
