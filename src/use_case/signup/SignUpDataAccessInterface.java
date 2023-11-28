package use_case.signup;

import entity.User;

public interface SignUpDataAccessInterface {

    void saveUser(User user);
}
