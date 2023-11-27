package view;

import interface_adapter.signup.SignUpController;
import interface_adapter.signup.SignUpState;
import interface_adapter.signup.SignUpViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SignUpView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Account Creation";

    private final SignUpViewModel signupViewModel;
    private final SignUpController signupController;

    private final JButton createUser;
    private final JButton createBusiness;

    public SignUpView(SignUpController controller, SignUpViewModel signupViewModel) {

        this.signupController = controller;
        this.signupViewModel = signupViewModel;
        signupViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(SignUpViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        createUser = new JButton(SignUpViewModel.USER_BUTTON_LABEL);
        buttons.add(createUser);
        createBusiness = new JButton(SignUpViewModel.BUSINESS_BUTTON_LABEL);
        buttons.add(createBusiness);

        createUser.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(createUser)) {
                            SignUpState currentState = signupViewModel.getState();

                            signupController.execute(
                                    currentState.getAccountType()
                            );
                        }
                    }
                }
        );

        createBusiness.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        SignUpState currentState = signupViewModel.getState();

                        signupController.execute(
                                currentState.getAccountType()
                        );
                    }
                }
        );

        // This makes a new KeyListener implementing class, instantiates it, and
        // makes it listen to keystrokes in the usernameInputField.
        //
        // Notice how it has access to instance variables in the enclosing class!

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
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
        SignUpState state = (SignUpState) evt.getNewValue();
    }
}