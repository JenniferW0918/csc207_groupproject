package view;

import interface_adapter.add_business.AddBusinessAccountController;
import interface_adapter.add_business.AddBusinessAccountState;
import interface_adapter.add_business.AddBusinessAccountViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AddBusinessAccountView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "sign up";

    private final AddBusinessAccountViewModel addBusinessAccountViewModel;
    private final JTextField usernameInputField = new JTextField(15);
    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JPasswordField repeatPasswordInputField = new JPasswordField(15);
    private final AddBusinessAccountController addBusinessAccountController;


    private final JButton addBusinessAccount;


    public AddBusinessAccountView(AddBusinessAccountController controller, AddBusinessAccountViewModel signupViewModel){

        this.addBusinessAccountController = controller;
        this.addBusinessAccountViewModel = signupViewModel;
        signupViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(AddBusinessAccountViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel(AddBusinessAccountViewModel.USERNAME_LABEL), usernameInputField);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel(AddBusinessAccountViewModel.PASSWORD_LABEL), passwordInputField);

        JPanel buttons = new JPanel();
        addBusinessAccount = new JButton(AddBusinessAccountViewModel.SIGNUP_BUTTON_LABEL);
        buttons.add(addBusinessAccount);
        cancel = new JButton(AddBusinessAccountViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);

        addBusinessAccount.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(addBusinessAccount)) {
                            AddBusinessAccountState currentState = addBusinessAccountViewModel.getState();

                            addBusinessAccountController.execute(
                                    currentState.getUsername(),
                                    currentState.getName(),
                                    currentState.getPassword(),
                                    currentState.getAddress(),
                                    currentState.getCategories()
                            );
                        }
                    }
                }
        );


        cancel.addActionListener(this);

        // This makes a new KeyListener implementing class, instantiates it, and
        // makes it listen to keystrokes in the usernameInputField.
        //
        // Notice how it has access to instance variables in the enclosing class!
        usernameInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        AddBusinessAccountState currentState = addBusinessAccountViewModel.getState();
                        String text = usernameInputField.getText() + e.getKeyChar();
                        currentState.setUsername(text);
                        addBusinessAccountViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        passwordInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        AddBusinessAccountState currentState = addBusinessAccountViewModel.getState();
                        currentState.setPassword(passwordInputField.getText() + e.getKeyChar());
                        addBusinessAccountViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        repeatPasswordInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        AddBusinessAccountState currentState = addBusinessAccountViewModel.getState();
                        currentState.setRepeatPassword(repeatPasswordInputField.getText() + e.getKeyChar());
                        addBusinessAccountViewModel.setState(currentState); // Hmm, is this necessary?
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getSource().equals(addBusinessAccountViewModel)) {
            AddBusinessAccountState state = (AddBusinessAccountState) evt.getNewValue();
            if (state.getUsernameError() != null) {
                JOptionPane.showMessageDialog(this, state.getUsernameError());
            }
        } else if (evt.getSource().equals(clearViewModel)) {
            ClearState state = (ClearState) evt.getNewValue();
            if (state.getClearedUsernames() != null) {
                JOptionPane.showMessageDialog(this, state.getClearedUsernames());
            }

        }
    }}