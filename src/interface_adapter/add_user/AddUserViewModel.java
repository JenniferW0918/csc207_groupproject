package interface_adapter.add_user;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * This view model class is responsible for managing the view state and interactions related to the add user operation.
 * It extends the ViewModel class and includes constants for labels used in the view for user sign up.
 *
 * This class encapsulates an AddUserState object representing the current state of the user sign up view.
 * It provides methods for setting and retrieving the state and notifying observers of any changes through
 * the PropertyChangeSupport utility class.
 *
 * @author jenniferwang
 * @version 1.0
 */
public class AddUserViewModel extends ViewModel {

    public static final String USERNAME_LABEL = "Create Username";
    public static final String NAME_LABEL = "Choose Name";
    public static final String PASSWORD_LABEL = "Create Password";
    public static final String SIGNUP_BUTTON_LABEL = "Create Account";
    public static final String TITLE_LABEL = "Sign Up";
    public static final String BACK_BUTTON_LABEL = "Back";

    private AddUserState state = new AddUserState();

    /**
     * Constructor for creating an instance of AddUserViewModel. It sets the view name for the ViewModel.
     */
    public AddUserViewModel() {
        super("sign up");
    }

    /**
     * Sets the state of the user sign up view.
     *
     * @param state the new state to set to
     */
    public void setState(AddUserState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Alerts observers of changes in the ViewModel's state.
     * This method is usually called by the presenter to notify the ViewModel to update the active view.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a property change listener to the ViewModel.
     *
     * @param listener the PropertyChangeListener to add
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Retrieves the current state of the user sign up view.
     *
     * @return the current state encapsulated in an AddUserState object
     */
    public AddUserState getState() {
        return state;
    }
}