package use_case.search_name;

public class SearchNameInputData {
    private final String location;
    private final String term;

    public SearchNameInputData(String term, String location) {
        this.location = location;
        this.term = term;
    }

    public String getLocation() {
        return location;
    }

    public String getTerm() {
        return term;
    }
}
