package use_case.add_business;

import entity.User;
import entity.UserFactoryInterface;


import java.time.LocalDateTime;

public class AddBusinessAccountInteractor implements AddBusinessAccountInputBoundary {
    final AddBusinessAccountDataAccessInterface userDataAccessObject;
    final AddBusinessAccountOutputBoundary userPresenter;
    final UserFactoryInterface userFactoryInterface;

    public AddBusinessAccountInteractor(AddBusinessAccountDataAccessInterface addBusinessDataAccessInterface,
                                        AddBusinessAccountOutputBoundary addBusinessOutputBoundary,
                                        UserFactoryInterface userFactoryInterface) {
        this.userDataAccessObject = addBusinessDataAccessInterface;
        this.userPresenter = addBusinessOutputBoundary;
        this.userFactoryInterface = userFactoryInterface;
    }

    @Override
    public void execute(AddBusinessAccountInputData addBusinessAccountInputData) {
        if (userDataAccessObject.existsByName(addBusinessAccountInputData.getUsername())) {
            userPresenter.prepareFailView("User already exists.");
        } else {

            LocalDateTime now = LocalDateTime.now();
            User user = userFactoryInterface.create(addBusinessAccountInputData.getUsername(),
                    addBusinessAccountInputData.getPassword(), now);
            userDataAccessObject.save(user);

            AddBusinessAccountOutputData addBusinessAccountOutputData = new AddBusinessAccountOutputData(user.getName(),
                    false);
            userPresenter.prepareSuccessView(addBusinessAccountOutputData);
        }
    }
}
