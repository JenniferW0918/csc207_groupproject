package use_case.signup.add_business;

public class AddBusinessOutputData {

    private final String username;

    private boolean useCaseFailed;

    public AddBusinessOutputData(String username, boolean useCaseFailed) {
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }


}
