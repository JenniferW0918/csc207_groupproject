package data_access;

import entity.BusinessAccount;
import entity.User;
import use_case.signup.SignUpDataAccessInterface;

import java.util.ArrayList;

public class Accounts implements SignUpDataAccessInterface {

    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<BusinessAccount> businesses = new ArrayList<>();

    public Accounts() {
        this.users = new ArrayList<>();
        this.businesses = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public static void addBusinessAccount(BusinessAccount businessAccount) {
        businesses.add(businessAccount);
    }

    public static boolean removeUser(User user) {
        return users.remove(user);
    }

    public boolean removeBusiness(BusinessAccount businessAccount) {
        return businesses.remove(businessAccount);
    }

    public static ArrayList<User> getUsers() {
        return new ArrayList<>(users);  // Returning a copy
    }


    public static ArrayList<BusinessAccount> getBusinessAccounts() {
        return new ArrayList<>(businesses);  // Returning a copy
    }

    public static void getAccounts(Accounts accounts) {

    }

    @Override
    public boolean existsByName(String identifier) {
        return false;
    }

    @Override
    public void save(User user) {

    }
}