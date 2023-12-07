package interface_adapter.first_view;

import use_case.first_view.FirstViewInputBoundary;
import use_case.first_view.FirstViewInputData;


public class FirstViewController { // testing commits
    final FirstViewInputBoundary firstViewUseCaseInteractor;
    public FirstViewController(FirstViewInputBoundary firstViewUseCaseInteractor) {
        this.firstViewUseCaseInteractor = firstViewUseCaseInteractor;
    }

    public void execute(String signinOrSignup) {
        FirstViewInputData firstViewInputData = new FirstViewInputData(signinOrSignup);

        firstViewUseCaseInteractor.execute(firstViewInputData);
    }
}
