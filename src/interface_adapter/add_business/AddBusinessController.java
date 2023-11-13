package interface_adapter.add_business;

import use_case.signup.add_business.AddBusinessInputBoundary;
import use_case.signup.add_business.AddBusinessInputData;

public class AddBusinessController {

    final AddBusinessInputBoundary userAddBusinessUseCaseInteractor;
    public AddBusinessController(AddBusinessInputBoundary userAddBusinessUseCaseInteractor) {
        this.userAddBusinessUseCaseInteractor = userAddBusinessUseCaseInteractor;
    }

    public void execute(String username, String password1, String password2) {
        AddBusinessInputData addBusinessInputData = new AddBusinessInputData(
                username, password1, password2);

        userAddBusinessUseCaseInteractor.execute(addBusinessInputData);
    }
}
