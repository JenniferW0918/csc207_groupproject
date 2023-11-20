package interface_adapter.add_user;
import use_case.add_user.AddUserInputBoundary;
import use_case.add_user.AddUserInputData;

public class AddUserController {

    final AddUserInputBoundary addUserUseCaseInteractor;
    public AddUserController(AddUserInputBoundary addUserUseCaseInteractor) {
        this.addUserUseCaseInteractor = addUserUseCaseInteractor;
    }

    public void execute(String name, String username, String password) {
        AddUserInputData addUserInputData = new AddUserInputData(name, username, password);
        addUserUseCaseInteractor.execute(addUserInputData);
    }
}

