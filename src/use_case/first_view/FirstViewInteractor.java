package use_case.first_view;

/**
 * The FirstViewInteractor class implements the logic for selecting between signing in or signing up.
 * It acts as the use case's input boundary and interacts with the data access layer and presentation layer.
 * The interactor validates input data and updates the presenter accordingly.
 *
 * @author audrey
 * @version 1.0
 */
public class FirstViewInteractor implements FirstViewInputBoundary { // testing commits
    final FirstViewOutputBoundary present;

    public FirstViewInteractor(FirstViewOutputBoundary firstViewOutputBoundary) {
        this.present = firstViewOutputBoundary;
    }

    @Override
    public void execute(FirstViewInputData firstViewInputData) {
        if (firstViewInputData.getSigninOrSignup() == "signin") {
            present.prepareSuccessSignInView(new FirstViewOutputData("signin"));
        } else {
            present.prepareSuccessSignUpView(new FirstViewOutputData("sign up"));
        }
    }
}