package entity;

public class User {
    private final String name;
    private final String username;
    private final String password;

    public User(String name, String username, String email, String password,
                String location) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name; }
    public String getUsername() {
        return username; }
    public String getPassword() {
        return password; }
}
