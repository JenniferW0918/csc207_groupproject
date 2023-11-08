package interface_adapter.search_name;
import use_case.search_name.SearchNameInputBoundary;

public class SearchNameController {
    final SearchNameInputBoundary searchNameUseCaseInteractor;

    public SearchNameController(SearchNameInputBoundary userSignupUseCaseInteractor, SearchNameInputBoundary searchNameUseCaseInteractor) {
        this.searchNameUseCaseInteractor = searchNameUseCaseInteractor;
    }

    public void execute() {
        searchNameUseCaseInteractor.execute();}
}
