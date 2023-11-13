package use_case.signup;

public class AddUserOutputData {

    private final String username;
    private boolean useCaseFailed;

    public AddUserOutputData(String username, boolean useCaseFailed) {
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {

        return username;
    }

    public void setCreationTime(String creationTime) {

        this.creationTime = creationTime;
    }

}
