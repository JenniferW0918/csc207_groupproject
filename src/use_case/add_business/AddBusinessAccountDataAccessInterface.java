package use_case.add_business;

import entity.BusinessAccount;

public interface AddBusinessAccountDataAccessInterface {
    boolean businessExistsByName(String identifier);

    void saveBusiness(BusinessAccount businessAccount);
}

