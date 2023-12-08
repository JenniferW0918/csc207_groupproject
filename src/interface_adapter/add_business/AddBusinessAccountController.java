package interface_adapter.add_business;

import use_case.add_business.AddBusinessAccountInputBoundary;
import use_case.add_business.AddBusinessAccountInputData;

/**
 * The AddBusinessAccountController class serves as a controller for initiating the use case of adding a new business account.
 * It takes a username, name, password, address, and category as input parameters for a new business account, creates the corresponding input data,
 * and delegates the execution to the AddBusinessInteractor.
 *
 * @author audrey
 * @version 1.0
 */
public class AddBusinessAccountController {

    /**
     * The input boundary (use case interactor) for the AddBusinessAccount use case.
     */
    final AddBusinessAccountInputBoundary userAddBusinessAccountUseCaseInteractor;

    /**
     * Constructs an AddBusinessAccountController with the provided AddBusinessAccountInputBoundary.
     *
     * @param userAddBusinessUseCaseInteractor The input boundary (use case interactor) for the AddBusinessAccount use case.
     */
    public AddBusinessAccountController(AddBusinessAccountInputBoundary userAddBusinessUseCaseInteractor) {
        this.userAddBusinessAccountUseCaseInteractor = userAddBusinessUseCaseInteractor;
    }

    /**
     * Executes the AddBusinessAccount use case by creating an AddBusinessAccountInputData object from the provided parameters
     * and invoking the corresponding method on the input boundary.
     *
     * @param username The username for the new business account.
     * @param name The name of the new business.
     * @param password The password for the new business account.
     * @param address The address of the new business.
     * @param category The category or type of the new business.
     */
    public void execute(String username, String name, String password, String address, String category) {
        AddBusinessAccountInputData addBusinessInputData = new AddBusinessAccountInputData(username, name, password,
                address, category);

        userAddBusinessAccountUseCaseInteractor.execute(addBusinessInputData);
    }
}
