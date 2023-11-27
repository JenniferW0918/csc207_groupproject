package use_case.search_name;

public class SearchNameInputData {
    private final String location;
    private final String term;

    public SearchNameInputData(String term, String location) {
        this.term = term;
        this.location = location;
    }

    public String getTerm() {
        return term;
    }

    public String getLocation() {
        return location;
    }

}
