package view;

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

public class SearchNameView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "search name";

    final JTextField termInputField = new JTextField(15);

    final JTextField locationInputField = new JTextField(15);

    final JButton searchName;


    public SearchNameView(SearchNameController searchNameController, SearchNameViewModel searchNameViewModel) {

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
                        }
                    }
                }
        );


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        this.add(title);
        this.add(termInfo);
        this.add(locationInfo);
        this.add(buttons);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "Not implemented yet.");
        System.out.println("Click " +e.getActionCommand());
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SearchNameState state = (SearchNameState) evt.getNewValue();
    }
}





