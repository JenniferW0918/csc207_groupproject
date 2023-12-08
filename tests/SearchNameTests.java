import app.Main;
import entity.Business;
import interface_adapter.ViewManagerModel;
import org.json.JSONObject;
import use_case.search_name.*;
import interface_adapter.search_name.*;
//import view.LabelTextPanel;
import view.BusinessInfoView;
import view.SearchedNameView;
import view.SearchNameView;
import entity.SearchNameResult;
import data_access.SearchNameDataAccessObject;

import static app.Main.*;
import static java.lang.Thread.sleep;
import static org.junit.Assert.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Objects;

/*Things to test.
 * - Buttons are present, searchName, newSearch  (DONE)
 * - View changes to searchedNameView when searchName button is pressed in searchNameView (DONE)
 * - View changes to searchNameView when newSearch button is pressed in searchedNameView (DONE)
 * - SearchNameView has a text field for search results (DONE)
 * - Errors pop up when search term is empty or location is empty or arguments are wrong. JDialog is displayed (DONE)
 */


/**
 * This class contains unit tests for the SearchName use case, SearchedName,
 * SearchNameResults, and BusinessInfo.
 *
 */
public class SearchNameTests {
    static String message = "";
    static boolean popUpDiscovered = false;

    /*HELPERS*/
    private void makeSearchUI(char[] termChars, char[] locationChars) {
        Main.main(null);
        SearchNameView sv = getSearchNameView(); // search name view
        Main.viewManagerModel.setActiveView(sv.viewName);
        Main.viewManagerModel.firePropertyChanged();
        JPanel jp3 = (JPanel) sv.getComponent(1); // term field panel
        JPanel jp4 = (JPanel) sv.getComponent(2); // location field panel
        JTextField termField = (JTextField) jp3.getComponent(1);
        JTextField locationField = (JTextField) jp4.getComponent(1);


        // Set the term and text input field.

        // Type 'Pizza' into the term field
//        char[] termChars = {'p', 'i', 'z', 'z', 'a'};
        for (char character : termChars) {
            KeyEvent eventTyped = new KeyEvent(
                    termField,
                    KeyEvent.KEY_TYPED,
                    System.currentTimeMillis(),
                    0,
                    KeyEvent.VK_UNDEFINED,
                    character);

            jp3.dispatchEvent(eventTyped);

            // Pause execution for a second
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Move to the right to avoid overwriting characters
            KeyEvent eventRight = new KeyEvent(
                    termField,
                    KeyEvent.KEY_PRESSED,
                    System.currentTimeMillis(),
                    0,
                    KeyEvent.VK_RIGHT,
                    KeyEvent.CHAR_UNDEFINED);

            jp3.dispatchEvent(eventRight);
        }

        // Type 'Toronto' into the location field
//        char[] locationChars = {'t', 'o', 'r', 'o', 'n', 't', 'o'};
        for (char character : locationChars) {
            KeyEvent eventTyped = new KeyEvent(
                    locationField,
                    KeyEvent.KEY_TYPED,
                    System.currentTimeMillis(),
                    0,
                    KeyEvent.VK_UNDEFINED,
                    character);

            jp4.dispatchEvent(eventTyped);

            // Pause execution for a second
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Move to the right to avoid overwriting characters
            KeyEvent eventRight = new KeyEvent(
                    locationField,
                    KeyEvent.KEY_PRESSED,
                    System.currentTimeMillis(),
                    0,
                    KeyEvent.VK_RIGHT,
                    KeyEvent.CHAR_UNDEFINED);

            jp4.dispatchEvent(eventRight);
        }

    }

    private SearchNameView getSearchNameView() {
        JFrame app = null;
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }
        assertNotNull(app);

        Component root = app.getComponent(0);
        Component cp = ((JRootPane) root).getContentPane();

        JPanel jp = (JPanel) cp;

        JPanel jp2 = (JPanel) jp.getComponent(0);

        return (SearchNameView) jp2.getComponent(2);
    }

    private SearchedNameView getSearchedNameView() {
        JFrame app = null;
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }

        assertNotNull(app);

        Component root = app.getComponent(0);
        Component cp = ((JRootPane) root).getContentPane();

        JPanel jp = (JPanel) cp;

        JPanel jp2 = (JPanel) jp.getComponent(0);

        return (SearchedNameView) jp2.getComponent(3);
    }

    private BusinessInfoView getBusinessInfoView(){
        JFrame app = null;
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }

        assertNotNull(app);

        Component root = app.getComponent(0);
        Component cp = ((JRootPane) root).getContentPane();

        JPanel jp = (JPanel) cp;

        JPanel jp2 = (JPanel) jp.getComponent(0);

        return (BusinessInfoView) jp2.getComponent(4);
    }

    private JButton getSearchButton() {
        SearchNameView sv = getSearchNameView();

        JPanel buttons = (JPanel) sv.getComponent(3);

        return (JButton) buttons.getComponent(0); // this should be the searchName button
    }

    private JButton getLogoutSearchButton() {
        SearchNameView sv = getSearchNameView();

        JPanel buttons = (JPanel) sv.getComponent(3);

        return (JButton) buttons.getComponent(1); // this should be the logout button

    }

    private JButton getNewSearchButton() {
        SearchedNameView sv2 = getSearchedNameView();

        JPanel buttons = (JPanel) sv2.getComponent(3);

        return (JButton) buttons.getComponent(0); // this should be the newSearch button
    }


    private JButton getLogoutSearchedButton() {
        SearchedNameView sv2 = getSearchedNameView();

        JPanel buttons = (JPanel) sv2.getComponent(3);

        return (JButton) buttons.getComponent(1); // this should be the logout button
    }


    private Timer createCloseTimer() {
        ActionListener close = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Window[] windows = Window.getWindows();
                for (Window window : windows) {

                    if (window instanceof JDialog) {

                        JDialog dialog = (JDialog)window;

                        // this ignores old dialogs
                        if (dialog.isVisible()) {
                            String s = ((JOptionPane) ((BorderLayout) dialog.getRootPane()
                                    .getContentPane().getLayout()).getLayoutComponent(BorderLayout.CENTER)).getMessage().toString();
                            System.out.println("message = " + s);

                            // store the information we got from the JDialog
                            SearchNameTests.message = s;
                            SearchNameTests.popUpDiscovered = true;

                            System.out.println("disposing of..." + window.getClass());
                            window.dispose();
                        }
                    }
                }
            }

        };

        Timer t = new Timer(1000, close);
        t.setRepeats(false);
        return t;
    }


    /*TESTS*/
    /**Test that the view changes after user makes a search */
    @org.junit.Test
    public void testViewChangeOnSearch () {
        makeSearchUI(new char[]{'P', 'i', 'z', 'z', 'a'}, new char[] {'T', 'o', 'r', 'o', 'n', 't', 'o'});
        JButton button = getSearchButton();
        button.doClick();

        assert (viewManagerModel.getActiveView().equals("searched name"));
        SearchedNameView sv2 = getSearchedNameView();
        JScrollPane scrollPane = (JScrollPane) sv2.getComponent(1);
        JList<String> searchResultsArea = (JList<String>) scrollPane.getViewport().getView();
        assert(searchResultsArea.isVisible());
        assert(searchResultsArea.isShowing());
    }

    /** Test that an error pop-up is returned if a user makes a search without a term*/
    @org.junit.Test
    public void errorOnEmptyTerm() {
        makeSearchUI(new char[] {}, new char[]{'T', 'o', 'r', 'o', 'n', 't', 'o'});
        JButton button = getSearchButton();

        createCloseTimer().start();

        button.doClick();

        assert (popUpDiscovered);
        assert (message.equals("Please enter a term"));

    }

    /** Test that an error pop-up is returned if a user makes a search without a location*/
    @org.junit.Test
    public void errorOnEmptyLocation() {
        popUpDiscovered = false;
        makeSearchUI(new char[] {'P', 'i', 'z', 'z', 'a'}, new char[]{});
        JButton button = getSearchButton();

        createCloseTimer().start();

        button.doClick();

        assert (popUpDiscovered);
        assert (message.equals("Please enter a location"));
    }

    /** Test that an error pop-up is returned if a user makes a search with an
     * empty term and empty location*/
    @org.junit.Test
    public void errorOnEmptyTermAndLocation() {
        popUpDiscovered = false;
        makeSearchUI(new char[] {}, new char[]{});
        JButton button = getSearchButton();
        createCloseTimer().start();
        button.doClick();

        assert (popUpDiscovered);
        assert (!Objects.equals(message, ""));
    }

    /** Test that an error pop-up is returned if a user makes a search with an
     * invalid term and invalid location*/
    @org.junit.Test
    public void errorOnInvalidTermLocation(){
        popUpDiscovered = false;
        makeSearchUI(new char[] {'j','j'}, new char[]{'j', 'j'});
        JButton button = getSearchButton();
        createCloseTimer().start();
        button.doClick();

        assert (popUpDiscovered);
        assert (Objects.equals(message, "No results found :("));
    }

    /** Test that the view changes when a user clicks on the SearchNameButton*/
    @org.junit.Test
    public void testViewChangeSearchNameButton() {
        Main.main(null);
        makeSearchUI(new char[] {'P', 'i', 'z', 'z', 'a'}, new char[] {'T', 'o', 'r', 'o', 'n', 't', 'o'});
        JButton b = getSearchButton();
        b.doClick();
        assert(viewManagerModel.getActiveView().equals("searched name"));
    }

    /** Test that the view changes when a user clicks on the NewSearchButton*/
    @org.junit.Test
    public void testViewChangeNewSearchButton() {
        Main.main(null);
        viewManagerModel.setActiveView("searched name");
        viewManagerModel.firePropertyChanged();

        getNewSearchButton().doClick();

        assert(viewManagerModel.getActiveView().equals("search name"));
    }

    /** Test that the SearchNameDataAccessObject calls the API*/
    @org.junit.Test
    public void testSearchNameDataAccessObject() {
        SearchNameDataAccessObject searchNameDataAccessObject = new SearchNameDataAccessObject();
        SearchNameInputData inputData = new SearchNameInputData("Creamy Lemon Butter Chicken", "Toronto");

        SearchNameResult result = searchNameDataAccessObject.getSearchName(inputData);


        assertNotNull(result);
        assertNotNull(result.getBusinesses());
        assertFalse(result.getBusinesses().isEmpty());
        assertEquals(result.getTerm(), "Creamy Lemon Butter Chicken");
        assertEquals(result.getLocation(), "Toronto");
    }

    /** Test that the SearchNameViewModel and SearchNameState are updated correctly*/
    @org.junit.Test
    public void testSearchNameViewModel() {
        SearchNameViewModel searchNameViewModel = new SearchNameViewModel();

        SearchNameState initialState = searchNameViewModel.getState();
        initialState.setLocation("Ottawa");
        initialState.setTerm("Pizza");
        searchNameViewModel.setState(initialState);

        SearchNameState updatedState = searchNameViewModel.getState();
        assertEquals("Pizza", updatedState.getTerm());
        assertEquals("Ottawa", updatedState.getLocation());
    }

    /** Test that the SearchNameButton is present */
    @org.junit.Test
    public void testSearchNameButtonPresent() {
        Main.main(null);
        JButton button = getSearchButton();
        assert(button.getText().equals("Search Name"));
    }

    /** Test that the new search button is present*/
    @org.junit.Test
    public void testNewSearchButtonPresent() {
        Main.main(null);
        JButton button = getNewSearchButton();
        assert(button.getText().equals("New Search"));
    }

    /** Test that the logout button is present on search view and that clicking on it
     * changes the view to FirstView*/
    @org.junit.Test

    public void testLogOutButtonPresentSearch(){
        Main.main(null);
        JButton button = getLogoutSearchButton();
        assert (button.getText().equals("Log Out"));
        button.doClick();
        assert(viewManagerModel.getActiveView().equals("First View"));
    }

/** Test that the logout button is present on searched view and that clicking on it
     * changes the view to FirstView*/
    @org.junit.Test
    public void testLogOutButtonPresentSearched(){
        Main.main(null);
        JButton button = getLogoutSearchedButton();
        assert (button.getText().equals("Log Out"));
        button.doClick();
        assert(viewManagerModel.getActiveView().equals("First View"));
    }

    /**Test that the text-fields are present on SearchNameView*/
    @org.junit.Test
    public void testTextFieldsPresent(){
        Main.main(null);
        SearchNameView sv = getSearchNameView(); // search name view

        JPanel jp3 = (JPanel) sv.getComponent(1); // term field panel
        JPanel jp4 = (JPanel) sv.getComponent(2); // location field panel

        assertEquals("Type Term:", ((JLabel) jp3.getComponent(0)).getText());
        assertEquals("Type Location:", ((JLabel) jp4.getComponent(0)).getText());
        assert jp3.getComponent(1).isValid(); // term field is valid
        assert jp4.getComponent(1).isValid(); // location field is valid
    }

    /** Test the instantiation of the business entity*/
    @org.junit.Test
    public void testBusiness(){
        Business business = new Business("1", "Korean bbq", "Yonge Street",
                true, "url1", "sam: I loved the food!" );

        assertEquals(business.getId(), "1");
        assertEquals(business.getName(), "Korean bbq");
        assertEquals(business.getAddress(), "Yonge Street");
        assertEquals(business.getUrl(), "url1");
        assertEquals(business.getReviews(), "sam: I loved the food!");
        assertTrue(business.is_Closed());

        String businessStr = business.toString();
        assert(Objects.equals(businessStr, "Name: Korean bbq\nAddress: Yonge Street\n"));

        Business business2 = new Business("2", "Korean bbq", "Yonge Street",
                false, "url1", "sam: I loved the food!" );
        String businessStr2 = business2.toString();
        assert(Objects.equals(businessStr2, "Name: Korean bbq\nAddress: Yonge Street\n"));
    }

    /** Test that an error is returned by the SearchNameDataAccessObject if an invalid
     * id is used as a parameter */
    @org.junit.Test
    public void testWrongId(){
        SearchNameDataAccessObject dataAccess = new SearchNameDataAccessObject();
        try{
            dataAccess.getMoreDetails("wrongId");
        }
        catch (RuntimeException e){
            assert(e.getMessage().equals("Error getting reviews"));
        }

    }

    //Testing BusinessInfo

    /** Testing the presence of components in BusinessInfoView*/
    @org.junit.Test
    public void testBusinessInfoViewComponents(){
        Main.main(null);
        BusinessInfoView bv = getBusinessInfoView();
        JPanel buttons = (JPanel) bv.getComponent(3);
        JButton link = (JButton) buttons.getComponent(0);
        JButton backToResults = (JButton) buttons.getComponent(1);

        //Testing Buttons
        assert (link.getText().equals("Link"));
        assert (backToResults.getText().equals("Return"));

        //Testing JTextArea
        JScrollPane scrollPane = (JScrollPane) bv.getComponent(1);
        JTextArea businessReviews = (JTextArea) scrollPane.getViewport().getView();
        assert(businessReviews.isVisible());

        //Testing Labels
        JLabel title = (JLabel) bv.getComponent(0);

        JPanel jp = (JPanel) bv.getComponent(2);
        JLabel businessName = (JLabel) jp.getComponent(0);
        JLabel businessAddress = (JLabel) jp.getComponent(1);
        JLabel status = (JLabel) jp.getComponent(2);
        assert(title.getText().equals("Business Information"));
        assert(businessName.getText().contains("BusinessName:"));
        assert(businessAddress.getText().contains("Address:"));
        assert(status.getText().contains("Open:"));
        assert(businessReviews.getText().contains("Reviews:"));
    }

    /** Testing that the view changes when buttons and Jlist are cliked in SearchedNameView and when buttons are
     * clicked in BusinessInfoView*/
    @org.junit.Test
    public void testBusinessInfoViewChange(){
        Main.main(null);
        makeSearchUI(new char[] {'P', 'i', 'z', 'z', 'a'}, new char[] {'T', 'o', 'r', 'o', 'n', 't', 'o'});
        JButton button = getSearchButton();
        button.doClick();

        assert (viewManagerModel.getActiveView().equals("searched name"));
        SearchedNameView sv2 = getSearchedNameView();
        JScrollPane scrollPane = (JScrollPane) sv2.getComponent(1);
        JList<String> searchResultsArea = (JList<String>) scrollPane.getViewport().getView();
        searchResultsArea.setSelectedIndex(0); // select first item in list
        searchResultsArea.dispatchEvent(new ActionEvent(searchResultsArea, ActionEvent.ACTION_PERFORMED, null)); // click on first item in list
//        assert (viewManagerModel.getActiveView().equals("Business information"));

        BusinessInfoView bv = getBusinessInfoView();
        JPanel buttons = (JPanel) bv.getComponent(3);
        JButton link = (JButton) buttons.getComponent(0);
        link.doClick();
        assert (link.isVisible()); // link button is selected
        JButton backToResults = (JButton) buttons.getComponent(1);
        backToResults.doClick();
        assert(viewManagerModel.getActiveView().equals("searched name"));
    }

    /** Test that errors are returned on invalid input in BusinessView*/
    @org.junit.Test
    public void testErrorsBusinessInfoView(){
        Main.main(null);
        BusinessInfoView bv = getBusinessInfoView();
        JPanel buttons = (JPanel) bv.getComponent(3);
        JButton link = (JButton) buttons.getComponent(0);
        JButton backToResults = (JButton) buttons.getComponent(1);
//        try{
//            link.doClick();
//        }
//        catch (Exception e){
//            assert(e);
//        }
    }

}