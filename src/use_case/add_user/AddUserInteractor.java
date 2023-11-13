package use_case.add_user;

import entity.User;
import entity.UserFactory;

import java.time.LocalDateTime;

public class AddUserInteractor implements AddUserInputBoundary {
    final AddUserDataAccessInterface addUserDataAccessObject;
    final AddUserOutputBoundary addUserPresenter;
    final UserFactory userFactory;

    public AddUserInteractor(AddUserDataAccessInterface addUserDataAccessInterface,
                             AddUserOutputBoundary addUserOutputBoundary,
                             UserFactory userFactory) {
        this.addUserDataAccessObject = addUserDataAccessInterface;
        this.addUserPresenter = addUserOutputBoundary;
        this.userFactory = userFactory;
    }

    @Override
    public void execute(AddUserInputData addUserInputData) {
        if (addUserDataAccessObject.existsByName(addUserInputData.getUsername())) {
            addUserPresenter.prepareFailView("User already exists.");
        } else {
            LocalDateTime now = LocalDateTime.now();
            User user = userFactory.create(addUserInputData.getUsername(), addUserInputData.getPassword(), now);
            addUserDataAccessObject.save(user);

            AddUserOutputData addUserOutputData = new AddUserOutputData(user.getName(), false);
            addUserPresenter.prepareSuccessView(addUserOutputData);
        }
    }
}