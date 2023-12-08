package use_case.add_user;

import entity.*;
import data_access.Accounts;
import use_case.add_user.AddUserDataAccessInterface;
import use_case.add_user.AddUserOutputBoundary;
import use_case.add_user.AddUserOutputData;

/**
 * The AddUserInteractor class implements the logic for the Add User use case.
 * It implements AddUserInputBoundary to act as the input boundary for the use case and interact with the data access
 * and presentation layer.
 *
 * @author jenniferwang
 * @version 1.0
 */
public class AddUserInteractor implements AddUserInputBoundary {
    final Accounts dataAccessObject;
    final AddUserOutputBoundary addUserPresenter;
    final UserFactoryInterface userFactoryInterface;

    /**
     * Constructor for creating an instance of AddUserInteractor with the given dependencies.
     *
     * @param dataAccessObject the data access object that stores existing user and business accounts
     * @param addUserOutputBoundary the output boundary for passing the response to the presenter
     * @param userFactoryInterface the factory interface for creating User objects
     */
    public AddUserInteractor(Accounts dataAccessObject,
                                        AddUserOutputBoundary addUserOutputBoundary,
                                        UserFactoryInterface userFactoryInterface) {
        this.dataAccessObject = dataAccessObject;
        this.addUserPresenter = addUserOutputBoundary;
        this.userFactoryInterface = userFactoryInterface;
    }

    /**
     * Executes the Add User use case based on the given input data.
     *
     * @param addUserInputData the input data needed to execute the Add User use case
     */
    @Override
    public void execute(AddUserInputData addUserInputData) {
        if (dataAccessObject.userExistsByUsername(addUserInputData.getUsername())||dataAccessObject.businessExistsByUsername(addUserInputData.getUsername())) {
            addUserPresenter.prepareFailView("User already exists.");
        } else {

            User user = userFactoryInterface.create(
                    addUserInputData.getName(),
                    addUserInputData.getUsername(),
                    addUserInputData.getPassword());
            dataAccessObject.saveUser(user);

            AddUserOutputData addUserOutputData = new AddUserOutputData(
                    user.getName(), false);
            addUserPresenter.prepareSuccessView(addUserOutputData);
        }
    }
}