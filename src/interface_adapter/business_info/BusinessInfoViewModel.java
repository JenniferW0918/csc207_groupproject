package interface_adapter.business_info;
import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The BusinessInfoViewModel class extends the ViewModel class and is responsible for
 * managing the state of the BusinessInfoView.
 */
public class BusinessInfoViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Business Information";

    public static final String RETURN_SEARCH_RESULTS = "Return";

    public static final String URL_LABEL = "Link";

    private BusinessInfoState state = new BusinessInfoState();


    /**
     * This constructor creates a new BusinessInfoViewModel object.
     */
    public BusinessInfoViewModel() {
        super("Business Information");
    }

    /**
     * This method sets the state of the BusinessInfoViewModel.
     * @param state The state of the BusinessInfoViewModel.
     */
    public void setState(BusinessInfoState state) {
        this.state = state;
    }

    /**
     * This method returns the state of the BusinessInfoViewModel.
     * @return The state of the BusinessInfoViewModel.
     */
    public BusinessInfoState getState() {
        return state;
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

}