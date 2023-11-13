package use_case.signup.add_business;

import entity.User;

public interface AddBusinessDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);
}
