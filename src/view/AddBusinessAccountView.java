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
    public final String viewName = "Add Business Account";

    private final AddBusinessAccountViewModel addBusinessAccountViewModel;
    private final JTextField usernameInputField = new JTextField(15);
    private final JTextField nameInputField = new JTextField(15);
    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JTextField addressInputField = new JTextField(15);
    private final JTextField categoriesInputField = new JTextField(15);
    private final AddBusinessAccountController addBusinessAccountController;


    private final JButton addBusinessAccount;


    public AddBusinessAccountView(AddBusinessAccountController controller,
                                  AddBusinessAccountViewModel addBusinessAccountViewModel){

        this.addBusinessAccountController = controller;
        this.addBusinessAccountViewModel = addBusinessAccountViewModel;
        addBusinessAccountViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(AddBusinessAccountViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel(AddBusinessAccountViewModel.USERNAME_LABEL), usernameInputField);
        LabelTextPanel nameInfo = new LabelTextPanel(
                new JLabel(AddBusinessAccountViewModel.NAME_LABEL), nameInputField);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel(AddBusinessAccountViewModel.PASSWORD_LABEL), passwordInputField);
        LabelTextPanel addressInfo = new LabelTextPanel(
                new JLabel(AddBusinessAccountViewModel.ADDRESS_LABEL), addressInputField);
        LabelTextPanel categoriesInfo = new LabelTextPanel(
                new JLabel(AddBusinessAccountViewModel.CATEGORY_LABEL), categoriesInputField);

        JPanel buttons = new JPanel();
        addBusinessAccount = new JButton(AddBusinessAccountViewModel.SIGNUP_BUTTON_LABEL);
        buttons.add(addBusinessAccount);

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
                                    currentState.getCategory()
                            );

                            usernameInputField.setText("");
                            nameInputField.setText("");
                            passwordInputField.setText("");
                            addressInputField.setText("");
                            categoriesInputField.setText("");
                            currentState.setUsername("");
                            currentState.setName("");
                            currentState.setPassword("");
                            currentState.setAddress("");
                            currentState.setCategory("");
                            addBusinessAccountViewModel.setState(currentState);
                            addBusinessAccountViewModel.firePropertyChanged();
                        }
                    }
                }
        );


        // This makes a new KeyListener implementing class, instantiates it, and
        // makes it listen to keystrokes in the usernameInputField.
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

        nameInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        AddBusinessAccountState currentState = addBusinessAccountViewModel.getState();
                        currentState.setName(nameInputField.getText() + e.getKeyChar());
                        addBusinessAccountViewModel.setState(currentState);
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

        addressInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        AddBusinessAccountState currentState = addBusinessAccountViewModel.getState();
                        currentState.setAddress(addressInputField.getText() + e.getKeyChar());
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

        categoriesInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        AddBusinessAccountState currentState = addBusinessAccountViewModel.getState();
                        currentState.setCategory(categoriesInputField.getText() + e.getKeyChar());
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


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(nameInfo);
        this.add(passwordInfo);
        this.add(addressInfo);
        this.add(categoriesInfo);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}