package app;

import data_access.Accounts;
import entity.UserFactory;
import entity.UserFactoryInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_user.AddUserController;
import interface_adapter.add_user.AddUserViewModel;
import interface_adapter.search_name.SearchNameViewModel;
import interface_adapter.add_user.AddUserPresenter;
import use_case.add_user.AddUserDataAccessInterface;
import use_case.add_user.AddUserInputBoundary;
import use_case.add_user.AddUserInteractor;
import use_case.add_user.AddUserOutputBoundary;
import view.AddUserView;

import javax.swing.*;
import java.io.IOException;

/**
 * Factory class for creating components for the Add User use case.
 */
public class AddUserUseCaseFactory {
    private AddUserUseCaseFactory() {}

    /**
     * Creates an instance of AddUserView with the necessary dependencies.
     *
     * @param viewManagerModel the model that manages the views in the application
     * @param searchNameViewModel the view model for the Search Name use case
     * @param addUserViewModel the view model for the Add User use case
     * @param dataAccessObject the data access object for created accounts
     * @return an instance of AddUserView
     */
    public static AddUserView createUserView(
            ViewManagerModel viewManagerModel,
            SearchNameViewModel searchNameViewModel,
            AddUserViewModel addUserViewModel,
            Accounts dataAccessObject) {

        try {
            AddUserController addUserController = createUserUseCase(
                    viewManagerModel, addUserViewModel, searchNameViewModel, dataAccessObject);
            return new AddUserView(addUserController, addUserViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "What do we write here?");
        }

        return null;
    }

    private static AddUserController createUserUseCase(ViewManagerModel viewManagerModel,
                                                       AddUserViewModel addUserViewModel,
                                                       SearchNameViewModel searchNameViewModel,
                                                       Accounts dataAccessObject) throws IOException {

        AddUserOutputBoundary addUserOutputBoundary = new AddUserPresenter(
                viewManagerModel, addUserViewModel, searchNameViewModel);

        UserFactoryInterface userFactoryInterface = new UserFactory();

        AddUserInputBoundary addUserInteractor = new AddUserInteractor(
                dataAccessObject, addUserOutputBoundary, userFactoryInterface);

        return new AddUserController(addUserInteractor);
    }
}