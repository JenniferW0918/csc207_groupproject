package use_case.search_name;
import entity.SearchNameResult;


public class SearchNameOutputData {
    public final SearchNameResult searchNameResult;
    public boolean useCaseFailed;

    public SearchNameOutputData( SearchNameResult searchNameResult,  boolean useCaseFailed) {
        this.searchNameResult = searchNameResult;
        this.useCaseFailed = useCaseFailed;

    }

    public SearchNameResult getSearchNameResult() {
        return searchNameResult;
    }
}
