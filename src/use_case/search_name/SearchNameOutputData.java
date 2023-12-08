package use_case.search_name;
import entity.SearchNameResult;

/** This class represents the output data for the search name use case.
 * */
public class SearchNameOutputData {
    public final SearchNameResult searchNameResult;
    public boolean useCaseFailed;

    /** This constructor initializes the search name output data
     * @param searchNameResult the search name result
     * @param useCaseFailed boolean value to indicate if the use case failed
     * */
    public SearchNameOutputData(SearchNameResult searchNameResult,  boolean useCaseFailed) {
        this.searchNameResult = searchNameResult;
        this.useCaseFailed = useCaseFailed;
    }

    /** Getter returns the searchNameResult
     * */
    public SearchNameResult getSearchNameResult() {
        return searchNameResult;
    }
}


