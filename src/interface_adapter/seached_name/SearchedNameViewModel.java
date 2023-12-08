package interface_adapter.seached_name;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The SearchedNameViewModel class extends the ViewModel class and is responsible
 * for managing the state of the SearchedNameView.
 */
public class SearchedNameViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Search Results";

    public static final String NEW_SEARCH = "New Search";
    public static final String LOG_OUT = "Log Out";

    public String Term;
    public String Location;


    private SearchedNameState state = new SearchedNameState();

    /** The constructor for the SearchedNameViewModel*/
    public SearchedNameViewModel() {
        super("searched name");
    }

    /** This method sets the state of the SearchedNameViewModel.
     * @param state The state of the SearchedNameViewModel.
     */
    public void setState(SearchedNameState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /** This method fires a property change event.
     */
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /** This method adds a property change listener to the support object.
     * @param listener The listener to add.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /** This method returns the state of the SearchedNameViewModel.
     * @return The state of the SearchedNameViewModel.
     */
    public SearchedNameState getState() {
        return state;
    }

}