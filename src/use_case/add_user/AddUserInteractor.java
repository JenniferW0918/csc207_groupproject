package use_case.add_user;

import entity.BusinessAccount;
import entity.BusinessAccountFactoryInterface;
import entity.User;
import entity.UserFactoryInterface;
import data_access.Accounts;
import use_case.add_user.AddUserDataAccessInterface;
import use_case.add_user.AddUserOutputBoundary;
import use_case.add_user.AddUserOutputData;

public class AddUserInteractor implements AddUserInputBoundary {
    final AddUserDataAccessInterface addUserDataAccessObject;
    final AddUserOutputBoundary addUserPresenter;
    final UserFactoryInterface userFactoryInterface;

    public AddUserInteractor(AddUserDataAccessInterface addUserDataAccessInterface,
                                        AddUserOutputBoundary addUserOutputBoundary,
                                        UserFactoryInterface userFactoryInterface) {
        this.addUserDataAccessObject = addUserDataAccessInterface;
        this.addUserPresenter = addUserOutputBoundary;
        this.userFactoryInterface = userFactoryInterface;
    }

    @Override
    public void execute(AddUserInputData addUserInputData) {
        if (Accounts.getUsers().contains(addUserInputData.getUsername())) {
            addUserPresenter.prepareFailView("User already exists.");
        } else {

            User user = userFactoryInterface.create(
                    addUserInputData.getName(),
                    addUserInputData.getUsername(),
                    addUserInputData.getPassword());
            //Accounts.saveUser(user);

            AddUserOutputData addUserOutputData = new AddUserOutputData(
                    user.getName(), false);
            addUserPresenter.prepareSuccessView(addUserOutputData);
        }
    }
}