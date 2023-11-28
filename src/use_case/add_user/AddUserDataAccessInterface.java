package use_case.add_user;

import entity.User;

public interface AddUserDataAccessInterface {
    boolean userExistsByName(String identifier);

    void saveUser(User user);
}

