package use_case.search_name;

/**
 * The SearchNameInputBoundary interface is the interface for the SearchNameInteractor.
 * The execute method takes a SearchNameInputData object as a parameter,
 * which contains the data for the use case.
 */
public interface SearchNameInputBoundary {

    /**
     * This method executes the search name use case with the given term and location.
     * @param searchNameInputData The data for the use case containing  a search
     *                            location and term.
     */
    void execute(SearchNameInputData searchNameInputData);
}
