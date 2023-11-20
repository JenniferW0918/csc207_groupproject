package entity;

import java.util.ArrayList;

public class Accounts {
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Business> businesses = new ArrayList<>();


    public Accounts() {
        this.users = new ArrayList<>();
        this.businesses = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public static void addBusiness(Business business) {
        businesses.add(business);
    }

    public static boolean removeUser(User user) {
        return users.remove(user);
    }

    public static boolean removeBusiness(Business business) {
        return businesses.remove(business);
    }

    public static ArrayList<User> getUsers() {
        return new ArrayList<>(users);  // Returning a copy
    }

    public static ArrayList<Business> getBusinesses() {
        return new ArrayList<>(businesses);  // Returning a copy
    }

    public static void getAccounts(Accounts accounts) {

    }
}