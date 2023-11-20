package interface_adapter.search_name;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SearchNameViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Search View";
    public static final String TERM_LABEL = "Type Term";
    public static final String LOCATION_LABEL = "Type Location";

    public static final String SEARCH_NAME_BUTTON_LABEL = "Search Name";

    public static final String CLEAR_BUTTON_LABEL = "Clear";

    private SearchNameState state = new SearchNameState();

    public SearchNameViewModel() {
        super("search name");
    }

    public void setState(SearchNameState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);



    //Signup Presenter will call to let the ViewModel know to alert the View

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public SearchNameState getState() {
        return state;
    }

}