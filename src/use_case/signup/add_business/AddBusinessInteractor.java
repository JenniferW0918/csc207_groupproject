package use_case.signup.add_business;

import entity.User;
import entity.UserFactory;


import java.time.LocalDateTime;

public class AddBusinessInteractor implements AddBusinessInputBoundary {
    final AddBusinessUserDataAccessInterface userDataAccessObject;
    final AddBusinessOutputBoundary userPresenter;
    final UserFactory userFactory;

    public AddBusinessInteractor(AddBusinessUserDataAccessInterface addBusinessDataAccessInterface,
                                 AddBusinessOutputBoundary addBusinessOutputBoundary,
                                 UserFactory userFactory) {
        this.userDataAccessObject = addBusinessDataAccessInterface;
        this.userPresenter = addBusinessOutputBoundary;
        this.userFactory = userFactory;
    }

    @Override
    public void execute(AddBusinessInputData addBusinessInputData) {
        if (userDataAccessObject.existsByName(addBusinessInputData.getUsername())) {
            userPresenter.prepareFailView("User already exists.");
        } else if (!addBusinessInputData.getPassword().equals(addBusinessInputData.getRepeatPassword())) {
            userPresenter.prepareFailView("Passwords don't match.");
        } else {

            LocalDateTime now = LocalDateTime.now();
            User user = userFactory.create(addBusinessInputData.getUsername(), addBusinessInputData.getPassword(), now);
            userDataAccessObject.save(user);

            AddBusinessOutputData signupOutputData = new AddBusinessOutputData(user.getName(), now.toString(), false);
            userPresenter.prepareSuccessView(addBusinessOutputData);
        }
    }
}
