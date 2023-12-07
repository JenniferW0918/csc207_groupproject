import data_access.Accounts;
import entity.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.search_name.SearchNameViewModel;
import interface_adapter.signin.SignInPresenter;
import interface_adapter.signin.SignInViewModel;
import org.junit.Test;
import use_case.signin.SignInInputData;
import use_case.signin.SignInInteractor;
import use_case.signin.SignInOutputBoundary;

import javax.swing.*;

import static org.junit.Assert.*;

public class SignInTests {

    static String message = "";
    static boolean popUpDiscovered = false;
    @Test
    public void testSignInUserSuccess() {
        // Arrange
        Accounts dataAccessObject = createDataAccessObject();
        SignInViewModel signInViewModel = createSignInViewModel();
        SearchNameViewModel searchNameViewModel = createSearchNameViewModel();
        ViewManagerModel viewManagerModel = createViewManagerModel();

        SignInOutputBoundary signInOutputBoundary = createSignInOutputBoundary(viewManagerModel, signInViewModel, searchNameViewModel);
        SignInInteractor interactor = createSignInInteractor(dataAccessObject, signInOutputBoundary);

        // Create a user for testing
        User testUser = new User("testuser", "Test User", "password");
        dataAccessObject.saveUser(testUser);

        // Input data for user sign in
        SignInInputData inputData = new SignInInputData("testuser", "password");

        // Act
        interactor.execute(inputData);

        // Assert
        assertFalse(signInViewModel.getState().getUsernameError(), signInViewModel.getState().getUsernameError() != null);
        // assertTrue(popUpDiscovered);
        // assertEquals("Welcome, Test User!", message);
    }

    // Test case for unsuccessful user sign in (incorrect password)
    @Test
    public void testSignInUserIncorrectPassword() {
        // Arrange
        Accounts dataAccessObject = createDataAccessObject();
        SignInViewModel signInViewModel = createSignInViewModel();
        SearchNameViewModel searchNameViewModel = createSearchNameViewModel();
        ViewManagerModel viewManagerModel = createViewManagerModel();

        SignInOutputBoundary signInOutputBoundary = createSignInOutputBoundary(viewManagerModel, signInViewModel, searchNameViewModel);
        SignInInteractor interactor = createSignInInteractor(dataAccessObject, signInOutputBoundary);

        // Create a user for testing
        User testUser = new User("testuser", "Test User", "password");
        dataAccessObject.saveUser(testUser);

        // Input data with incorrect password
        SignInInputData inputData = new SignInInputData("testuser", "incorrect_password");

        // Act
        interactor.execute(inputData);

        // Assert
        assertTrue(signInViewModel.getState().getUsernameError() == null);
        assertTrue(popUpDiscovered);
        assertEquals("Incorrect password for testuser.", message);
    }

    // Additional test cases can be added for business sign in, non-existing account, etc.

    // Helper methods to create instances of required objects
    private SignInViewModel createSignInViewModel() {
        return new SignInViewModel();
    }

    private SignInOutputBoundary createSignInOutputBoundary(ViewManagerModel viewManagerModel, SignInViewModel signInViewModel, SearchNameViewModel searchNameViewModel) {
        return new SignInPresenter(signInViewModel, searchNameViewModel, viewManagerModel);
    }

    private SignInInteractor createSignInInteractor(Accounts dataAccessObject, SignInOutputBoundary signInOutputBoundary) {
        return new SignInInteractor(dataAccessObject, signInOutputBoundary);
    }

    private Accounts createDataAccessObject() {
        return new Accounts();
    }

    private ViewManagerModel createViewManagerModel() {
        return new ViewManagerModel();
    }

    private SearchNameViewModel createSearchNameViewModel() {
        return new SearchNameViewModel();
    }
}