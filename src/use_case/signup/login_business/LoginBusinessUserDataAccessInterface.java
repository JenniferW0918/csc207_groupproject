package use_case.signup.login_business;

import entity.User;

public interface LoginBusinessUserDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);

    User get(String username);
}
