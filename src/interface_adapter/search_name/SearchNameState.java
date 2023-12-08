package interface_adapter.search_name;

/** The SearchNameState class is the view model for the SearchNameView.
 * */
public class SearchNameState {
    private String term = "";
    private String termError = null;
    private String location = "";
    private String locationError = null;

    /** This constructor creates a new SearchNameState object.
     * @param copy The SearchNameState object to copy.
     * */
    public SearchNameState(SearchNameState copy) {
        term = copy.term;
        termError = copy.termError;
        location = copy.location;
        locationError = copy.locationError;
    }

    /** This constructor creates a new SearchNameState object.
     * */
    public SearchNameState() {
    }

    /** This method returns the term.
     * @return The term.
     * */
    public String getTerm() {
        return term;
    }

    /** This method returns the term.
     * @return The term.
     * */
    public String getTermError() {
        return termError;
    }

    /** This method returns the location.
     * @return The location.
     * */
    public String getLocationError() {
        return locationError;
    }

    /** This method returns the location.
     * @return The location.
     * */
    public String getLocation() {
        return location;
    }

    /** This method sets the term.
     * @param term The term.
     * */
    public void setTerm(String term) {
        this.term = term;
    }

    /** This method sets the term.
     * @param termError The term.
     * */
    public void setTermError(String termError) {
        this.termError = termError;
    }

    /** This method sets the location.
     * @param location The location.
     * */
    public void setLocation(String location) {
        this.location = location;
    }

    /** This method sets the location.
     * @param locationError The location.
     * */
    public void setLocationError(String locationError) {
        this.locationError = locationError;
    }

}
