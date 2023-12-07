package use_case.add_business;

public class AddBusinessAccountInputData {

    final private String username;
    final private String name;
    final private String password;
    final private String address;
    final private String category;


    public AddBusinessAccountInputData(String username, String name, String password, String address,
                                       String category) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.address = address;
        this.category = category;
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

    String getCategory(){
        return category;
    }


}

