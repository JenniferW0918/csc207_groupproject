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

    final AddBusinessAccountInputBoundary userAddBusinessAccountUseCaseInteractor;
    public AddBusinessAccountController(AddBusinessAccountInputBoundary userAddBusinessUseCaseInteractor) {
        this.userAddBusinessAccountUseCaseInteractor = userAddBusinessUseCaseInteractor;
    }

    public void execute(String username, String name, String password, String address, String category) {
        AddBusinessAccountInputData addBusinessInputData = new AddBusinessAccountInputData(username, name, password,
                address, category);

        userAddBusinessAccountUseCaseInteractor.execute(addBusinessInputData);
    }
}
