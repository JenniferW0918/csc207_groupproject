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
    /**
     * The data access object responsible for managing business account data.
     */
    final Accounts dataAccessObject;

    /**
     * The output boundary for presenting results and errors related to the Add Business Account use case.
     */
    final AddBusinessAccountOutputBoundary userPresenter;

    /**
     * The factory interface for creating business account instances.
     */
    final BusinessAccountFactoryInterface businessAccountFactoryInterface;

    /**
     * Constructs a new AddBusinessAccountInteractor with the specified dependencies.
     *
     * @param dataAccessObject The data access object for managing business account data.
     * @param addBusinessOutputBoundary The output boundary for presenting results and errors.
     * @param businessAccountFactoryInterface The factory interface for creating business account instances.
     */
    public AddBusinessAccountInteractor(Accounts dataAccessObject,
                                        AddBusinessAccountOutputBoundary addBusinessOutputBoundary,
                                        BusinessAccountFactoryInterface businessAccountFactoryInterface) {
        this.dataAccessObject = dataAccessObject;
        this.userPresenter = addBusinessOutputBoundary;
        this.businessAccountFactoryInterface = businessAccountFactoryInterface;
    }

    /**
     * Executes the Add Business Account use case based on the provided input data.
     *
     * @param addBusinessAccountInputData The input data for adding a new business account.
     */
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

    /**
     * Helper method to check if a string is empty.
     *
     * @param value The string to check for emptiness.
     * @return True if the string is empty or null; otherwise, false.
     */
    private boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
