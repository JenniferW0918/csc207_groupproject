package entity;

public class User {
    private final String name;
    private final String username;
    private final String email;
    private final String password;
    private final String location;

    public User(String name, String username, String email, String password,
                String location) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.location = location;
    }

    public String getName() {return name;}
    public String getUsername() {return username;}
    public String getEmail() {return email;}
    public String getPassword() {return password;}
    public String getLocation() {return location;}
}
