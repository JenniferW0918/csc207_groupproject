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



    public SearchedNameView(SearchedNameViewModel searchedNameViewModel, ViewManagerModel viewManagerModel) {
        this.viewManagerModel = viewManagerModel;
        this.searchedNameViewModel = searchedNameViewModel;

        // Adding titles and Labels.
        JLabel title = new JLabel(SearchedNameViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);


        //ADDING Buttons
        JPanel buttons = new JPanel();
        newSearch = new JButton(SearchedNameViewModel.NEW_SEARCH);
        buttons.add(newSearch);
        newSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchedNameView.this.viewManagerModel.setActiveView("search name"); // switches to MainMenuView
                SearchedNameView.this.viewManagerModel.firePropertyChanged();
            }
        });



        // Adding SEARCH RESULTS
        searchResultsArea = new JTextArea(10, 30);
        searchResultsArea.setEditable(false);
        searchResultsArea.setText("Haven't been able to get results to show up here yet.");
        JScrollPane scrollPane = new JScrollPane(searchResultsArea); // adds scroll bar to text area


        add(title);
        add(scrollPane);
        add(buttons);
    }

    public void updateSearchResults(String results) {
        searchResultsArea.setText(results);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "Not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SearchedNameState state = (SearchedNameState) evt.getNewValue();

        updateSearchResults(state.getSearchResults());
    }

}
