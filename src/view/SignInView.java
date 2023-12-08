package view;

import interface_adapter.signin.SignInController;
import interface_adapter.signin.SignInState;
import interface_adapter.signin.SignInViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static app.Main.viewManagerModel;

/**
 * The SignInView class represents the UI for the signin use case.
 * It extends JPanel and implements the ActionListener, PropertyChangeListener interfaces
 * The view has input fields for a user's username and associated password and a signin button
 * The class is fundamentally responsible for signing a user in and navigating them to the search name feature of the program
 *
 * @author audrey
 * @version 1.0
 */
public class SignInView extends JPanel implements ActionListener, PropertyChangeListener { // attempting push
    /** The name of the view. */
    public final String viewName = "signin";

    /** The view model for handling sign-in view information. */
    private final SignInViewModel signInViewModel;

    /** Input field for entering the username. */
    final JTextField usernameInputField = new JTextField(15);

    /** Error field for displaying username-related errors. */
    private final JLabel usernameErrorField = new JLabel();

    /** Input field for entering the password. */
    final JPasswordField passwordInputField = new JPasswordField(15);

    /** Error field for displaying password-related errors. */
    private final JLabel passwordErrorField = new JLabel();

    /** Button for initiating the sign-in process. */
    final JButton signIn;

    /** Button for navigating back to the previous view. */
    private final JButton back;

    /** Controller for handling sign-in actions. */
    private final SignInController signInController;

    /**
     * Constructs an instance of SignInView.
     *
     * @param signInViewModel      The view model for handling sign-in view information.
     * @param controller           The controller for handling sign-in actions.
     */
    public SignInView(SignInViewModel signInViewModel, SignInController controller) {

        this.signInController = controller;
        this.signInViewModel = signInViewModel;
        this.signInViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Sign in Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Username"), usernameInputField);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Password"), passwordInputField);

        JPanel buttons = new JPanel();
        signIn = new JButton(signInViewModel.SIGNIN_BUTTON_LABEL);
        buttons.add(signIn);
        back = new JButton(signInViewModel.BACK_BUTTON_LABEL);
        buttons.add(back);

        signIn.addActionListener(                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(signIn)) {
                            SignInState currentState = signInViewModel.getState();

                            signInController.execute(
                                    currentState.getUsername(),
                                    currentState.getPassword()
                            );

                            usernameInputField.setText("");
                            passwordInputField.setText("");
                        }
                    }
                }
        );

        back.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        SignInState currentState = signInViewModel.getState();

                        usernameInputField.setText("");
                        passwordInputField.setText("");
                        currentState.setUsername("");
                        currentState.setPassword("");

                        viewManagerModel.setActiveView("First View");
                        viewManagerModel.firePropertyChanged();
                    }
                }
        );

        usernameInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                SignInState currentState = signInViewModel.getState();
                currentState.setUsername(usernameInputField.getText() + e.getKeyChar());
                signInViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        passwordInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignInState currentState = signInViewModel.getState();
                        currentState.setPassword(passwordInputField.getText() + e.getKeyChar());
                        signInViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        this.add(title);
        this.add(usernameInfo);
        this.add(usernameErrorField);
        this.add(passwordInfo);
        this.add(passwordErrorField);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {}

    @Override
    public void propertyChange(PropertyChangeEvent evt) {}

}