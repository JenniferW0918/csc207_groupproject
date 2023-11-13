package use_case.signup;

import entity.User;

public interface AddUserDataAccessInterface {
    boolean existsByName(String identifier);
    void save(User user);
}
