package interface_adapter;

import use_case.signup.AddBusinessInputBoundary;
import use_case.signup.AddBusinessInputData;

public class AddUserController {

    final AddUserInputBoundary addUserUseCaseInteractor;
    public AddUserController(AddUserInputBoundary addUserUseCaseInteractor) {
        this.addUserUseCaseInteractor = addUserUseCaseInteractor;
    }

    public void execute(String name, String username, String email, String password1, String location) {
        AddUserInputData addUserInputData = new AddUserInputData(name, username, email, password1, location);
        addUserUseCaseInteractor.execute(addUserInputData);
    }
}
