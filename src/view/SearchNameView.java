package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.seached_name.SearchedNameState;
import interface_adapter.seached_name.SearchedNameViewModel;
import interface_adapter.search_name.SearchNameController;
import interface_adapter.search_name.SearchNameState;
import interface_adapter.search_name.SearchNameViewModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * This class represents the view for the search name feature in the application.
 * It extends JPanel and implements ActionListener and PropertyChangeListener.
 * The view consists of input fields for term and location, and buttons for search name and logout.
 * It also listens to changes in the SearchNameViewModel and updates the view accordingly.
 */
public class SearchNameView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "search name";

    final JTextField termInputField = new JTextField(15);

    final JTextField locationInputField = new JTextField(15);

    final JButton searchName;

    final JButton logOut;


    /** This constructor  creates the view for the search name feature.
     * @param searchNameController The controller for the search name use case
     * @param searchNameViewModel The view model for the search name feature.
     * @param viewManagerModel The view manager model.
     * */
    public SearchNameView(SearchNameController searchNameController, SearchNameViewModel searchNameViewModel, ViewManagerModel viewManagerModel) {

        searchNameViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(SearchNameViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel termInfo = new LabelTextPanel(
                new JLabel(SearchNameViewModel.TERM_LABEL), termInputField);
        LabelTextPanel locationInfo = new LabelTextPanel(
                new JLabel(SearchNameViewModel.LOCATION_LABEL), locationInputField);


        //ADDING Buttons
        JPanel buttons = new JPanel();
        searchName = new JButton(SearchNameViewModel.SEARCH_NAME_BUTTON_LABEL);
        buttons.add(searchName);

        logOut = new JButton(SearchedNameViewModel.LOG_OUT);
        buttons.add(logOut);



        //Adding key listener for LOCATION
        locationInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SearchNameState currentState = searchNameViewModel.getState();
                        String location = locationInputField.getText() + e.getKeyChar();
                        currentState.setLocation(location);
                        searchNameViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        termInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SearchNameState currentState = searchNameViewModel.getState();
                        String term = termInputField.getText() + e.getKeyChar();
                        currentState.setTerm(term);
                        searchNameViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        searchName.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(searchName)) {

                            // Now update the state
                            SearchNameState currentState = searchNameViewModel.getState();
                            searchNameController.execute(currentState.getTerm(), currentState.getLocation());

                            // Clear the term and location fields
                            termInputField.setText("");
                            locationInputField.setText("");
                            // Clear the state
                            currentState.setTerm("");
                            currentState.setLocation("");
                            searchNameViewModel.setState(currentState);
                            searchNameViewModel.firePropertyChanged();
                        }
                    }
                }
        );

        logOut.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        viewManagerModel.setActiveView("First View"); // switches to First View
                        viewManagerModel.firePropertyChanged();
                    }
                });


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        this.add(title);
        this.add(termInfo);
        this.add(locationInfo);
        this.add(buttons);
    }


    /**
     * This method is called when an action is performed.
     * It prints the source of the event to the console
     * @param e The event that was performed.
     * */
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " +e.getActionCommand());
    }

    /**
     * This method is called when a property changes, and it updates the view.
     * @param evt The property change event.
     * */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SearchNameState state = (SearchNameState) evt.getNewValue();
    }
}





