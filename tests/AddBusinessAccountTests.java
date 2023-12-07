import data_access.Accounts;
import entity.BusinessAccount;
import entity.BusinessAccountFactory;
import entity.BusinessAccountFactoryInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_business.AddBusinessAccountPresenter;
import interface_adapter.add_business.AddBusinessAccountState;
import interface_adapter.add_business.AddBusinessAccountViewModel;
import interface_adapter.search_name.SearchNameViewModel;
import org.junit.Test;
import use_case.add_business.AddBusinessAccountInputData;
import use_case.add_business.AddBusinessAccountInteractor;
import use_case.add_business.AddBusinessAccountOutputBoundary;


import javax.swing.*;

import static org.junit.Assert.*;

public class AddBusinessAccountTests {

    static String message = "";
    static boolean popUpDiscovered = false;

    private AddBusinessAccountInteractor createAddBusinessAccountInteractor(Accounts dataAccessObject,
                                                                            AddBusinessAccountOutputBoundary addBusinessOutputBoundary,
                                                                            BusinessAccountFactoryInterface businessAccountFactoryInterface) {
        return new AddBusinessAccountInteractor(dataAccessObject, addBusinessOutputBoundary, businessAccountFactoryInterface);
    }

    private AddBusinessAccountOutputBoundary createAddBusinessAccountOutputBoundary(ViewManagerModel viewManagerModel,
                                                                                    AddBusinessAccountViewModel addBusinessViewModel,
                                                                                    SearchNameViewModel searchNameViewModel) {
        return new AddBusinessAccountPresenter(viewManagerModel, addBusinessViewModel, searchNameViewModel);
    }

    private BusinessAccountFactoryInterface createBusinessAccountFactoryInterface() {
        return new BusinessAccountFactory();
    }

    private Accounts createDataAccessObject() {
        return new Accounts();
    }

    private AddBusinessAccountViewModel createAddBusinessAccountViewModel() {
        return new AddBusinessAccountViewModel();
    }

    private ViewManagerModel createViewManagerModel() {
        return new ViewManagerModel();
    }

    private SearchNameViewModel createSearchNameViewModel() {
        return new SearchNameViewModel();
    }

    @Test
    public void testAddBusinessAccountSuccess() {
        // Arrange
        Accounts dataAccessObject = createDataAccessObject();
        AddBusinessAccountViewModel addBusinessAccountViewModel = createAddBusinessAccountViewModel();
        SearchNameViewModel searchNameViewModel = createSearchNameViewModel();
        ViewManagerModel viewManagerModel = createViewManagerModel();

        AddBusinessAccountOutputBoundary addBusinessOutputBoundary = createAddBusinessAccountOutputBoundary(viewManagerModel, addBusinessAccountViewModel, searchNameViewModel);
        BusinessAccountFactoryInterface businessAccountFactoryInterface = createBusinessAccountFactoryInterface();

        AddBusinessAccountInteractor interactor = createAddBusinessAccountInteractor(dataAccessObject, addBusinessOutputBoundary, businessAccountFactoryInterface);

        // Act
        AddBusinessAccountInputData inputData = new AddBusinessAccountInputData("newbusiness", "New Business", "password", "123 Main St", "Restaurant");
        interactor.execute(inputData);

        // Assert
        AddBusinessAccountState state = addBusinessAccountViewModel.getState();
        assertNull(state.getUsernameError()); // No error is expected for a successful case
        assertFalse(addBusinessAccountViewModel.getState().getCategoryError(), popUpDiscovered);
        assertFalse(addBusinessAccountViewModel.getState().getAddressError(), popUpDiscovered);
        assertFalse(addBusinessAccountViewModel.getState().getPasswordError(), popUpDiscovered);
        assertFalse(addBusinessAccountViewModel.getState().getNameError(), popUpDiscovered);
        assertFalse(addBusinessAccountViewModel.getState().getUsernameError(), popUpDiscovered);

    }

    @Test
    public void testAddBusinessAccountDuplicateUsername() throws InterruptedException {
        // Arrange
        Accounts dataAccessObject = createDataAccessObject();
        AddBusinessAccountViewModel addBusinessAccountViewModel = createAddBusinessAccountViewModel();
        SearchNameViewModel searchNameViewModel = createSearchNameViewModel();
        ViewManagerModel viewManagerModel = createViewManagerModel();

        AddBusinessAccountOutputBoundary addBusinessOutputBoundary = createAddBusinessAccountOutputBoundary(viewManagerModel, addBusinessAccountViewModel, searchNameViewModel);
        BusinessAccountFactoryInterface businessAccountFactoryInterface = createBusinessAccountFactoryInterface();

        AddBusinessAccountInteractor interactor = createAddBusinessAccountInteractor(dataAccessObject, addBusinessOutputBoundary, businessAccountFactoryInterface);

        // Add a business with the same username first
        dataAccessObject.saveBusiness(new BusinessAccount("existingbusiness", "Existing Business", "password", "456 Main St", "Retail"));

        AddBusinessAccountInputData inputData = new AddBusinessAccountInputData("existingbusiness", "New Business", "password", "123 Main St", "Restaurant");
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
    public void testAddBusinessAccountEmptyUsername() {
        // Arrange
        Accounts dataAccessObject = createDataAccessObject();
        AddBusinessAccountViewModel addBusinessAccountViewModel = createAddBusinessAccountViewModel();
        SearchNameViewModel searchNameViewModel = createSearchNameViewModel();
        ViewManagerModel viewManagerModel = createViewManagerModel();

        AddBusinessAccountOutputBoundary addBusinessOutputBoundary = createAddBusinessAccountOutputBoundary(viewManagerModel, addBusinessAccountViewModel, searchNameViewModel);
        BusinessAccountFactoryInterface businessAccountFactoryInterface = createBusinessAccountFactoryInterface();

        AddBusinessAccountInteractor interactor = createAddBusinessAccountInteractor(dataAccessObject, addBusinessOutputBoundary, businessAccountFactoryInterface);

        // Input data with an empty username
        AddBusinessAccountInputData inputData = new AddBusinessAccountInputData("", "New Business", "password", "123 Main St", "Restaurant");

        // Act
        interactor.execute(inputData);

        // Assert
        // Ensure that the error message is displayed
        assertTrue(popUpDiscovered);
        assertEquals("Please enter a business username", message);
    }

    @Test
    public void testAddBusinessAccountEmptyName() {
        // Arrange
        Accounts dataAccessObject = createDataAccessObject();
        AddBusinessAccountViewModel addBusinessAccountViewModel = createAddBusinessAccountViewModel();
        SearchNameViewModel searchNameViewModel = createSearchNameViewModel();
        ViewManagerModel viewManagerModel = createViewManagerModel();

        AddBusinessAccountOutputBoundary addBusinessOutputBoundary = createAddBusinessAccountOutputBoundary(viewManagerModel, addBusinessAccountViewModel, searchNameViewModel);
        BusinessAccountFactoryInterface businessAccountFactoryInterface = createBusinessAccountFactoryInterface();

        AddBusinessAccountInteractor interactor = createAddBusinessAccountInteractor(dataAccessObject, addBusinessOutputBoundary, businessAccountFactoryInterface);


        // Input data with an empty name
        AddBusinessAccountInputData inputData = new AddBusinessAccountInputData("newbusiness", "", "password", "123 Main St", "Restaurant");

        // Act
        interactor.execute(inputData);

        // Assert
        // Ensure that the error message is displayed
        assertTrue(popUpDiscovered);
        assertEquals("Please enter a business name", message);
    }

    @Test
    public void testAddBusinessAccountEmptyPassword() {
        // Arrange
        Accounts dataAccessObject = createDataAccessObject();
        AddBusinessAccountViewModel addBusinessAccountViewModel = createAddBusinessAccountViewModel();
        SearchNameViewModel searchNameViewModel = createSearchNameViewModel();
        ViewManagerModel viewManagerModel = createViewManagerModel();

        AddBusinessAccountOutputBoundary addBusinessOutputBoundary = createAddBusinessAccountOutputBoundary(viewManagerModel, addBusinessAccountViewModel, searchNameViewModel);
        BusinessAccountFactoryInterface businessAccountFactoryInterface = createBusinessAccountFactoryInterface();

        AddBusinessAccountInteractor interactor = createAddBusinessAccountInteractor(dataAccessObject, addBusinessOutputBoundary, businessAccountFactoryInterface);


        // Input data with an empty password
        AddBusinessAccountInputData inputData = new AddBusinessAccountInputData("newbusiness", "New Business", "", "123 Main St", "Restaurant");

        // Act
        interactor.execute(inputData);

        // Assert
        // Ensure that the error message is displayed
        assertTrue(popUpDiscovered);
        assertEquals("Please enter a business password", message);
    }

    @Test
    public void testAddBusinessAccountEmptyAddress() throws InterruptedException {
        // Arrange
        Accounts dataAccessObject = createDataAccessObject();
        AddBusinessAccountViewModel addBusinessAccountViewModel = createAddBusinessAccountViewModel();
        SearchNameViewModel searchNameViewModel = createSearchNameViewModel();
        ViewManagerModel viewManagerModel = createViewManagerModel();

        AddBusinessAccountOutputBoundary addBusinessOutputBoundary = createAddBusinessAccountOutputBoundary(viewManagerModel, addBusinessAccountViewModel, searchNameViewModel);
        BusinessAccountFactoryInterface businessAccountFactoryInterface = createBusinessAccountFactoryInterface();

        AddBusinessAccountInteractor interactor = createAddBusinessAccountInteractor(dataAccessObject, addBusinessOutputBoundary, businessAccountFactoryInterface);


        // Input data with an empty address
        AddBusinessAccountInputData inputData = new AddBusinessAccountInputData("newbusiness", "New Business", "password", "", "Restaurant");

        // Act
        interactor.execute(inputData);

        // Add a delay to allow the UI to update
        Thread.sleep(1000);

        // Assert
        // Ensure that the error message is displayed
        assertTrue(popUpDiscovered);
        assertEquals("Please enter a business address", message);
    }

    @Test
    public void testAddBusinessAccountEmptyCategory() {
        // Arrange
        Accounts dataAccessObject = createDataAccessObject();
        AddBusinessAccountViewModel addBusinessAccountViewModel = createAddBusinessAccountViewModel();
        SearchNameViewModel searchNameViewModel = createSearchNameViewModel();
        ViewManagerModel viewManagerModel = createViewManagerModel();

        AddBusinessAccountOutputBoundary addBusinessOutputBoundary = createAddBusinessAccountOutputBoundary(viewManagerModel, addBusinessAccountViewModel, searchNameViewModel);
        BusinessAccountFactoryInterface businessAccountFactoryInterface = createBusinessAccountFactoryInterface();

        AddBusinessAccountInteractor interactor = createAddBusinessAccountInteractor(dataAccessObject, addBusinessOutputBoundary, businessAccountFactoryInterface);

        // Input data with an empty category
        AddBusinessAccountInputData inputData = new AddBusinessAccountInputData("newbusiness", "New Business", "password", "123 Main St", "");

        // Act
        interactor.execute(inputData);

        // Assert
        // Ensure that the error message is displayed
        assertTrue(popUpDiscovered);
        assertEquals("Please enter a business category", message);
    }

}
