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
    /**
     * The label for the title of the Sign Up View.
     */
    public static final String TITLE_LABEL = "Sign Up View";

    /**
     * The label for the business username input field.
     */
    public static final String USERNAME_LABEL = "Choose your business username";

    /**
     * The label for the business name input field.
     */
    public static final String NAME_LABEL = "Enter your business' name";

    /**
     * The label for the password input field.
     */
    public static final String PASSWORD_LABEL = "Choose a password";

    /**
     * The label for the business address input field.
     */
    public static final String ADDRESS_LABEL = "Enter your business' address";

    /**
     * The label for the business category input field.
     */
    public static final String CATEGORY_LABEL = "Enter your business' category";

    /**
     * The label for the Sign Up button.
     */
    public static final String SIGNUP_BUTTON_LABEL = "Sign up";

    /**
     * The label for the Back button.
     */
    public static final String BACK_BUTTON_LABEL = "Back";

    /**
     * The current state of the AddBusinessAccount feature, encapsulating the entered information and validation errors.
     */
    private AddBusinessAccountState state = new AddBusinessAccountState();


    /**
     * Constructs an AddBusinessAccountViewModel with the default view name.
     */
    public AddBusinessAccountViewModel() {
        super("sign up");
    }

    /**
     * Sets the state of the view model.
     *
     * @param state The new state to set.
     */
    public void setState(AddBusinessAccountState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Notifies registered listeners about changes in the view model's state.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a property change listener to the view model.
     *
     * @param listener The listener to be added.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Gets the current state of the view model.
     *
     * @return The current state.
     */
    public AddBusinessAccountState getState() {
        return state;
    }
}

