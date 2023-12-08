package entity;
import java.util.ArrayList;
import java.util.Map;

/** This class represents the result of searching by name
 *  It contains the search query, location, and a list of businesses that match the search query
 * */
public class SearchNameResult {
    private final String term;  /* search query*/

    private final String location; /* location */

    private final ArrayList<Business> businesses; /*lists of businesses */


    /** Constructor for SearchNameResult
     * @param term search query
     * @param location location
     * @param businesses list of businesses
     * */
    public SearchNameResult(String term, String location, ArrayList<Business> businesses) {
        this.term = term;
        this.location = location;
        this.businesses = businesses;
    }

    /** Getter for SearchNameResult term
     * @return term
     * */
    public String getTerm() {
        return term;
    }

    /** Returns the location of a search
     * @return location
     * */
    public String getLocation() {
        return location;
    }

    /** Returns the list of businesses
     * @return businesses
     * */
    public ArrayList<Business> getBusinesses() {
        return businesses;
    }

    /** Returns the string representation of SearchNameResult
     * @return result the string representation of SearchNameResult
     * */
    public String toString() {
        String result = "";
        result += "Term: " + term + "\n";
        result += "Location: " + location + "\n";
        result += "Businesses: " + "\n";
        for (Business business : businesses) {
            result += business.toString() + "\n";
        }
        return result;
    }

    /** Returns the list of businesses as an array of strings
     * @return businesses as an array of strings* */
    public String[] toList() {
        ArrayList<String> preResult = new ArrayList<>();
        for (Business business : businesses) {
            String b = "";
            b += business.toString();
            preResult.add(b);
        }
        return preResult.toArray(new String[0]);
    }
}
