package interface_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The ViewManagerModel class represents the model responsible for managing the active view in the application.
 * It maintains information about the currently active view and provides methods for updating and notifying observers.
 *
 * @author audrey
 * @version 1.0
 */
public class ViewManagerModel {

    /** The name of the currently active view. */
    private String activeViewName;

    /** PropertyChangeSupport for managing listeners interested in view changes. */
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Gets the name of the currently active view.
     *
     * @return The name of the active view.
     */
    public String getActiveView() {
        return activeViewName;
    }

    /**
     * Sets the name of the currently active view.
     *
     * @param activeView The name of the view to set as active.
     */
    public void setActiveView(String activeView) {
        this.activeViewName = activeView;
    }

    public void firePropertyChanged() {
        support.firePropertyChange("view", null, this.activeViewName);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
