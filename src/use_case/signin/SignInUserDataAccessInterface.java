package use_case.signin;

import entity.BusinessAccount;
import entity.User;


public interface SignInUserDataAccessInterface {
    boolean userExistsByUsername(String identifier);

    boolean businessExistsByUsername(String identifier);


    User getUser(String username);


    BusinessAccount getBusinessAccount(String username);
}

