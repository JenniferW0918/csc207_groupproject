package use_case.add_business;

import entity.BusinessAccount;
import entity.BusinessAccountFactoryInterface;
import data_access.Accounts;

/**
 * The AddBusinessAccountInteractor class implements the logic for adding a new business account.
 * It acts as the use case's input boundary and interacts with the data access layer and presentation layer.
 * The interactor validates input data, checks for existing users, creates a new business account, and updates the presenter accordingly.
 *
 * @author audrey
 * @version 1.0
 */
public class AddBusinessAccountInteractor implements AddBusinessAccountInputBoundary {
    final Accounts dataAccessObject;
    final AddBusinessAccountOutputBoundary userPresenter;
    final BusinessAccountFactoryInterface businessAccountFactoryInterface;

    public AddBusinessAccountInteractor(Accounts dataAccessObject,
                                        AddBusinessAccountOutputBoundary addBusinessOutputBoundary,
                                        BusinessAccountFactoryInterface businessAccountFactoryInterface) {
        this.dataAccessObject = dataAccessObject;
        this.userPresenter = addBusinessOutputBoundary;
        this.businessAccountFactoryInterface = businessAccountFactoryInterface;
    }

    @Override
    public void execute(AddBusinessAccountInputData addBusinessAccountInputData) {
        // Check for empty values
        if (isEmpty(addBusinessAccountInputData.getUsername())
                || isEmpty(addBusinessAccountInputData.getName())
                || isEmpty(addBusinessAccountInputData.getPassword())
                || isEmpty(addBusinessAccountInputData.getAddress())
                || isEmpty(addBusinessAccountInputData.getCategory())) {
            userPresenter.prepareFailView("Please fill out all fields.");
            System.out.println("Please fill out all fields.");
        } else if (dataAccessObject.businessExistsByUsername(addBusinessAccountInputData.getUsername())
                || dataAccessObject.userExistsByUsername(addBusinessAccountInputData.getUsername())) {
            userPresenter.prepareFailView("User already exists.");
        } else {
            BusinessAccount businessAccount = businessAccountFactoryInterface.create(
                    addBusinessAccountInputData.getUsername(),
                    addBusinessAccountInputData.getName(),
                    addBusinessAccountInputData.getPassword(),
                    addBusinessAccountInputData.getAddress(),
                    addBusinessAccountInputData.getCategory());
            dataAccessObject.saveBusiness(businessAccount);

            AddBusinessAccountOutputData addBusinessAccountOutputData = new AddBusinessAccountOutputData(
                    businessAccount.getName(), false);
            userPresenter.prepareSuccessView(addBusinessAccountOutputData);
        }
    }

    // Helper method to check if a string is empty
    private boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
