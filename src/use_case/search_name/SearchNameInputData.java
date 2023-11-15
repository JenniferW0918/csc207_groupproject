package use_case.search_name;

public class SearchNameInputData {
    public final String location;
    public final String term;

    public SearchNameInputData(String location, String term) {
        this.location = location;
        this.term = term;
    }
}
