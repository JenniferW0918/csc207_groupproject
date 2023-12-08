package interface_adapter;


import java.beans.PropertyChangeListener;

/**
 * The abstract ViewModel class serves as a base class for specific view models in the application.
 * It encapsulates common functionality related to managing the view name and property change events.
 *
 * @author audrey
 * @version 1.0
 */
public abstract class ViewModel {

    /** The name of the associated view. */
    private String viewName;

    /**
     * Constructs a ViewModel with the specified view name.
     *
     * @param viewName The name of the associated view.
     */
    public ViewModel(String viewName) {
        this.viewName = viewName;
    }

    public String getViewName() {
        return this.viewName;
    }

    public abstract void firePropertyChanged();
    public abstract void addPropertyChangeListener(PropertyChangeListener listener);


}
