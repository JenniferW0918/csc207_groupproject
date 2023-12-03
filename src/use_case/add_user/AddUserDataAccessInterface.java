package use_case.add_user;

import entity.User;

public interface AddUserDataAccessInterface {
    boolean userExistsByUsername(String identifier);

    void saveUser(User user);
}

