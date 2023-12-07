import app.Main;
import entity.BusinessAccount;
import org.json.JSONObject;
import use_case.add_business.*;
import interface_adapter.add_business.*;
import view.BusinessInfoView;
import view.AddBusinessAccountView;

import static app.Main.*;
import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Objects;

/** Tests for AddBusiness use case, Business */
public class AddBusinessTests {
    static String message = "";
    static boolean popUpDiscovered = false;

    /* HELPERS */
    private void makeAddBusinessUI(String username, String name, String password, String address, String category) {
        Main.main(null);
        AddBusinessAccountView abav = getAddBusinessAccountView();

        Main.viewManagerModel.setActiveView(abav.viewName);
        Main.viewManagerModel.firePropertyChanged();

        JPanel jp1 = (JPanel) abav.getComponent(1); // username field panel
        JPanel jp2 = (JPanel) abav.getComponent(2); // name field panel
        JPanel jp3 = (JPanel) abav.getComponent(3); // password field panel
        JPanel jp4 = (JPanel) abav.getComponent(4); // address field panel
        JPanel jp5 = (JPanel) abav.getComponent(5); // category field panel

        JTextField usernameField = (JTextField) jp1.getComponent(1);
        JTextField nameField = (JTextField) jp2.getComponent(1);
        JTextField passwordField = (JTextField) jp3.getComponent(1);
        JTextField addressField = (JTextField) jp4.getComponent(1);
        JTextField categoryField = (JTextField) jp5.getComponent(1);

        // Set the username, name, password, address, and category input fields.

        // Type the business username into the username field
        for (char character : username.toCharArray()) {
            simulateKeyEvent(usernameField, character);
        }

        // Type the business name into the name field
        for (char character : name.toCharArray()) {
            simulateKeyEvent(nameField, character);
        }

        // Type the business password into the password field
        for (char character : password.toCharArray()) {
            simulateKeyEvent(passwordField, character);
        }

        // Type the business address into the address field
        for (char character : address.toCharArray()) {
            simulateKeyEvent(addressField, character);
        }

        // Type the business category into the category field
        for (char character : category.toCharArray()) {
            simulateKeyEvent(categoryField, character);
        }
    }

    private void simulateKeyEvent(JTextField textField, char character) {
        KeyEvent eventTyped = new KeyEvent(
                textField,
                KeyEvent.KEY_TYPED,
                System.currentTimeMillis(),
                0,
                KeyEvent.VK_UNDEFINED,
                character);

        textField.dispatchEvent(eventTyped);

        // Pause execution for a short duration
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Move to the right to avoid overwriting characters
        KeyEvent eventRight = new KeyEvent(
                textField,
                KeyEvent.KEY_PRESSED,
                System.currentTimeMillis(),
                0,
                KeyEvent.VK_RIGHT,
                KeyEvent.CHAR_UNDEFINED);

        textField.dispatchEvent(eventRight);
    }

    private AddBusinessAccountView getAddBusinessAccountView() {
        JFrame app = findMainFrame();
        assertNotNull(app);

        Component root = app.getComponent(0);
        Component cp = ((JRootPane) root).getContentPane();

        JPanel jp = (JPanel) cp;

        JPanel jp2 = (JPanel) jp.getComponent(0);

        return (AddBusinessAccountView) jp2.getComponent(1);
    }

    private JFrame findMainFrame() {
        JFrame app = null;
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }
        return app;
    }

    private JButton getAddBusinessAccountButton() {
        AddBusinessAccountView bv = getAddBusinessAccountView();
        JPanel buttons = (JPanel) bv.getComponent(4);
        return (JButton) buttons.getComponent(0); // this should be the Add Business button
    }

    private Timer createCloseTimer() {
        ActionListener close = e -> {
            Window[] windows = Window.getWindows();
            for (Window window : windows) {
                if (window instanceof JDialog) {
                    JDialog dialog = (JDialog) window;
                    if (dialog.isVisible()) {
                        String s = ((JOptionPane) ((BorderLayout) dialog.getRootPane()
                                .getContentPane().getLayout()).getLayoutComponent(BorderLayout.CENTER)).getMessage().toString();
                        System.out.println("message = " + s);

                        // store the information we got from the JDialog
                        AddBusinessTests.message = s;
                        AddBusinessTests.popUpDiscovered = true;

                        System.out.println("disposing of..." + window.getClass());
                        window.dispose();
                    }
                }
            }
        };

        Timer t = new Timer(1000, close);
        t.setRepeats(false);
        return t;
    }

    /* TESTS */
    @org.junit.Test
    public void testViewChangeOnAddBusinessAccount() {
        makeAddBusinessUI("New Business", "123 Main St", "Restaurant");
        JButton button = getAddBusinessAccountButton();
        button.doClick();

        assert (viewManagerModel.getActiveView().equals("business info"));
        BusinessInfoView bv = getBusinessInfoView();
        assert (bv.isVisible());
        assert (bv.isShowing());
    }

    @org.junit.Test
    public void errorOnEmptyName() {
        makeAddBusinessUI("", "123 Main St", "Restaurant");
        JButton button = getAddBusinessAccountButton();

        createCloseTimer().start();

        button.doClick();

        assert (popUpDiscovered);
        assert (message.equals("Please enter a business name"));
    }

    @org.junit.Test
    public void errorOnEmptyAddress() {
        makeAddBusinessUI("New Business", "", "Restaurant");
        JButton button = getAddBusinessAccountButton();

        createCloseTimer().start();

        button.doClick();

        assert (popUpDiscovered);
        assert (message.equals("Please enter a business address"));
    }

    @org.junit.Test
    public void errorOnEmptyCategory() {
        makeAddBusinessUI("New Business", "123 Main St", "");
        JButton button = getAddBusinessAccountButton();

        createCloseTimer().start();

        button.doClick();

        assert (popUpDiscovered);
        assert (message.equals("Please enter a business category"));
    }

    @org.junit.Test
    public void testViewChangeLogoutButton() {
        Main.main(null);
        makeAddBusinessUI("New Business", "123 Main St", "Restaurant");
        JButton button = getLogoutAddButton();
        button.doClick();

        assert (viewManagerModel.getActiveView().equals("login"));
    }

    @org.junit.Test
    public void testAddBusinessDataAccessObject() {
        AddBusinessAccountDataAccessObject addBusinessDataAccessObject = new AddBusinessDataAccessObject();
        AddBusinessInputData inputData = new AddBusinessInputData("New Business", "123 Main St", "Restaurant");

        AddBusinessResult result = addBusinessDataAccessObject.addBusiness(inputData);

        assertNotNull(result);
        assertNotNull(result.getBusiness());
        assertEquals(result.getBusiness().getName(), "New Business");
        assertEquals(result.getBusiness().getAddress(), "123 Main St");
        assertEquals(result.getBusiness().getCategory(), "Restaurant");
    }

    @org.junit.Test
    public void testBusinessInfoViewModel() {
        BusinessAccountViewModel businessInfoViewModel = new
