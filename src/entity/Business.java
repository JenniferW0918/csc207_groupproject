package entity;

import java.util.Map;


public class Business {
    private final Integer BUSINESS_USERNAME;
    private final String name;
    private final String password;
    private final String address;
    private final Map<String, String> hours;
    private final Accounts businessAccount;

    public Business(Integer BUSINESS_USERNAME, String name, String password, String address, Map<String, String> hours,
                    Accounts businessAccount) {
        this.BUSINESS_USERNAME = BUSINESS_USERNAME;
        this.name = name;
        this.password = password;
        this.address = address;
        this.hours = hours;
        this.businessAccount = businessAccount;
    }

    public Integer getBUSINESS_ID() {
        return BUSINESS_USERNAME;
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

    public Map getHours() {
        return hours;
    }

    public Accounts getBusinessAccount() {
        return businessAccount;
    }
}
