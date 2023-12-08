package interface_adapter.signin;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

/**
 * The SignInViewModel class serves as the ViewModel for the signin view.
 * It encapsulates the presentation logic and state related to the signin process for both a user and business account.
 * The ViewModel provides labels for various UI elements, such as titles, input fields, and buttons.
 * It also holds the current state of the signin form.
 * This class extends the base ViewModel class and implements property change support for data binding.
 *
 * The labels and button texts defined in this class are used for UI elements in the associated view.
 *
 * @author audrey
 * @version 1.0
 */
public class SignInViewModel extends ViewModel {


    /**
     * The title label for the sign-in view.
     */
    public final String TITLE_LABEL = "Sign in View";

    /**
     * The username label for the sign-in view.
     */
    public final String USERNAME_LABEL = "enter your username";

    /**
     * The password label for the sign-in view.
     */
    public final String PASSWORD_LABEL = "enter your password";

    /**
     * The label for the sign-in button.
     */
    public static final String SIGNIN_BUTTON_LABEL = "Sign in";

    /**
     * The label for the back button.
     */
    public static final String BACK_BUTTON_LABEL = "Back";

    /**
     * The state of the sign-in view, encapsulated in the SignInState class.
     */
    private SignInState state = new SignInState();

    /**
     * Constructs a SignInViewModel with the name "signin" for identification.
     */
    public SignInViewModel() {
        super("signin");
    }

    /**
     * Sets the state of the sign-in view.
     *
     * @param state The new state.
     */
    public void setState(SignInState state) {
        this.state = state;
    }

    /**
     * Gets the current state of the sign-in view.
     *
     * @return The current state.
     */
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Notifies property change listeners about changes in the state.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a property change listener to be notified about changes in the state.
     *
     * @param listener The property change listener to add.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public SignInState getState() {
        return state;
    }
}
