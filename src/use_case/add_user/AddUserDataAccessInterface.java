package use_case.add_user;

import entity.User;

public interface AddUserDataAccessInterface {
    boolean existsByName(String identifier);
    void save(User user);
}
