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

/**
 * The SignUpView class represents the GUI for the Sign Up (account type selection) use case.
 * It allows users to choose between creating a user or a business account.
 */
public class SignUpView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "sign up";

    private final SignUpViewModel signupViewModel;
    private final SignUpController signupController;
    private final ViewManagerModel viewManagerModel;

    private final JButton createUser;
    private final JButton createBusiness;
    private final JButton back;

    /**
     * Constructs an instance of SignUpView given the specified controller, ViewModel and ViewManagerModel.
     * @param controller the controller that handles user interactions in the SignUpView
     * @param signupViewModel the ViewModel that manages the state and properties of the SignUpView
     * @param viewManagerModel the model that manages the views of the application
     */
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
        back = new JButton(SignUpViewModel.BACK_BUTTON_LABEL);
        buttons.add(back);

        createUser.addActionListener(

                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {

                        System.out.println("Add User button clicked!"); // checking program registers button was clicked
                        signupController.execute("user");
                        viewManagerModel.setActiveView("Add User Account");
                        viewManagerModel.firePropertyChanged();
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

        back.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        viewManagerModel.setActiveView("First View");
                        viewManagerModel.firePropertyChanged();
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(buttons);
    }

    /**
     * React to a button click event.
     *
     * @param evt the action event triggered by a button click
     */
    public void actionPerformed(ActionEvent evt) {

        System.out.println("Click " + evt.getActionCommand());
    }

    /**
     * Handle property change events.
     *
     * @param evt the property change event
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        SignUpState state = (SignUpState) evt.getNewValue();
    }
}