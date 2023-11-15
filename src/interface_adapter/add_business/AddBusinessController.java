package interface_adapter.add_business;

import use_case.add_business.AddBusinessInputBoundary;
import use_case.add_business.AddBusinessInputData;
import java.util.Map;

public class AddBusinessController {

    final AddBusinessInputBoundary userAddBusinessUseCaseInteractor;
    public AddBusinessController(AddBusinessInputBoundary userAddBusinessUseCaseInteractor) {
        this.userAddBusinessUseCaseInteractor = userAddBusinessUseCaseInteractor;
    }

    public void execute(String username, String name, String password, String address, Map<String, String> hours) {
        AddBusinessInputData addBusinessInputData = new AddBusinessInputData(username, name, password, address, hours);

        userAddBusinessUseCaseInteractor.execute(addBusinessInputData);
    }
}
