package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.seached_name.SearchedNameState;
import interface_adapter.seached_name.SearchedNameViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SearchedNameView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "searched name";

    private final SearchedNameViewModel searchedNameViewModel;
    private final ViewManagerModel viewManagerModel;

    private JTextArea searchResultsArea;

    final JButton newSearch;
    final JButton logOut;

    final JLabel Term;
    final JLabel Location;


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
        logOut = new JButton(SearchedNameViewModel.LOG_OUT);
        buttons.add(newSearch);
        buttons.add(logOut);

        newSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchedNameView.this.viewManagerModel.setActiveView("search name"); // switches to MainMenuView
                SearchedNameView.this.viewManagerModel.firePropertyChanged();
            }
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
        searchResultsArea = new JTextArea(20, 40);
        searchResultsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(searchResultsArea); // adds scroll bar to text area
        searchResultsArea.setText(searchedNameViewModel.getState().getSearchResults());


        add(title);
        add(scrollPane);
        add(Term);
        add(Location);
        add(buttons);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "Not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SearchedNameState state = (SearchedNameState) evt.getNewValue();
        searchResultsArea.setText(state.getSearchResults());
        Term.setText(state.getTerm());
        Location.setText(state.getLocation());
        //JScrollPane scrollPane = new JScrollPane(searchResultsArea); // adds scroll bar to text area

    }
}
