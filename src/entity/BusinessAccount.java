package entity;

import java.util.Map;


public class BusinessAccount {
    private final String username;
    private final String name;
    private final String password;
    private final String address;
    private final Accounts businessAccount;
    private final Category categories;

    public BusinessAccount(String username, String name, String password, String address, Accounts businessAccount,
                           Category categories) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.address = address;
        this.businessAccount = businessAccount;
        this.categories = categories;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public Accounts getBusinessAccount() {
        return businessAccount;
    }

    public Category getCategories(){
        return categories;}
}
