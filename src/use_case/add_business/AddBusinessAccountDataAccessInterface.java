package use_case.add_business;

import entity.BusinessAccount;

public interface AddBusinessAccountDataAccessInterface {
    boolean existsByName(String identifier);

    void save(BusinessAccount businessAccount);
}

