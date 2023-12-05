package use_case.add_user;

import entity.*;
import data_access.Accounts;
import use_case.add_user.AddUserDataAccessInterface;
import use_case.add_user.AddUserOutputBoundary;
import use_case.add_user.AddUserOutputData;

public class AddUserInteractor implements AddUserInputBoundary {
    final Accounts dataAccessObject;
    final AddUserOutputBoundary addUserPresenter;
    final UserFactoryInterface userFactoryInterface;

    public AddUserInteractor(Accounts dataAccessObject,
                                        AddUserOutputBoundary addUserOutputBoundary,
                                        UserFactoryInterface userFactoryInterface) {
        this.dataAccessObject = dataAccessObject;
        this.addUserPresenter = addUserOutputBoundary;
        this.userFactoryInterface = userFactoryInterface;
    }

    @Override
    public void execute(AddUserInputData addUserInputData) {
        if (dataAccessObject.userExistsByUsername(addUserInputData.getUsername())) {
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