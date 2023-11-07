package interface_adapter.AddBusiness;

import use_case.signup.AddBusinessInputBoundary;
import use_case.signup.AddBusinessInputData;

public class AddBusinessController {

    final AddBusinessInputBoundary userAddBusinessUseCaseInteractor;
    public AddBusinessController(AddBusinessInputBoundary userSignupUseCaseInteractor) {
        this.userAddBusinessUseCaseInteractor = userSignupUseCaseInteractor;
    }

    public void execute(String username, String password1, String password2) {
        AddBusinessInputData addBusinessInputData = new AddBusinessInputData(
                username, password1, password2);

        userAddBusinessUseCaseInteractor.execute(addBusinessInputData);
    }
}
