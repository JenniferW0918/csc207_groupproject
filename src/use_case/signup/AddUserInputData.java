package use_case.signup;

public class AddUserInputData {

    final private String name;
    final private String username;
    final private String email;
    final private String password;
    final private String location;

    public AddUserInputData(String name, String username, String email, String password, String location) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.location = location;
    }

    String getUsername() { return username; }

    String getPassword() {
        return password;
    }
}
