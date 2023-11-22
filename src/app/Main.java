package app;

import data_access.SearchNameDataAccessObject;
import entity.Business;
import entity.SearchNameResult;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.seached_name.SearchedNameViewModel;
import interface_adapter.search_name.SearchNameController;
import interface_adapter.search_name.SearchNamePresenter;
import interface_adapter.search_name.SearchNameViewModel;
import interface_adapter.ViewManagerModel;
import use_case.search_name.SearchNameInputData;
import use_case.search_name.SearchNameInteractor;
import view.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("NomNomNow!!!");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // The data for the views, such as username and password, are in the ViewModels.
        // This information will be changed by a presenter object that is reporting the
        // results from the use case. The ViewModels are observable, and will
        // be observed by the Views.
        SearchNameViewModel searchNameViewModel = new SearchNameViewModel();
        SearchedNameViewModel searchedNameViewModel = new SearchedNameViewModel();


        // Making searchNameView object, maybe make a factory for this
        SearchNameDataAccessObject searchNameDataAccessObject = new SearchNameDataAccessObject();
        SearchNamePresenter searchNamePresenter = new SearchNamePresenter(searchNameViewModel, viewManagerModel);
        SearchNameInteractor searchNameInteractor = new SearchNameInteractor(searchNameDataAccessObject, searchNamePresenter);
        SearchNameController searchNameController = new SearchNameController(searchNameInteractor);


        SearchedNameView searchedNameView = new SearchedNameView(searchedNameViewModel, viewManagerModel);
        views.add(searchedNameView, searchedNameView.viewName);

        SearchNameView searchNameView = new SearchNameView(searchNameController, searchNameViewModel, viewManagerModel);
        views.add(searchNameView, searchNameView.viewName);


//    THE DEFAULT VIEW
        viewManagerModel.setActiveView(searchedNameView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);



        /// Testing SearchFeature
        SearchNameInputData searchNameInputData = new SearchNameInputData("ice-cream", "Toronto");
        searchNameInteractor.execute(searchNameInputData);

        SearchNameResult result = searchNameDataAccessObject.getSearchName(searchNameInputData);
        System.out.println(result.toString());
//
//        ArrayList<Business> businesses = searchNameDataAccessObject.getSearchName(searchNameInputData).getBusinesses();
//        for (Business business : businesses) {
//        System.out.println(business.toString());
    }
}
