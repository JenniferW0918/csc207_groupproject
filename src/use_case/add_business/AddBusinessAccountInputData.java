package use_case.add_business;

public class AddBusinessAccountInputData {

    final private String username;
    final private String name;
    final private String password;
    final private String address;
    final private String categories;


    public AddBusinessAccountInputData(String username, String name, String password, String address,
                                       String categories) {
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

    String getName(){
        return name;
    }

    String getAddress(){
        return address;
    }

    String getCategories(){
        return categories;
    }


}

