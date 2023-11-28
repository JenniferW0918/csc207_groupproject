package app;

import entity.UserFactory;
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

public class AddUserUseCaseFactory {
    private AddUserUseCaseFactory() {}

    public static AddUserView create(
            ViewManagerModel viewManagerModel, SearchNameViewModel searchNameViewModel,
            AddUserViewModel addUserViewModel,
            AddUserDataAccessInterface userDataAccessObject) {

        try {
            AddUserController addUserController = createUserSignupUseCase(
                    viewManagerModel, addUserViewModel, searchNameViewModel, userDataAccessObject);
            return new AddUserView(addUserController, addUserViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static AddUserController createUserSignupUseCase(ViewManagerModel viewManagerModel,
                                                                                   AddUserViewModel addUserViewModel,
                                                                                   SearchNameViewModel searchNameViewModel,
                                                                                   AddUserDataAccessInterface userDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        AddUserOutputBoundary addUserOutputBoundary = new AddUserPresenter(
                viewManagerModel, addUserViewModel, searchNameViewModel);

       UserFactory userFactory = new UserFactory();

        AddUserInputBoundary addUserInteractor = new AddUserInteractor(
                userDataAccessObject, addUserOutputBoundary, userFactory);

        return new AddUserController(addUserInteractor);
    }
}