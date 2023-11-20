package use_case.add_user;

public class AddUserInputData {

    final private String name;
    final private String username;
    final private String password;

    public AddUserInputData(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    String getUsername() {
        return username; }

    String getPassword() {
        return password;
    }

    String getName() {
        return name;
    }
}