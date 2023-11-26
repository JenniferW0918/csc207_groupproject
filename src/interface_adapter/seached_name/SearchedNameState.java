package interface_adapter.seached_name;

public class SearchedNameState {
    private String term;
    private String location;

    private String searchResults;

    public SearchedNameState(SearchedNameState copy) {
        term = copy.getTerm();
        location = copy.getLocation();
        searchResults = copy.getSearchResults();
    }

    public SearchedNameState() {
    }

    public String getTerm() {
        return term;
    }

    public String getLocation() {
        return location;
    }

    public void setTerm(String term) {
        this.term = term;
    }


    public void setLocation(String location) {
        this.location = location;
    }

    public String getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(String searchResults) {
        this.searchResults = searchResults;
    }

}
