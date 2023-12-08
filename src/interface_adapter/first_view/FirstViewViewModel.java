package interface_adapter.first_view;

import interface_adapter.ViewModel;
import interface_adapter.signup.SignUpState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The FirstViewViewModel class serves as the ViewModel for the first view's view.
 * It encapsulates the presentation logic and state related to the letting the user choose whether to signin or signup.
 * The ViewModel provides labels for various UI elements, such as titles, input fields, and buttons.
 * This class extends the base ViewModel class and implements property change support for data binding.
 *
 * The labels and button texts defined in this class are used for UI elements in the associated view.
 *
 * @author audrey
 * @version 1.0
 */
public class FirstViewViewModel extends ViewModel {

    /**
     * The title label for the First View.
     */
    public static final String TITLE_LABEL = "Sign in or Sign up";

    /**
     * The label for the Sign in button.
     */
    public static final String SIGNIN_BUTTON_LABEL = "Sign in";

    /**
     * The label for the Sign up button.
     */
    public static final String SIGNUP_BUTTON_LABEL = "Sign up";

    /**
     * The internal state representing the user's choice of signing in or signing up.
     */
    private FirstViewState state = new FirstViewState();

    /**
     * Constructs a FirstViewViewModel with the specified view name.
     * Initializes the internal state with a new instance of FirstViewState.
     *
     * @param viewName The name of the view associated with this ViewModel.
     */
    public FirstViewViewModel() {

        super("first view");
    }

    /**
     * Sets the internal state of the ViewModel with the provided FirstViewState.
     *
     * @param state The new state representing the user's choice of signing in or signing up.
     */
    public void setState(FirstViewState state) {

        this.state = state;
    }

    /**
     * Notifies registered listeners about a change in the internal state.
     */
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Notifies registered listeners about a change in the internal state.
     */
    public void firePropertyChanged() {

        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a listener for state change events.
     *
     * @param listener The listener to be added.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Retrieves the current state representing the user's choice of signing in or signing up.
     *
     * @return The current FirstViewState.
     */
    public FirstViewState getState() {

        return state;
    }
}