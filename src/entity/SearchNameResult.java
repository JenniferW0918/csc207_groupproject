package entity;
import java.util.ArrayList;

/** When api is called the data returned should be turned into a search result object */
public class SearchNameResult {
    private final String term; // search query

    private final String location; // location
    private ArrayList<Business> businesses; // lists of businesses

    public SearchNameResult(String term, String location, ArrayList<Business> businesses) {
        this.term = term;
        this.location = location;
        this.businesses = businesses;
    }

    public String getTerm() {
        return term;
    }

    public String getLocation() {
        return location;
    }

    public ArrayList<Business> getBusinesses() {
        return businesses;
    }
}
