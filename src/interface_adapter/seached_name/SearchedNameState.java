package interface_adapter.seached_name;

import entity.SearchNameResult;

import java.util.Map;

/**
 * The SearchedNameState class represents the state for the searched name feature.
 * It contains the term and location for the search, and the search results.
 */
public class SearchedNameState {
    private String term;
    private String location;
    private SearchNameResult searchResultsInteractive;

    /**
     * This constructor creates a new SearchedNameState object
     * @param copy The SearchedNameState object to copy.
     */
    public SearchedNameState(SearchedNameState copy) {
        term = copy.getTerm();
        location = copy.getLocation();
        searchResultsInteractive = copy.getSearchResultsInteractive();
    }

    /**
     * This constructor creates a new SearchedNameState object with no initial term, location, or search results.
     */
    public SearchedNameState() {
    }

    /**
     * This method returns the term of the search.
     * @return The term of the search.
     */
    public String getTerm() {
        return term;
    }

    /**
     * This method returns the location of the search.
     * @return The location of the search.
     */
    public String getLocation() {
        return location;
    }

    /**
     * This method sets the search results.
     * @param term The search results.
     */
    public void setTerm(String term) {
        this.term = term;
    }

    /**
     * This method sets the location of the search.
     * @param location The location of the search.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * This method sets the search results.
     * @param searchResultsInteractive The search results.
     */
    public void setSearchResultsInteractive(SearchNameResult searchResultsInteractive) {
        this.searchResultsInteractive = searchResultsInteractive;}

    /** This method returns the search results
     * @return searchResultsInteractive */
    public  SearchNameResult getSearchResultsInteractive() {
       return searchResultsInteractive;
    }
}
