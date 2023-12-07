package interface_adapter.first_view;

import use_case.first_view.FirstViewInputBoundary;
import use_case.first_view.FirstViewInputData;

/**
 * The FirstViewController class serves as a controller for initiating the use case of choosing between signing in or signing up.
 * It takes the input parameters provided by either the signin or signup buttons, creates the corresponding input data,
 * and delegates the execution to the FirstViewInteractor.
 *
 * @author audrey
 * @version 1.0
 */
public class FirstViewController {
    final FirstViewInputBoundary firstViewUseCaseInteractor;
    public FirstViewController(FirstViewInputBoundary firstViewUseCaseInteractor) {
        this.firstViewUseCaseInteractor = firstViewUseCaseInteractor;
    }

    public void execute(String signinOrSignup) {
        FirstViewInputData firstViewInputData = new FirstViewInputData(signinOrSignup);

        firstViewUseCaseInteractor.execute(firstViewInputData);
    }
}
