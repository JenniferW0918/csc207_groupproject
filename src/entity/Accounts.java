package entity;

import java.util.ArrayList;

public class Accounts {
    private final ArrayList<User> users;
    private static ArrayList<BusinessAccount> businesses = new ArrayList<>();


    private Accounts() {
        this.users = new ArrayList<>();
        this.businesses = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public static void addBusinessAccount(BusinessAccount businessAccount) {
        businesses.add(businessAccount);
    }

    public boolean removeUser(User user) {
        return users.remove(user);
    }

    public boolean removeBusiness(BusinessAccount businessAccount) {
        return businesses.remove(businessAccount);
    }

    public ArrayList<User> getUsers() {
        return new ArrayList<>(users);  // Returning a copy
    }

    public static ArrayList<BusinessAccount> getBusinessAccounts() {
        return new ArrayList<>(businesses);  // Returning a copy
    }
}