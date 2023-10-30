package entity;

import java.util.ArrayList;

public class Accounts {
    private final ArrayList<User> users;
    private final ArrayList<Business> businesses;


    private Accounts() {
        this.users = new ArrayList<>();
        this.businesses = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addBusiness(Business business) {
        businesses.add(business);
    }

    public boolean removeUser(User user) {
        return users.remove(user);
    }

    public boolean removeBusiness(Business business) {
        return businesses.remove(business);
    }

    public ArrayList<User> getUsers() {
        return new ArrayList<>(users);  // Returning a copy
    }

    public ArrayList<Business> getBusinesses() {
        return new ArrayList<>(businesses);  // Returning a copy
    }
}