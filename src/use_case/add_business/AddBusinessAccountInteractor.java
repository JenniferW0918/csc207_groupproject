package use_case.add_business;

import entity.User;
import entity.UserFactory;
import use_case.add_business.AddBusinessAccountDataAccessInterface;
import use_case.add_business.AddBusinessAccountInputBoundary;
import use_case.add_business.AddBusinessAccountOutputBoundary;
import use_case.add_business.AddBusinessAccountInputData;
import use_case.add_business.AddBusinessAccountOutputData;


import java.time.LocalDateTime;

public class AddBusinessAccountInteractor implements AddBusinessAccountInputBoundary {
    final AddBusinessAccountDataAccessInterface userDataAccessObject;
    final AddBusinessAccountOutputBoundary userPresenter;
    final UserFactory userFactory;

    public AddBusinessAccountInteractor(AddBusinessAccountDataAccessInterface addBusinessDataAccessInterface,
                                        AddBusinessAccountOutputBoundary addBusinessOutputBoundary,
                                        UserFactory userFactory) {
        this.userDataAccessObject = addBusinessDataAccessInterface;
        this.userPresenter = addBusinessOutputBoundary;
        this.userFactory = userFactory;
    }

    @Override
    public void execute(AddBusinessAccountInputData addBusinessAccountInputData) {
        if (userDataAccessObject.existsByName(addBusinessAccountInputData.getUsername())) {
            userPresenter.prepareFailView("User already exists.");
        } else {

            LocalDateTime now = LocalDateTime.now();
            User user = userFactory.create(addBusinessAccountInputData.getUsername(),
                    addBusinessAccountInputData.getPassword(), now);
            userDataAccessObject.save(user);

            AddBusinessAccountOutputData addBusinessAccountOutputData = new AddBusinessAccountOutputData(user.getName(),
                    false);
            userPresenter.prepareSuccessView(addBusinessAccountOutputData);
        }
    }
}
