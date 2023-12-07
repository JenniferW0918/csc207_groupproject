package use_case.add_business;

import entity.BusinessAccount;
import entity.BusinessAccountFactoryInterface;
import data_access.Accounts;

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
        // need to iterate through accounts.getBusinessAccount bc it returns an array list of BusinessAccounts
        // so if addBusinessInputData.getUsername() == one of the usernames in array list, "user already exists"
        if (dataAccessObject.businessExistsByUsername(addBusinessAccountInputData.getUsername())||dataAccessObject.userExistsByUsername(addBusinessAccountInputData.getUsername())) {
            userPresenter.prepareFailView("User already exists.");
        } else {

            BusinessAccount businessAccount = businessAccountFactoryInterface.create(
                    addBusinessAccountInputData.getUsername(),
                    addBusinessAccountInputData.getName(),
                    addBusinessAccountInputData.getPassword(),
                    addBusinessAccountInputData.getAddress(),
                    addBusinessAccountInputData.getCategories());
            dataAccessObject.saveBusiness(businessAccount);

            AddBusinessAccountOutputData addBusinessAccountOutputData = new AddBusinessAccountOutputData(
                    businessAccount.getName(), false);
            userPresenter.prepareSuccessView(addBusinessAccountOutputData);
        }
    }
}
