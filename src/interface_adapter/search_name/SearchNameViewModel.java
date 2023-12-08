package interface_adapter.search_name;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/** This class represents the view model SearchNameView.
 * */
public class SearchNameViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Search View";

    public static final String TERM_LABEL = "Type Term:";
    public static final String LOCATION_LABEL = "Type Location:";

    public static final String SEARCH_NAME_BUTTON_LABEL = "Search Name";

    private SearchNameState state = new SearchNameState();

    /**
     * This constructor creates a new SearchNameViewModel object.
     */
    public SearchNameViewModel() {
        super("search name");
    }

    /**
     * This method sets the state of the SearchNameViewModel.
     * @param state The new state.
     */
    public void setState(SearchNameState state) {
        this.state = state;
    }


    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * This method fires a property change event.
     */
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * This method adds a property change listener to the support object.
     * @param listener The listener to add.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * This method returns the current state of the SearchNameViewModel.
     * @return The current state.
     */
    public SearchNameState getState() {
        return state;
    }

}