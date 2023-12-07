package interface_adapter.business_info;
import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**Showing search results.**/
public class BusinessInfoViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Business Information";

    public static final String RETURN_SEARCH_RESULTS = "Return";

    public static final String URL_LABEL = "Link";


    private BusinessInfoState state = new BusinessInfoState();


    public BusinessInfoViewModel() {
        super("Business Information");
    }

    public void setState(BusinessInfoState state) {
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

    public BusinessInfoState getState() {
        return state;
    }

}