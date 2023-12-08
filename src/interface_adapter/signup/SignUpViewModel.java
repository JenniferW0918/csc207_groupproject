package interface_adapter.signup;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * This view model class is responsible for managing the view state and interactions related to the sign up
 * (account type selection) operation.
 * It extends the ViewModel class and includes constants for labels used in the view for account type selection.
 *
 * This class encapsulates an SignUpState object representing the current state of the account type selection view.
 * It provides methods for setting and retrieving the state and notifying observers of any changes through
 * the PropertyChangeSupport utility class.
 *
 * @author jenniferwang
 * @version 1.0
 */
public class SignUpViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Choose an Account";
    public static final String USER_BUTTON_LABEL = "Create User";
    public static final String BUSINESS_BUTTON_LABEL = "Create Business";
    public static final String BACK_BUTTON_LABEL = "Back";

    private SignUpState state = new SignUpState();

    /**
     * Constructor for creating an instance of SignUpViewModel. It sets the view name for the ViewModel.
     */
    public SignUpViewModel() {

        super("sign up");
    }

    /**
     * Sets the state of the sign up account type selection view.
     *
     * @param state the new state to set to
     */
    public void setState(SignUpState state) {

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
     * Retrieves the current state of the sign up account type selection view.
     *
     * @return the current state encapsulated in an SignUpState object
     */
    public SignUpState getState() {

        return state;
    }
}
