package data_access;

import entity.BusinessAccount;
import entity.User;
import use_case.add_user.AddUserDataAccessInterface;
import use_case.add_business.AddBusinessAccountDataAccessInterface;
import use_case.signin.SignInUserDataAccessInterface;

import java.util.ArrayList;

public class Accounts implements AddBusinessAccountDataAccessInterface, AddUserDataAccessInterface,
        SignInUserDataAccessInterface {

    private static final ArrayList<User> users = new ArrayList<>();
    private static final ArrayList<BusinessAccount> businesses = new ArrayList<>();

    public Accounts() {
    }

    @Override
    public void saveUser(User user) {
        users.add(user);
    }

    @Override
    public boolean userExistsByName(String identifier) {
        for (User user : users) {
            if (user.getName().equals(identifier)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void saveBusiness(BusinessAccount businessAccount) {
        businesses.add(businessAccount);

    }

    @Override
    public boolean businessExistsByName(String identifier) {
        for (BusinessAccount businessAccount : businesses) {
            if (businessAccount.getName().equals(identifier)) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<User> getUsers() {
        return new ArrayList<>(users);  // Returning a copy
    }


    public static ArrayList<BusinessAccount> getBusinessAccounts() {
        return new ArrayList<>(businesses);  // Returning a copy
    }

    @Override
    public boolean existsByName(String username) {
        // go through arraylists and find whether the user exists, return true if yes, false otherwise
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        for (BusinessAccount businessAccount : businesses) {
            if (businessAccount.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User getUser(String username) {
        // only go through if existsByName is true, go through user arraylist and return user object with the
        // matching username
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null; // User not found
    }

    @Override
    public BusinessAccount getBusinessAccount(String username) {
        // only go through if existsByName is true, go through businessAccount arraylist and return business
        // object with the matching username
        for (BusinessAccount businessAccount : businesses) {
            if (businessAccount.getUsername().equals(username)) {
                return businessAccount;
            }
        }
        return null; // BusinessAccount not found
    }
}