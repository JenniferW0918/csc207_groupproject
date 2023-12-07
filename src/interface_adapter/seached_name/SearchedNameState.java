package interface_adapter.seached_name;

import entity.SearchNameResult;

import java.util.Map;

public class SearchedNameState {
    private String term;
    private String location;

    private SearchNameResult searchResultsInteractive;


    public SearchedNameState(SearchedNameState copy) {
        term = copy.getTerm();
        location = copy.getLocation();
        searchResultsInteractive = copy.getSearchResultsInteractive();
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

    public void setSearchResultsInteractive(SearchNameResult searchResultsInteractive) {
        this.searchResultsInteractive = searchResultsInteractive;}

    public  SearchNameResult getSearchResultsInteractive() {
       return searchResultsInteractive;
    }
}
