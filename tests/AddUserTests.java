
import data_access.Accounts;
import entity.*;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_user.AddUserPresenter;
import interface_adapter.add_user.AddUserState;
import interface_adapter.add_user.AddUserViewModel;
import interface_adapter.search_name.SearchNameViewModel;
import org.junit.Test;
import use_case.add_user.AddUserInputData;
import use_case.add_user.AddUserInteractor;
import use_case.add_user.AddUserOutputBoundary;


import javax.swing.*;

import static org.junit.Assert.*;

public class AddUserTests {

    static String message = "";
    static boolean popUpDiscovered = false;

    private AddUserInteractor createAddUserInteractor(Accounts dataAccessObject,
                                                      AddUserOutputBoundary addUserOutputBoundary,
                                                      UserFactoryInterface userFactoryInterface) {
        return new AddUserInteractor(dataAccessObject, addUserOutputBoundary, userFactoryInterface);
    }

    private AddUserOutputBoundary createAddUserOutputBoundary(ViewManagerModel viewManagerModel,
                                                              AddUserViewModel addUserViewModel,
                                                              SearchNameViewModel searchNameViewModel) {
        return new AddUserPresenter(viewManagerModel, addUserViewModel, searchNameViewModel);
    }

    private UserFactoryInterface createUserFactoryInterface() {
        return new UserFactory();
    }

    private Accounts createDataAccessObject() {
        return new Accounts();
    }

    private AddUserViewModel createAddUserViewModel() {
        return new AddUserViewModel();
    }

    private ViewManagerModel createViewManagerModel() {
        return new ViewManagerModel();
    }

    private SearchNameViewModel createSearchNameViewModel() {
        return new SearchNameViewModel();
    }

    @Test
    public void testAddUserSuccess() {
        // Arrange
        Accounts dataAccessObject = createDataAccessObject();
        AddUserViewModel addUserViewModel = createAddUserViewModel();
        SearchNameViewModel searchNameViewModel = createSearchNameViewModel();
        ViewManagerModel viewManagerModel = createViewManagerModel();

        AddUserOutputBoundary addUserOutputBoundary = createAddUserOutputBoundary(viewManagerModel, addUserViewModel, searchNameViewModel);
        UserFactoryInterface userFactoryInterface = createUserFactoryInterface();

        AddUserInteractor interactor = createAddUserInteractor(dataAccessObject, addUserOutputBoundary, userFactoryInterface);

        // Act
        AddUserInputData inputData = new AddUserInputData("New Business", "newbusiness", "password");
        interactor.execute(inputData);

        // Assert
        AddUserState state = addUserViewModel.getState();
        assertNull(state.getUsernameError()); // No error is expected for a successful case
        assertFalse(addUserViewModel.getState().getPasswordError(), popUpDiscovered);
        assertFalse(addUserViewModel.getState().getNameError(), popUpDiscovered);
        assertFalse(addUserViewModel.getState().getUsernameError(), popUpDiscovered);

    }

    @Test
    public void testAddUserDuplicateUsername() throws InterruptedException {
        // Arrange
        Accounts dataAccessObject = createDataAccessObject();
        AddUserViewModel addUserViewModel = createAddUserViewModel();
        SearchNameViewModel searchNameViewModel = createSearchNameViewModel();
        ViewManagerModel viewManagerModel = createViewManagerModel();

        AddUserOutputBoundary addUserOutputBoundary = createAddUserOutputBoundary(viewManagerModel, addUserViewModel, searchNameViewModel);
        UserFactoryInterface userFactoryInterface = createUserFactoryInterface();

        AddUserInteractor interactor = createAddUserInteractor(dataAccessObject, addUserOutputBoundary, userFactoryInterface);

        // Add a business with the same username first
        dataAccessObject.saveUser(new User("New Business", "newbusiness", "password"));

        AddUserInputData inputData = new AddUserInputData("New Business", "newbusiness", "password");
        interactor.execute(inputData);

        Timer closeTimer = new Timer(2000, e -> {
            // Perform assertions on the EDT
            assertTrue(popUpDiscovered);
            assertEquals("User already exists.", message);
        });

        closeTimer.setRepeats(false);
        closeTimer.start();

        // Wait for the timer to dispose of the popup
        Thread.sleep(3000); // Adjust the sleep duration as needed
    }

    @Test
    public void testAddUserEmptyUsername() throws InterruptedException {
        // Arrange
        Accounts dataAccessObject = createDataAccessObject();
        AddUserViewModel addUserViewModel = createAddUserViewModel();
        SearchNameViewModel searchNameViewModel = createSearchNameViewModel();
        ViewManagerModel viewManagerModel = createViewManagerModel();

        AddUserOutputBoundary addUserOutputBoundary = createAddUserOutputBoundary(viewManagerModel, addUserViewModel, searchNameViewModel);
        UserFactoryInterface userFactoryInterface = createUserFactoryInterface();

        AddUserInteractor interactor = createAddUserInteractor(dataAccessObject, addUserOutputBoundary, userFactoryInterface);

        // Input data with an empty username
        AddUserInputData inputData = new AddUserInputData("New Business", "", "password");

        // Act
        interactor.execute(inputData);
        Timer closeTimer = new Timer(2000, e -> {
            // Perform assertions on the EDT
            assertTrue(popUpDiscovered);
            assertEquals("Please fill out all fields.", message);
        });

        closeTimer.setRepeats(false);
        closeTimer.start();

        // Wait for the timer to dispose of the popup
        Thread.sleep(3000); // Adjust the sleep duration as needed
        System.out.println("Expected: " + "Please fill out all fields.");
        System.out.println("Actual  : " + message);
    }

    @Test
    public void testAddUserEmptyName() throws InterruptedException {
        // Arrange
        Accounts dataAccessObject = createDataAccessObject();
        AddUserViewModel addUserViewModel = createAddUserViewModel();
        SearchNameViewModel searchNameViewModel = createSearchNameViewModel();
        ViewManagerModel viewManagerModel = createViewManagerModel();

        AddUserOutputBoundary addUserOutputBoundary = createAddUserOutputBoundary(viewManagerModel, addUserViewModel, searchNameViewModel);
        UserFactoryInterface userFactoryInterface = createUserFactoryInterface();

        AddUserInteractor interactor = createAddUserInteractor(dataAccessObject, addUserOutputBoundary, userFactoryInterface);

        // Input data with an empty username
        AddUserInputData inputData = new AddUserInputData("", "newbusiness", "password");

        // Act
        interactor.execute(inputData);
        Timer closeTimer = new Timer(2000, e -> {
            // Perform assertions on the EDT
            assertTrue(popUpDiscovered);
            assertEquals("Please fill out all fields.", message);
        });

        closeTimer.setRepeats(false);
        closeTimer.start();

        // Wait for the timer to dispose of the popup
        Thread.sleep(3000); // Adjust the sleep duration as needed
        System.out.println("Expected: " + "Please fill out all fields.");
        System.out.println("Actual  : " + message);
    }

    @Test
    public void testAddUserEmptyPassword() throws InterruptedException {
        // Arrange
        Accounts dataAccessObject = createDataAccessObject();
        AddUserViewModel addUserViewModel = createAddUserViewModel();
        SearchNameViewModel searchNameViewModel = createSearchNameViewModel();
        ViewManagerModel viewManagerModel = createViewManagerModel();

        AddUserOutputBoundary addUserOutputBoundary = createAddUserOutputBoundary(viewManagerModel, addUserViewModel, searchNameViewModel);
        UserFactoryInterface userFactoryInterface = createUserFactoryInterface();

        AddUserInteractor interactor = createAddUserInteractor(dataAccessObject, addUserOutputBoundary, userFactoryInterface);

        // Input data with an empty username
        AddUserInputData inputData = new AddUserInputData("New Business", "newbusiness", "");

        // Act
        interactor.execute(inputData);
        Timer closeTimer = new Timer(2000, e -> {
            // Perform assertions on the EDT
            assertTrue(popUpDiscovered);
            assertEquals("Please fill out all fields.", message);
        });

        closeTimer.setRepeats(false);
        closeTimer.start();

        // Wait for the timer to dispose of the popup
        Thread.sleep(3000); // Adjust the sleep duration as needed
        System.out.println("Expected: " + "Please fill out all fields.");
        System.out.println("Actual  : " + message);
    }

}