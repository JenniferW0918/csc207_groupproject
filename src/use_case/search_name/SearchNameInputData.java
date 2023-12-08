package use_case.search_name;

/** The SearchNameInputData class is the input data for the SearchNameInteractor.
 * */
public class SearchNameInputData {
    private final String location;
    private final String term;

    /** This constructor creates a new SearchNameInputData object.
     * @param term The term to search for.
     * @param location The location to search in.
     * */
    public SearchNameInputData(String term, String location) {
        this.term = term;
        this.location = location;
    }

    /** This method returns the term.
     * @return The term.
     * */
    public String getTerm() {
        return term;
    }

    /** This method returns the location.
     * @return The location.
     * */
    public String getLocation() {
        return location;
    }

}
