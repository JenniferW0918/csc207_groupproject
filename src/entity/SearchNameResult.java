package entity;
import java.util.ArrayList;

/** When api is called the data returned should be turned into a search result object
  Need code that turns getSearchName output into a search result and business objects **/

public class SearchNameResult {
    public final String term; // search query

    public final String location; // location
    public ArrayList<Business> businesses; // lists of businesses

    public SearchNameResult(String term, String location, ArrayList<Business> businesses) {
        this.term = term;
        this.location = location;
        this.businesses = businesses;
    }
}
