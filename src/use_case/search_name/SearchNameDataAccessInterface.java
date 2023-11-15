package use_case.search_name;

import entity.SearchNameResult;

public interface SearchNameDataAccessInterface {
   SearchNameResult getSearchName(SearchNameInputData searchNameInputData);
}
