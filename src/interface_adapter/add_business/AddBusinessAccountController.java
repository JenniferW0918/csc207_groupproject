package interface_adapter.add_business;

import use_case.add_business.AddBusinessAccountInputBoundary;
import use_case.add_business.AddBusinessAccountInputData;


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
