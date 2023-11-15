package use_case.search_name;

public interface SearchNameOutputBoundary {

    void prepareSuccessView(SearchNameOutputData searchNameOutputData);

    void prepareFailView(String error);}
