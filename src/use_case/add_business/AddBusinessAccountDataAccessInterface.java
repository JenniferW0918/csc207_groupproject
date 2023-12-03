package use_case.add_business;

import entity.BusinessAccount;

public interface AddBusinessAccountDataAccessInterface {
    boolean businessExistsByUsername(String identifier);

    void saveBusiness(BusinessAccount businessAccount);
}

