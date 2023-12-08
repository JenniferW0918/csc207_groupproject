package interface_adapter.search_name;
import use_case.search_name.SearchNameInputBoundary;
import use_case.search_name.SearchNameInputData;
import use_case.search_name.SearchNameOutputData;


/** This class represents the controller for the search name use case.
 * It implements the SearchNameInputBoundary interface.
 * */
public class SearchNameController {
    private final SearchNameInputBoundary searchNameUseCaseInteractor;

    /** This constructor creates a new SearchNameController object.
     * @param searchNameUseCaseInteractor The use case interactor to use.
     * */
    public SearchNameController(SearchNameInputBoundary searchNameUseCaseInteractor) {
        this.searchNameUseCaseInteractor = searchNameUseCaseInteractor;
    }

    /** This method executes the search name use case with the given term and location.
     * @param term The term to search for.
     * @param location The location to search in.
     * */
    public void execute(String term, String location) {
        SearchNameInputData searchNameInputData = new SearchNameInputData(
                term, location);
        searchNameUseCaseInteractor.execute(searchNameInputData);
    }
}

