package use_case.add_business;

import entity.User;

public interface AddBusinessAccountDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);
}

