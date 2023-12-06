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
        // need to check if the business account username already exists in accounts
        // - ie check that a business account object with the same username doesn't already exist
        if (dataAccessObject.getBusinessAccounts().contains(addBusinessAccountInputData.getUsername())) {

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
