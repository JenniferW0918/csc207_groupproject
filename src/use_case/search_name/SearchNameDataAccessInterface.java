package use_case.search_name;

import entity.SearchNameResult;

/**
 * The SearchNameDataAccessInterface interface is the interface for the SearchNameDataAccessObject.
 */
public interface SearchNameDataAccessInterface {
    /**
     * This method returns the search name result for the given search name input data.
     * @param searchNameInputData The search name input data.
     * @return The search name result.
     */
   SearchNameResult getSearchName(SearchNameInputData searchNameInputData);
}
