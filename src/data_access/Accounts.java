package data_access;

import entity.BusinessAccount;
import entity.User;
import use_case.add_user.AddUserDataAccessInterface;
import use_case.add_business.AddBusinessAccountDataAccessInterface;

import java.util.ArrayList;

public class Accounts implements AddBusinessAccountDataAccessInterface, AddUserDataAccessInterface {

    private final ArrayList<User> users = new ArrayList<>();
    private final ArrayList<BusinessAccount> businesses = new ArrayList<>();

    public Accounts() {
    }

    @Override
    public void saveUser(User user) {
        users.add(user);
    }

    @Override
    public boolean userExistsByUsername(String identifier) {
        for (User user : users) {
            if (user.getUsername().equals(identifier)) {
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
    public boolean businessExistsByUsername(String identifier) {
        for (BusinessAccount businessAccount : businesses) {
            if (businessAccount.getUsername().equals(identifier)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<User> getUsers() {
        return new ArrayList<>(users);  // Returning a copy
    }


    public ArrayList<BusinessAccount> getBusinessAccounts() {
        return new ArrayList<>(businesses);  // Returning a copy
    }

}