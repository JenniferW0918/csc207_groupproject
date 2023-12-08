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

    /**
     * The FirstViewInputBoundary instance responsible for executing the use case related to FirstView.
     */
    final FirstViewInputBoundary firstViewUseCaseInteractor;

    /**
     * Constructs a FirstViewController with the provided FirstViewInputBoundary.
     *
     * @param firstViewUseCaseInteractor The input boundary for the FirstView use case.
     */
    public FirstViewController(FirstViewInputBoundary firstViewUseCaseInteractor) {
        this.firstViewUseCaseInteractor = firstViewUseCaseInteractor;
    }

    /**
     * Executes the user's action based on the provided choice (signin or signup).
     * It creates a FirstViewInputData object with the given choice and delegates the execution
     * to the FirstView use case interactor.
     *
     * @param signinOrSignup The user's choice between signing in or signing up.
     */
    public void execute(String signinOrSignup) {
        FirstViewInputData firstViewInputData = new FirstViewInputData(signinOrSignup);

        firstViewUseCaseInteractor.execute(firstViewInputData);
    }
}
