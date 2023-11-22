package interface_adapter.seached_name;

public class SearchedNameState {
    private String term = "";
    private String location = "";

    public SearchedNameState(SearchedNameState copy) {
        term = copy.getTerm();
        location = copy.getLocation();
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


}
