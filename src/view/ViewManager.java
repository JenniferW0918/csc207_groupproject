package view;

import interface_adapter.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


/**
 * The ViewManager class is responsible for managing the views in a CardLayout and switching between them based on
 * changes in the associated ViewManagerModel. It implements PropertyChangeListener to listen for changes in the
 * active view name and updates the CardLayout accordingly.
 *
 * @author audrey
 * @version 1.0
 */
public class ViewManager implements PropertyChangeListener {

    /** The CardLayout used to manage the views. */
    private final CardLayout cardLayout;

    /** The JPanel containing the views managed by the CardLayout. */
    private final JPanel views;

    /** The model representing the state of the view manager. */
    private ViewManagerModel viewManagerModel;

    /**
     * Constructs a ViewManager with the specified JPanel, CardLayout, and ViewManagerModel.
     *
     * @param views             The JPanel containing the views managed by the CardLayout.
     * @param cardLayout        The CardLayout used to manage the views.
     * @param viewManagerModel The model representing the state of the view manager.
     */
    public ViewManager(JPanel views, CardLayout cardLayout, ViewManagerModel viewManagerModel) {
        this.views = views;
        this.cardLayout = cardLayout;
        this.viewManagerModel = viewManagerModel;
        this.viewManagerModel.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("view")) {
            String viewModelName = (String) evt.getNewValue();
            cardLayout.show(views, viewModelName);
        }
    }
}
