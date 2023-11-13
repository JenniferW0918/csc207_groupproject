package use_case.signup.add_business;
import java.util.Map;

public class AddBusinessInputData {

    final private String BUSINESS_USERNAME;
    final private String name;
    final private String password;
    final private String repeatPassword;
    final private String address;
    final private Map<String, String> hours;


    public AddBusinessInputData(String username, String name, String password, String repeatPassword, String address,
                                Map<String, String> hours) {
        this.BUSINESS_USERNAME = username;
        this.name = name;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.address = address;
        this.hours = hours;
    }

    String getUsername() {
        return BUSINESS_USERNAME;
    }

    String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }
}

