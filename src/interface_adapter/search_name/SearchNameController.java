package interface_adapter.search_name;
import use_case.search_name.SearchNameInputBoundary;

public class SearchNameController {
    private final SearchNameInputBoundary searchNameUseCaseInteractor;

    public SearchNameController(SearchNameInputBoundary userSignupUseCaseInteractor, SearchNameInputBoundary searchNameUseCaseInteractor) {
        this.searchNameUseCaseInteractor = searchNameUseCaseInteractor;
    }

    public void execute() {
        searchNameUseCaseInteractor.execute();}
}


//// Controller
//public class SearchNameController {
//    private final SearchNameInputBoundary inputBoundary;
//
//    public SearchNameController(SearchNameInputBoundary inputBoundary) {
//        this.inputBoundary = inputBoundary;
//    }
//
//    public void handleSearchRequest(String location, String term) {
//        SearchNameInputData inputData = new SearchNameInputData(location, term);
//        inputBoundary.searchName(inputData);
//    }
//}