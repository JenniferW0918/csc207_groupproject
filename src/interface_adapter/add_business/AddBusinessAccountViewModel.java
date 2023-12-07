package interface_adapter.add_business;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The AddBusinessAccountViewModel class serves as the ViewModel for the Add Business Account view.
 * It encapsulates the presentation logic and state related to the sign-up process for a business account.
 * The ViewModel provides labels for various UI elements, such as titles, input fields, and buttons.
 * It also holds the current state of the sign-up form in the form of an AddBusinessAccountState object.
 * This class extends the base ViewModel class and implements property change support for data binding.
 *
 * The labels and button texts defined in this class are used for UI elements in the associated view.
 *
 * @author audrey
 * @version 1.0
 */
public class AddBusinessAccountViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Sign Up View";
    public static final String USERNAME_LABEL = "Choose your business username";

    public static final String NAME_LABEL = "Enter your business' name";
    public static final String PASSWORD_LABEL = "Choose a password";

    public static final String ADDRESS_LABEL = "Enter your business' address";

    public static final String CATEGORY_LABEL = "Enter your business' category";

    public static final String SIGNUP_BUTTON_LABEL = "Sign up";
    public static final String BACK_BUTTON_LABEL = "Back";


    private AddBusinessAccountState state = new AddBusinessAccountState();

    public AddBusinessAccountViewModel() {
        super("sign up");
    }

    public void setState(AddBusinessAccountState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Signup Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public AddBusinessAccountState getState() {
        return state;
    }
}

