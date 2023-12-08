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

    /**
     * The output boundary for presenting success views related to sign-in or sign-up.
     */
    final FirstViewOutputBoundary present;

    /**
     * Constructs a new FirstViewInteractor with the specified output boundary.
     *
     * @param firstViewOutputBoundary The output boundary for presenting success views.
     */
    public FirstViewInteractor(FirstViewOutputBoundary firstViewOutputBoundary) {
        this.present = firstViewOutputBoundary;
    }

    /**
     * Executes the First View use case based on the provided FirstViewInputData.
     * Processes the input data to determine whether the user intends to sign in or sign up,
     * and triggers the appropriate actions via the output boundary.
     *
     * @param firstViewInputData The input data for the First View use case.
     */
    @Override
    public void execute(FirstViewInputData firstViewInputData) {
        if (firstViewInputData.getSigninOrSignup() == "signin") {
            present.prepareSuccessSignInView(new FirstViewOutputData("signin"));
        } else {
            present.prepareSuccessSignUpView(new FirstViewOutputData("sign up"));
        }
    }
}