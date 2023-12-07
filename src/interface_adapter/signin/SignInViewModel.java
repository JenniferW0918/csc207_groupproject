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


    public final String TITLE_LABEL = "Sign in View";
    public final String USERNAME_LABEL = "enter your username";
    public final String PASSWORD_LABEL = "enter your password";

    public static final String SIGNIN_BUTTON_LABEL = "Sign in";
    public static final String BACK_BUTTON_LABEL = "Back";

    private SignInState state = new SignInState();

    public SignInViewModel() {
        super("signin");
    }

    public void setState(SignInState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public SignInState getState() {
        return state;
    }
}
