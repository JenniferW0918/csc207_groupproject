package interface_adapter.add_user;
import use_case.add_user.AddUserInputBoundary;
import use_case.add_user.AddUserInputData;

/**
 * This is the controller class for initiating the Add User use case.
 * It takes a username, name and password, uses them to create the input data, and passes on the execution
 * of the use case to the interactor (AddUserInteractor).
 *
 * @author jenniferwang
 * @version 1.0
 */
public class AddUserController {

    /**
     * Constructs a new AddUserController with the specified use case interactor.
     *
     * @param addUserUseCaseInteractor the use case interactor for creating a User
     */
    final AddUserInputBoundary addUserUseCaseInteractor;
    public AddUserController(AddUserInputBoundary addUserUseCaseInteractor) {
        this.addUserUseCaseInteractor = addUserUseCaseInteractor;
    }

    /**
     * Executes the add user operation with the provided name, username and password.
     *
     * @param name the name of the User
     * @param username the username of the User
     * @param password the password of the User
     */
    public void execute(String name, String username, String password) {
        AddUserInputData addUserInputData = new AddUserInputData(name, username, password);
        addUserUseCaseInteractor.execute(addUserInputData);
    }
}

