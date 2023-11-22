package interface_adapter.seached_name;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**Showing search results.**/
public class SearchedNameViewModel extends ViewModel {
    public static final String TITLE_LABEL = "View of Searches";
    public static final String MAIN_MENU = "Main Menu";

    private SearchedNameState state = new SearchedNameState();


    public SearchedNameViewModel() {
        super("searched name");
    }

    public void setState(SearchedNameState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);


    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public SearchedNameState getState() {
        return state;
    }

}