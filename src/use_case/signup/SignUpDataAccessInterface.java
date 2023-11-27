package use_case.signup;

import entity.User;

public interface SignUpDataAccessInterface {
    boolean userExistsByName(String identifier);

    void saveUser(User user);
}
