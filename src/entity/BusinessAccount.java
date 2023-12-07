package entity;


public class BusinessAccount {
    private final String username;
    private final String name;
    private final String password;
    private final String address;
    private final String category;

    public BusinessAccount(String username, String name, String password, String address,
                           String category) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.address = address;
        this.category = category;
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

    public String getCategory(){
        return category;}
}
