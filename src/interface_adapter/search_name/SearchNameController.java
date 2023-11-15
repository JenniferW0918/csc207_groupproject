package interface_adapter.search_name;
import use_case.search_name.SearchNameInputBoundary;
import use_case.search_name.SearchNameInputData;
import use_case.search_name.SearchNameOutputData;


public class SearchNameController {
    private final SearchNameInputBoundary searchNameUseCaseInteractor;

    public SearchNameController(SearchNameInputBoundary searchNameUseCaseInteractor)
    {
        this.searchNameUseCaseInteractor = searchNameUseCaseInteractor;
    }

    public void execute(String location, String term){
        SearchNameInputData searchNameInputData = new SearchNameInputData(
                location, term);
        searchNameUseCaseInteractor.execute(searchNameInputData);
    }
}