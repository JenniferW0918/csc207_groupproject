package view;

import interface_adapter.add_user.AddUserController;
import interface_adapter.add_user.AddUserState;
import interface_adapter.add_user.AddUserViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AddUserView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Add User Account";

    private final AddUserViewModel addUserViewModel;
    private final JTextField usernameInputField = new JTextField(15);
    private final JTextField nameInputField = new JTextField(15);
    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final AddUserController addUserController;


    private final JButton addUser;


    public AddUserView(AddUserController controller,
                                  AddUserViewModel addUserViewModel){

        this.addUserController = controller;
        this.addUserViewModel = addUserViewModel;
        addUserViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(AddUserViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel(AddUserViewModel.USERNAME_LABEL), usernameInputField);
        LabelTextPanel nameInfo = new LabelTextPanel(
                new JLabel(AddUserViewModel.NAME_LABEL), nameInputField);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel(AddUserViewModel.PASSWORD_LABEL), passwordInputField);

        JPanel buttons = new JPanel();
        addUser = new JButton(AddUserViewModel.SIGNUP_BUTTON_LABEL);
        buttons.add(addUser);

        addUser.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        AddUserState currentState = addUserViewModel.getState();

                        addUserController.execute(
                                currentState.getName(),
                                currentState.getUsername(),
                                currentState.getPassword()
                        );
                    }
                }
        );


        // This makes a new KeyListener implementing class, instantiates it, and
        // makes it listen to keystrokes in the usernameInputField.
        //
        // Notice how it has access to instance variables in the enclosing class!
        usernameInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        AddUserState currentState = addUserViewModel.getState();
                        String text = usernameInputField.getText() + e.getKeyChar();
                        currentState.setUsername(text);
                        addUserViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        nameInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        AddUserState currentState = addUserViewModel.getState();
                        String text = nameInputField.getText() + e.getKeyChar();
                        currentState.setName(text);
                        addUserViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed (KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e){

                    }
                }
        );

        passwordInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        AddUserState currentState = addUserViewModel.getState();
                        currentState.setPassword(passwordInputField.getText() + e.getKeyChar());
                        addUserViewModel.setState(currentState);
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
        this.add(nameInfo);
        this.add(passwordInfo);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        /* AddUserState state = (AddUserState) evt.getNewValue();
        if (state.getUsernameError() != null) {
            JOptionPane.showMessageDialog(this, state.getUsernameError());
        } */
    }
}