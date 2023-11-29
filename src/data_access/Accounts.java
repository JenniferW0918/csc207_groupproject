package data_access;

import entity.BusinessAccount;
import entity.User;
import use_case.add_user.AddUserDataAccessInterface;
import use_case.add_business.AddBusinessAccountDataAccessInterface;

import java.util.ArrayList;

public class Accounts implements AddBusinessAccountDataAccessInterface, AddUserDataAccessInterface {

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

}