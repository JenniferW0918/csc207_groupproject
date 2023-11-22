package use_case.add_business;

import entity.BusinessAccount;
import entity.BusinessAccountFactoryInterface;
import entity.Accounts;


import java.time.LocalDateTime;

public class AddBusinessAccountInteractor implements AddBusinessAccountInputBoundary {
    final AddBusinessAccountDataAccessInterface addBusinessAccountDataAccessObject;
    final AddBusinessAccountOutputBoundary userPresenter;
    final BusinessAccountFactoryInterface businessAccountFactoryInterface;

    public AddBusinessAccountInteractor(AddBusinessAccountDataAccessInterface addBusinessDataAccessInterface,
                                        AddBusinessAccountOutputBoundary addBusinessOutputBoundary,
                                        BusinessAccountFactoryInterface businessAccountFactoryInterface) {
        this.addBusinessAccountDataAccessObject = addBusinessDataAccessInterface;
        this.userPresenter = addBusinessOutputBoundary;
        this.businessAccountFactoryInterface = businessAccountFactoryInterface;
    }

    @Override
    public void execute(AddBusinessAccountInputData addBusinessAccountInputData) {
        // need to iterate through accounts.getBusinessAccount bc it returns an array list of BusinessAccounts
        // so if addBusinessInputData.getUsername() == one of the usernames in array list, "user already exists"
        if (Accounts.getBusinessAccounts().contains(addBusinessAccountInputData.getUsername())) {
            userPresenter.prepareFailView("User already exists.");
        } else {

            BusinessAccount businessAccount = businessAccountFactoryInterface.create(
                    addBusinessAccountInputData.getUsername(),
                    addBusinessAccountInputData.getName(),
                    addBusinessAccountInputData.getPassword(),
                    addBusinessAccountInputData.getAddress(),
                    addBusinessAccountInputData.getCategories());
            Accounts.addBusinessAccount(businessAccount);

            AddBusinessAccountOutputData addBusinessAccountOutputData = new AddBusinessAccountOutputData(
                    businessAccount.getName(), false);
            userPresenter.prepareSuccessView(addBusinessAccountOutputData);
        }
    }
}
