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

    public static final String TITLE_LABEL = "Sign in or Sign up";
    public static final String SIGNIN_BUTTON_LABEL = "Sign in";
    public static final String SIGNUP_BUTTON_LABEL = "Sign up";

    private FirstViewState state = new FirstViewState();

    public FirstViewViewModel() {

        super("first view");
    }

    public void setState(FirstViewState state) {

        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Frist View Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {

        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public FirstViewState getState() {

        return state;
    }
}