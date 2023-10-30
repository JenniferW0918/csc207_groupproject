package entity;

import java.util.Map;


public class Business {
    private final Integer BUSINESS_ID;
    private final String name;
    private final String password;
    private final String address;
    private final Map<> hours;
    private final BusinessAccount businessAccount;

    public Business(Integer BUSINESS_ID, String name, String passoword, String address, Map<> hours,
                    BusinessAccount businessAccount) {
        this.BUSINESS_ID = BUSINESS_ID;
        this.name = name;
        this.password = password;
        this.address = address;
        this.hours = hours;
        this.businessAccount = businessAccount;
    }

    public Integer getBUSINESS_ID() {
        return BUSINESS_ID;
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

    public BusinessAccount getBusinessAccount() {
        return businessAccount;
    }
}
