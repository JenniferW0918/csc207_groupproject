package app;

import data_access.Accounts;
import data_access.SearchNameDataAccessObject;
import entity.SearchNameResult;
import interface_adapter.add_business.AddBusinessAccountController;
import interface_adapter.add_business.AddBusinessAccountViewModel;
import interface_adapter.add_user.AddUserController;
import interface_adapter.add_user.AddUserPresenter;
import interface_adapter.add_user.AddUserViewModel;
import interface_adapter.seached_name.SearchedNameViewModel;
import interface_adapter.search_name.SearchNameController;
import interface_adapter.search_name.SearchNameViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.signup.AddBusinessAccountPresenter;
import use_case.add_business.AddBusinessAccountInteractor;
import use_case.add_user.AddUserInteractor;
import use_case.search_name.SearchNameInputData;
import view.*;
import javax.swing.*;
import java.awt.*;

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
        AddUserViewModel addUserViewModel = new AddUserViewModel();
        AddBusinessAccountViewModel addBusinessAccountViewModel = new AddBusinessAccountViewModel();
        LoginViewModel loginViewModel = new LoginViewModel();


        //Making Data Access Objects
        SearchNameDataAccessObject searchNameDataAccessObject = new SearchNameDataAccessObject();
        Accounts userDataAccessObject = new Accounts();

        // Making an AddUserView object
        AddUserPresenter addUserPresenter = new AddUserPresenter(viewManagerModel, addUserViewModel, loginViewModel);
        AddUserInteractor addUserInteractor = new AddUserInteractor(userAddUserUseCaseInteractor);
        AddUserController addUserController = new AddUserController(userAddUserUseCaseInteractor);
        // testing commits/pulls
        // ugh!

        AddUserView addUserView = new AddUserView(addUserController, addUserViewModel);
        views.add(addUserView, addUserView.viewName);

        // Making an AddBusinessAccountView object
        AddBusinessAccountPresenter addBusinessAccountPresenter = new AddBusinessAccountPresenter(viewManagerModel,
                addBusinessAccountViewModel, loginViewModel);
        AddBusinessAccountInteractor addBusinessAccountInteractor = new AddBusinessAccountInteractor(userAddBusinessUseCaseInteractor);
        AddBusinessAccountController addBusinessAccountController = new AddBusinessAccountController(userAddBusinessUseCaseInteractor);

        AddBusinessAccountView addBusinessAccountView = new AddBusinessAccountView(addBusinessAccountController,
                addBusinessAccountViewModel);
        views.add(addBusinessAccountView, addBusinessAccountView.viewName);

        // Making searchNameView
        SearchNameView searchNameView = SearchNameUseCaseFactory.createSearchNameView(viewManagerModel,
                searchNameViewModel, searchNameDataAccessObject, searchedNameViewModel);
        views.add(searchNameView, searchNameView.viewName);

        //Making SearchedNameView
        SearchedNameView searchedNameView = new SearchedNameView(searchedNameViewModel, viewManagerModel);
        views.add(searchedNameView, searchedNameView.viewName);

        // Making SignUpView
        SignUpView signUpView = SignUpUseCaseFactory.create(viewManagerModel, loginViewModel, signUpViewModel, userDataAccessObject);
        views.add(signUpView, signUpView.viewName);


//    THE DEFAULT VIEW
        viewManagerModel.setActiveView(signUpView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);



        /// Testing SearchFeature
        SearchNameInputData searchNameInputData = new SearchNameInputData("ice-cream", "Toronto");
        SearchNameResult result = searchNameDataAccessObject.getSearchName(searchNameInputData);
        System.out.println(result.toString());
    }
}
