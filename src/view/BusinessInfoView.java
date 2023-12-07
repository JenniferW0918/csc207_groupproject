package view;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


import interface_adapter.ViewManagerModel;
import interface_adapter.business_info.BusinessInfoState;
import interface_adapter.business_info.BusinessInfoViewModel;
import interface_adapter.seached_name.SearchedNameState;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class BusinessInfoView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Business Information";

    //buttons
    final JButton backToResults;

    // business attributes
    final JLabel businessName;
    final JLabel businessAddress;
    final JLabel status;
    final JButton link;
    final JTextArea businessReviews;


    public BusinessInfoView(BusinessInfoViewModel businessInfoViewModel, ViewManagerModel viewManagerModel) {

        businessInfoViewModel.addPropertyChangeListener(this);



        // Adding titles and Labels.
        JLabel title = new JLabel(BusinessInfoViewModel.TITLE_LABEL);
        title.setAlignmentY(Component.TOP_ALIGNMENT);

        //ADDING Buttons
        JPanel buttons = new JPanel();

        link = new JButton(BusinessInfoViewModel.URL_LABEL);
        buttons.add(link);
        link.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String url = businessInfoViewModel.getState().getBusinessUrl();
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    try {
                        Desktop.getDesktop().browse(new URI(url)); // opens url in default browser
                    } catch (IOException | URISyntaxException ex) {
                        ex.printStackTrace(); // How to handle this exception?
                    }
                } else {
                    System.out.println("Desktop browsing is not supported.");
                }
            }
        });


        backToResults = new JButton(BusinessInfoViewModel.RETURN_SEARCH_RESULTS);
        buttons.add(backToResults);
        backToResults.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        viewManagerModel.setActiveView("searched name");
                        viewManagerModel.firePropertyChanged();

                        // Reset the state of the view model.
                        BusinessInfoState currentState = businessInfoViewModel.getState();
                        currentState.setBusinessName("");
                        currentState.setBusinessAddress("");
                        currentState.setStatus("");
                        currentState.setBusinessUrl("");
                        currentState.setBusinessReviews("");
                        businessInfoViewModel.setState(currentState);
                        businessInfoViewModel.firePropertyChanged();
                    }
                })
        ;

        // Adding text area
        businessReviews = new JTextArea(25, 30);
        businessReviews.setEditable(false);
        businessReviews.setText("Reviews: ");
        JScrollPane scrollPane = new JScrollPane(businessReviews); // adds scroll bar to text area

        // Adding Business Labels Info
        businessName = new JLabel("BusinessName: ");
        businessAddress = new JLabel("Address: ");
        status = new JLabel("Open: ");
        JPanel panel = new JPanel();
        panel.add(businessName);
        panel.add(businessAddress);
        panel.add(status);

        add(title);
        add(scrollPane);
        add(panel);
        add(buttons);
    }


    public void actionPerformed(ActionEvent e) {
        System.out.println("Event source: " + e.getSource());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        BusinessInfoState newState = (BusinessInfoState) evt.getNewValue();
        businessName.setText("BusinessName: " + newState.getBusinessName());
        businessAddress.setText("Address: " + newState.getBusinessAddress());
        status.setText("Open: " + newState.getStatus());
        businessReviews.setText("Reviews: \n" + newState.getBusinessReviews());

    }
}