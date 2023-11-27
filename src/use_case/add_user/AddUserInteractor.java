package use_case.add_user;

import entity.User;
import entity.UserFactoryInterface;
import data_access.Accounts;

public class AddUserInteractor implements AddUserInputBoundary {
    final AddUserOutputBoundary addUserPresenter;
    final UserFactoryInterface userFactoryInterface;

    public AddUserInteractor(AddUserOutputBoundary addUserOutputBoundary,
                             UserFactoryInterface userFactoryInterface) {
        this.addUserPresenter = addUserOutputBoundary;
        this.userFactoryInterface = userFactoryInterface;
    }

    @Override
    public void execute(AddUserInputData addUserInputData) {
        if (Accounts.getUsers().contains(addUserInputData.getUsername())) {
            addUserPresenter.prepareFailView("User already exists.");
        } else {
            User user = userFactoryInterface.create(addUserInputData.getName(), addUserInputData.getUsername(), addUserInputData.getPassword());
            Accounts.saveUser(user);

            AddUserOutputData addUserOutputData = new AddUserOutputData(user.getName(), false);
            addUserPresenter.prepareSuccessView(addUserOutputData);
        }
    }
}