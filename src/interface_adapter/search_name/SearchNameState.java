package interface_adapter.search_name;

public class SearchNameState {
    private String term = "";
    private String termError = null;
    private String location = "";
    private String locationError = null;

    public SearchNameState(SearchNameState copy) {
        term = copy.term;
        termError = copy.termError;
        location = copy.location;
        locationError = copy.locationError;
    }

    public SearchNameState() {
    }

    public String getTerm() {
        return term;
    }

    public String getTermError() {
        return termError;
    }

    public String getLocationError() {
        return locationError;
    }

    public String getLocation() {
        return location;
    }

    public void setTerm(String username) {
        this.term = term;
    }

    public void setTermError(String termError) {
        this.termError = termError;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setLocationError(String locationError) {
        this.locationError = locationError;
    }

    @Override
    public String toString() {
        return "SignupState{" +
                "location='" + location + '\'' +
                ", term='" + term + '\'' +
                '}';
    }
}
