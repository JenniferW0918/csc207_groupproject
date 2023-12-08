package use_case.search_name;

/** The SearchNameInputBoundary interface is the interface for the SearchNameInteractor.
 * */
public interface SearchNameOutputBoundary {

    /**
     * This method prepares the view for a successful search name operation.
     * It takes a SearchNameOutputData object as a parameter, which contains the search results.
     * @param searchNameOutputData The data for the successful search name operation.
 */
    void prepareSuccessView(SearchNameOutputData searchNameOutputData);

    /**
     * This method prepares the view for a failed search name use case.
     * @param error The error message.
     */
    void prepareFailView(String error);}
