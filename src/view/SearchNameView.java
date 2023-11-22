package view;

import interface_adapter.search_name.SearchNameController;
import interface_adapter.search_name.SearchNameState;
import interface_adapter.search_name.SearchNameViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SearchNameView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "search name";

    private final SearchNameViewModel searchNameViewModel;

    private final SearchNameController searchNameController;

    final JTextField termInputField = new JTextField(15);
    private final JLabel termErrorField = new JLabel();

    final JTextField locationInputField = new JTextField(15);
    private final JLabel locationErrorField = new JLabel();

    final JButton searchName;

    // Should I add CANCEL/CLEAR???
    final JButton clear;


    public SearchNameView(SearchNameViewModel searchNameViewModel, SearchNameController searchNameController) {
        this.searchNameViewModel = searchNameViewModel;
        this.searchNameController = searchNameController;
        this.searchNameViewModel.addPropertyChangeListener(this);

       //ADDING Buttons
        JPanel buttons = new JPanel();
        searchName = new JButton(SearchNameViewModel.SEARCH_NAME_BUTTON_LABEL);
        buttons.add(searchName);


        clear = new JButton(SearchNameViewModel.CLEAR_BUTTON_LABEL);
        buttons.add(clear);

        //ADDING and instantiating anonymous ActionListeners
        searchName.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(searchName)) {
                            SearchNameState currentState = searchNameViewModel.getState();

                            searchNameController.execute(
                                    currentState.getTerm(),
                                    currentState.getLocation()
                            );
                        }
                    }
                }
        );

        clear.addActionListener(this);

        //Adding key listener for TERM
        termInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                SearchNameState currentState = searchNameViewModel.getState();
                currentState.setTerm(termInputField.getText() + e.getKeyChar());
                searchNameViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //Adding key listener for LOCATION

        locationInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SearchNameState currentState = searchNameViewModel.getState();
                        currentState.setLocation(locationInputField.getText() + e.getKeyChar());
                        searchNameViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        /*Confused on what this means **/
//        this.add(title);
//        this.add(termInfo);
        this.add(termErrorField);
//        this.add(locationInfo);
        this.add(locationErrorField);
        this.add(buttons);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SearchNameState state = (SearchNameState) evt.getNewValue();
        setFields(state);
    }

    // HELPER METHOD
    private void setFields(SearchNameState state) {
        termInputField.setText(state.getTerm());
    }
}





