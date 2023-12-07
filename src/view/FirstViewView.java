package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.first_view.FirstViewController;
import interface_adapter.first_view.FirstViewViewModel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The FirstViewView class represents the UI for the initial view (first view) use case.
 * It extends JPanel and implements the ActionListener, PropertyChangeListener interfaces
 * The view has two buttons, a signin and a signup button
 * The class is fundamentally responsible for navigating a user to the signin or signup pages
 *
 * @author audrey
 * @version 1.0
 */
public class FirstViewView extends JPanel implements ActionListener, PropertyChangeListener { // testing commits
    public final String viewName = "First View";

    private final FirstViewViewModel firstViewViewModel;
    private final FirstViewController firstViewController;
    private final ViewManagerModel viewManagerModel;

    private final JButton signin;
    private final JButton signup;

    public FirstViewView(FirstViewController controller, FirstViewViewModel firstViewViewModel,
                      ViewManagerModel viewManagerModel) {

        this.firstViewController = controller;
        this.firstViewViewModel = firstViewViewModel;
        this.viewManagerModel = viewManagerModel;
        firstViewViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(FirstViewViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        signin = new JButton(FirstViewViewModel.SIGNIN_BUTTON_LABEL);
        buttons.add(signin);
        signup = new JButton(FirstViewViewModel.SIGNUP_BUTTON_LABEL);
        buttons.add(signup);

        signin.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {

                        System.out.println("Add User button clicked!"); // checking program registers button was clicked
                        firstViewController.execute("signin");
                        viewManagerModel.setActiveView("Signin");
                        viewManagerModel.firePropertyChanged();
                    }
                }
        );

        signup.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        System.out.println("Add Business button clicked!"); // checking program registers button was clicked
                        firstViewController.execute("sign up");
                        viewManagerModel.setActiveView("Signup");
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

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }
}