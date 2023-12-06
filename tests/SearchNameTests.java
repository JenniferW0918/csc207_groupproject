import app.Main;
import entity.Business;
import use_case.search_name.*;
import interface_adapter.search_name.*;
//import view.LabelTextPanel;
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
import java.util.Objects;

/*Things to test.
 * - Buttons are present, searchName, newSearch  (DONE)
 * - View changes to searchedNameView when searchName button is pressed in searchNameView (DONE)
 * - View changes to searchNameView when newSearch button is pressed in searchedNameView (DONE)
 * - SearchNameView has a text field for search results (DONE)
 * - Errors pop up when search term is empty or location is empty or arguments are wrong. JDialog is displayed (DONE)
 */

/** Tests for SearchName use case, SearchedName, SearchNameResults, Business*/
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
        assertNotNull(app); // found the window?

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

        assertNotNull(app); // found the window?

        Component root = app.getComponent(0);
        Component cp = ((JRootPane) root).getContentPane();

        JPanel jp = (JPanel) cp;

        JPanel jp2 = (JPanel) jp.getComponent(0);

        return (SearchedNameView) jp2.getComponent(3);
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

        JPanel buttons = (JPanel) sv2.getComponent(4);

        return (JButton) buttons.getComponent(0); // this should be the newSearch button
    }


    private JButton getLogoutSearchedButton() {
        SearchedNameView sv2 = getSearchedNameView();

        JPanel buttons = (JPanel) sv2.getComponent(4);

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


    @org.junit.Test
    public void testViewChangeOnSearch () {
        makeSearchUI(new char[]{'P', 'i', 'z', 'z', 'a'}, new char[] {'T', 'o', 'r', 'o', 'n', 't', 'o'});
        JButton button = getSearchButton();
        button.doClick();

        assert (viewManagerModel.getActiveView().equals("searched name"));
        SearchedNameView sv2 = getSearchedNameView();
        JScrollPane scrollPane = (JScrollPane) sv2.getComponent(1);
        JTextArea searchResultsArea = (JTextArea) scrollPane.getViewport().getView();
        assert(searchResultsArea.getText().contains("Pizza"));
        assert(searchResultsArea.getText().contains("Toronto"));
    }

    @org.junit.Test
    public void errorOnEmptyTerm() {
        makeSearchUI(new char[] {}, new char[]{'T', 'o', 'r', 'o', 'n', 't', 'o'});
        JButton button = getSearchButton();

        createCloseTimer().start();

        button.doClick();

        assert (popUpDiscovered);
        assert (message.equals("Please enter a term"));

    }

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

    @org.junit.Test
    public void testViewChangeSearchNameButton() {
        Main.main(null);
        makeSearchUI(new char[] {'P', 'i', 'z', 'z', 'a'}, new char[] {'T', 'o', 'r', 'o', 'n', 't', 'o'});
        JButton b = getSearchButton();
        b.doClick();
        assert(viewManagerModel.getActiveView().equals("searched name"));
    }

    @org.junit.Test
    public void testViewChangeNewSearchButton() {
        Main.main(null);
        viewManagerModel.setActiveView("searched name");
        viewManagerModel.firePropertyChanged();

        JButton b = getNewSearchButton();
        b.doClick();

        assert(viewManagerModel.getActiveView().equals("search name"));
    }
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

    @org.junit.Test
    public void testSearchNameButtonPresent() {
        Main.main(null);
        JButton button = getSearchButton();
        assert(button.getText().equals("Search Name"));
    }

    @org.junit.Test
    public void testNewSearchButtonPresent() {
        Main.main(null);
        JButton button = getNewSearchButton();
        assert(button.getText().equals("New Search"));
    }

    @org.junit.Test


    public void testLogOutButtonPresentSearch(){
        Main.main(null);
        JButton button = getLogoutSearchButton();
        assert (button.getText().equals("Log Out"));
    }

    @org.junit.Test
    public void testLogOutButtonPresentSearched(){
        Main.main(null);
        JButton button = getLogoutSearchedButton();
        assert (button.getText().equals("Log Out"));
    }


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

    // Testing Businesses made for search reuslts nor business accounts.
    @org.junit.Test
    public void testBusiness(){
        Business business = new Business("Korean bbq", "Yonge Street", true);

        assertEquals(business.getName(), "Korean bbq");
        assertEquals(business.getAddress(), "Yonge Street");
        assertTrue(business.is_Closed());

        String businessStr = business.toString();
        assert(Objects.equals(businessStr, "Name: Korean bbq\nAddress: Yonge Street\nOpen: No\n"));

        Business business2 = new Business("Korean bbq", "Yonge Street", false);
        String businessStr2 = business2.toString();
        assert(Objects.equals(businessStr2, "Name: Korean bbq\nAddress: Yonge Street\nOpen: Yes\n"));
    }



}