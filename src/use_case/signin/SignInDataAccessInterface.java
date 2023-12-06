package use_case.signin;

import entity.BusinessAccount;
import entity.User;


public interface SignInUserDataAccessInterface {
    boolean existsByName(String identifier);


    User getUser(String username);


    BusinessAccount getBusinessAccount(String username);
}

