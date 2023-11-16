package use_case.add_business;

public class AddBusinessAccountOutputData {

    private final String username;

    private boolean useCaseFailed;

    public AddBusinessAccountOutputData(String username, boolean useCaseFailed) {
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }


}


