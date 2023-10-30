package extra;

import java.util.ArrayList;
import java.util.List;


/**
 * a search feature where each search query produces a extra.SearchResult instance with a unique ID
 * Search Query: what was typed in
 * Unique Search ID: every search has an ID
 **/
public class SearchResult {
    private static int nextId = 1; // to generate unique IDs
    private final int searchId;
    private final String query;
    private final ArrayList<String> results;  //(should be a list of string so that we can get both business acc and those from API)

    public SearchResult(String query, ArrayList<String> results) {
        this.searchId = nextId++;
        this.query = query;
        this.results = results;
        }

        public int getSearchId() {
            return searchId;
        }

        public String getQuery() {
            return query;
        }

        public ArrayList<String> getResults() {
            return results;
        }

        @Override
        public String toString() {
            return "extra.SearchResult{" +
                    "searchId=" + searchId +
                    ", query='" + query + '\'' +
                    ", results=" + results +
                    '}';
        }
    }


