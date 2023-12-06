package view;

import entity.Business;
import entity.SearchNameResult;
import interface_adapter.ViewManagerModel;
import interface_adapter.seached_name.SearchedNameState;
import interface_adapter.seached_name.SearchedNameViewModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SearchedNameView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "searched name";

    private final SearchedNameViewModel searchedNameViewModel;
    private final ViewManagerModel viewManagerModel;

    final JTextArea searchResultsArea;

    final JButton newSearch;
    final JButton logOut;

    final JLabel Term;
    final JLabel Location;

//    final JList<String> jList;


    public SearchedNameView(SearchedNameViewModel searchedNameViewModel, ViewManagerModel viewManagerModel) {
        this.viewManagerModel = viewManagerModel;
        this.searchedNameViewModel = searchedNameViewModel;

        this.searchedNameViewModel.addPropertyChangeListener(this);



        // Adding titles and Labels.
        JLabel title = new JLabel(SearchedNameViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        Term = new JLabel();
        Location = new JLabel();


        //ADDING Buttons
        JPanel buttons = new JPanel();
        newSearch = new JButton(SearchedNameViewModel.NEW_SEARCH);
        buttons.add(newSearch);
        logOut = new JButton(SearchedNameViewModel.LOG_OUT);
        buttons.add(logOut);
        
        newSearch.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(newSearch)) {
                SearchedNameView.this.viewManagerModel.setActiveView("search name");
                SearchedNameView.this.viewManagerModel.firePropertyChanged();

                // Reset the state of the view model.
                SearchedNameState currentState = searchedNameViewModel.getState();
                currentState.setSearchResults("");
                currentState.setTerm("");
                currentState.setLocation("");
                searchedNameViewModel.setState(currentState);
                searchedNameViewModel.firePropertyChanged();
            }}
        });

        logOut.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        SearchedNameView.this.viewManagerModel.setActiveView("Account Creation"); // switches to SignUpView
                        SearchedNameView.this.viewManagerModel.firePropertyChanged();
                    }
        });


        // Adding SEARCH RESULTS
        searchResultsArea = new JTextArea(15, 25);
        searchResultsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(searchResultsArea); // adds scroll bar to text area
        searchResultsArea.setText(searchedNameViewModel.getState().getSearchResults());


        // Adding JList
//        String[] data =  searchedNameViewModel.getState().getSearchResultsList() /* {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"}*/;
//
//        jList = new JList<>(data);
//        jList.setVisibleRowCount(8);
//
//        JScrollPane scrollPane2 = new JScrollPane(jList);
//        JLabel selectedLabel = new JLabel("Selected Item: ");
//
//        jList.addListSelectionListener(new ListSelectionListener() {
//            public void valueChanged(ListSelectionEvent e) {
//                // Get the selected item from the JList
//                String selectedValue = jList.getSelectedValue();
//                // Update the JLabel to display the selected item
//                selectedLabel.setText("Selected Item: " + selectedValue);
//            }
//        }
//        );
//
//        JPanel panel = new JPanel();
//        panel.add(selectedLabel);


        add(title);
        add(scrollPane);
        add(Term);
        add(Location);
        add(buttons);
//        add(scrollPane2);
//        add(panel);
    }


    public void actionPerformed(ActionEvent e) {
        System.out.println("Event source: " + e.getSource());

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SearchedNameState state = (SearchedNameState) evt.getNewValue();
        searchResultsArea.setText(state.getSearchResults());
        Term.setText(state.getTerm());
        Location.setText(state.getLocation());

    }
}
