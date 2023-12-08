package use_case.search_name;
import entity.SearchNameResult;
import java.util.Objects;

/**
 * The SearchNameInteractor class implements the SearchNameInputBoundary interface.
 * It is used to execute the search name use case.
 */
public class SearchNameInteractor implements SearchNameInputBoundary {
    final SearchNameDataAccessInterface searchNameDataAccessObject;
    final SearchNameOutputBoundary searchNamePresenter;

    /**
     * This constructor creates a new SearchNameInteractor object.
     * @param dataAccessInterface The data access object to use.
     * @param outputBoundary The output boundary.
     */
    public SearchNameInteractor(SearchNameDataAccessInterface dataAccessInterface, SearchNameOutputBoundary outputBoundary) {
        this.searchNameDataAccessObject = dataAccessInterface;
        this.searchNamePresenter = outputBoundary;
    }


    @Override
    public void execute(SearchNameInputData searchNameInputData) {
        try {
            if (Objects.equals(searchNameInputData.getTerm(), "")) {
                searchNamePresenter.prepareFailView("Please enter a term");}
            else if ( Objects.equals(searchNameInputData.getLocation(), "")) {
                searchNamePresenter.prepareFailView("Please enter a location");}
            else {
                SearchNameResult searchNameResult = searchNameDataAccessObject.getSearchName(searchNameInputData);
                SearchNameOutputData searchNameOutputData = new SearchNameOutputData(searchNameResult, false);
                searchNamePresenter.prepareSuccessView(searchNameOutputData);
            }
        } catch (RuntimeException e) {
            searchNamePresenter.prepareFailView("No results found :(");
        }
    }
}