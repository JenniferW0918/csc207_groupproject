package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.main_menu.MainMenuState;
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

    //    JLabel term;
//    JLabel location;
    private JList<String> businessList;
//    final JButton exit;



    public SearchedNameView(SearchedNameViewModel searchedNameViewModel, ViewManagerModel viewManagerModel) {
        this.viewManagerModel = viewManagerModel;
        this.searchedNameViewModel = searchedNameViewModel;
//        term = new JLabel("term");
//        location = new JLabel("location");
        businessList = new JList<>();


        // Adding titles and Labels.
        JLabel title = new JLabel(SearchedNameViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

//        LabelTextPanel termInfo = new LabelTextPanel(
//                new JLabel(SearchedNameViewModel.TERM_LABEL), termInputField);
//        LabelTextPanel locationInfo = new LabelTextPanel(
//                new JLabel(SearchedNameViewModel.LOCATION_LABEL), locationInputField);



        //ADDING Buttons
        JPanel buttons = new JPanel();
//        exit = new JButton(SearchedNameViewModel.MAIN_MENU);
//        buttons.add(exit);
//        exit.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                SearchedNameView.this.viewManagerModel.setActiveView("main menu"); // switches to MainMenuView
//                SearchedNameView.this.viewManagerModel.firePropertyChanged();
//            }
//        });
        add(title);
        add(businessList);
        add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "Not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SearchedNameState state = (SearchedNameState) evt.getNewValue();
    }

}
