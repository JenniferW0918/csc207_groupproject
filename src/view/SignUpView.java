package view;

import interface_adapter.ViewManagerModel;
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
    private final ViewManagerModel viewManagerModel;

    private final JButton createUser;
    private final JButton createBusiness;

    public SignUpView(SignUpController controller, SignUpViewModel signupViewModel,
                      ViewManagerModel viewManagerModel) {

        this.signupController = controller;
        this.signupViewModel = signupViewModel;
        this.viewManagerModel = viewManagerModel;
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
                            //SignUpState currentState = signupViewModel.getState();
                            System.out.println("Add User button clicked!"); // checking program registers button was clicked
                            signupController.execute("user");
                            viewManagerModel.setActiveView("Add User Account");
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                }
        );

        createBusiness.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        System.out.println("Add Business button clicked!"); // checking program registers button was clicked
                        signupController.execute("business");
                        viewManagerModel.setActiveView("Add Business Account");
                        viewManagerModel.firePropertyChanged();
                    }
                }
        );

        // This makes a new KeyListener implementing class, instantiates it, and
        // makes it listen to keystrokes in the usernameInputField.

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        SignUpState state = (SignUpState) evt.getNewValue();
    }
}