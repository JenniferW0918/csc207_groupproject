package view;

import entity.Business;
import entity.SearchNameResult;
import interface_adapter.ViewManagerModel;
import interface_adapter.business_info.BusinessInfoState;
import interface_adapter.business_info.BusinessInfoViewModel;
import interface_adapter.seached_name.SearchedNameState;
import interface_adapter.seached_name.SearchedNameViewModel;
import org.json.JSONObject;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class SearchedNameView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "searched name";

    private final ViewManagerModel viewManagerModel;
    final JButton newSearch;
    final JButton logOut;
    final JList<String> jList;


    public SearchedNameView(SearchedNameViewModel searchedNameViewModel, ViewManagerModel viewManagerModel, BusinessInfoViewModel businessInfoViewModel){
        this.viewManagerModel = viewManagerModel;
        searchedNameViewModel.addPropertyChangeListener(this);


        // Adding titles and Labels.
        JLabel title = new JLabel(SearchedNameViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);


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
                        SearchedNameView.this.viewManagerModel.setActiveView("First View"); // switches to first view
                        SearchedNameView.this.viewManagerModel.firePropertyChanged();

                        // Reset the state of the view model.
                        SearchedNameState currentState = searchedNameViewModel.getState();
                        currentState.setTerm("");
                        currentState.setLocation("");
                        searchedNameViewModel.setState(currentState);
                        searchedNameViewModel.firePropertyChanged();
                    }
                });


        // Adding JList
        SearchNameResult searchNameResult = searchedNameViewModel.getState().getSearchResultsInteractive();
        String[] data;
        if (searchNameResult != null) {
            data = searchNameResult.toList();
        } else {
            data = new String[]{};
        }


        jList = new JList<>();
        jList.setVisibleRowCount(15);

        JScrollPane scrollPane2 = new JScrollPane(jList);
        jList.setListData(data);
        JLabel selectedLabel = new JLabel("Selected Item: ");

        jList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
            // Get the selected item from the JList
            String selectedValue = jList.getSelectedValue();
                                               // Update the JLabel to display the selected item
                                               selectedLabel.setText("Selected Item: " + selectedValue);

/*
                Update the state of business info view model
*/          BusinessInfoState businessInfoState = businessInfoViewModel.getState();
            SearchNameResult searchNameResult2 = searchedNameViewModel.getState().getSearchResultsInteractive();
            businessInfoState.setBusinessName(searchNameResult2.getBusinesses().get(jList.getSelectedIndex()).getName());
            businessInfoState.setBusinessAddress(searchNameResult2.getBusinesses().get(jList.getSelectedIndex()).getAddress());
            businessInfoState.setBusinessUrl(searchNameResult2.getBusinesses().get(jList.getSelectedIndex()).getUrl());
            businessInfoState.setBusinessReviews(searchNameResult2.getBusinesses().get(jList.getSelectedIndex()).getReviews());

            // Setting business status
            boolean isClosed = searchNameResult2.getBusinesses().get(jList.getSelectedIndex()).is_Closed();
            if (isClosed) {
                businessInfoState.setStatus("No");
                } else {
                businessInfoState.setStatus("Yes");
                }

                // Switch to business info view
                SearchedNameView.this.viewManagerModel.setActiveView("Business Information");
                SearchedNameView.this.viewManagerModel.firePropertyChanged();

                //   Update the state of the business info view model
                businessInfoViewModel.setState(businessInfoState);
                businessInfoViewModel.firePropertyChanged();

                                           }
                                       }
        );

        JPanel panel = new JPanel();
        panel.add(selectedLabel);

        add(title);
        add(scrollPane2);
        add(panel);
        add(buttons);
    }


    public void actionPerformed(ActionEvent e) {
        System.out.println("Event source: " + e.getSource());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SearchedNameState state = (SearchedNameState) evt.getNewValue();
        if (state.getSearchResultsInteractive() == null) {
            jList.setListData(new String[]{});
        }
        else{
            jList.setListData(state.getSearchResultsInteractive().toList());
        }
    }

}