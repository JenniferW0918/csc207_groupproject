package use_case.add_business;

import entity.Category;
import java.util.Map;

public class AddBusinessAccountInputData {

    final private String username;
    final private String name;
    final private String password;
    final private String address;
    final private Category categories;


    public AddBusinessAccountInputData(String username, String name, String password, String address,
                                       Category categories) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.address = address;
        this.categories = categories;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

}

